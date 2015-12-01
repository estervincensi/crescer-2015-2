package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.DTO.ItemDTO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.PedidoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/itens")
public class ItemController {
	private ItemService itemService;
	private MaterialService materialService;
	private ServicoService servicoService;
	private PedidoService pedidoService;
	
	@Autowired
	public ItemController(ItemService itemService,
						MaterialService materialService,
						PedidoService pedidoService,
						ServicoService servicoService){
		this.itemService = itemService;
		this.materialService = materialService;
		this.pedidoService = pedidoService;
		this.servicoService = servicoService;
	}
	
	@RequestMapping(path = "/manter", method = RequestMethod.POST)
    public ModelAndView manter(@Valid @ModelAttribute("item")ItemDTO itemDTO,
    							BindingResult result,
    							Model model) {
		
		if (result.hasErrors()) {
		    return new ModelAndView("itens/manter");
		}
		
		Item incluido = itemService.incluirItem(itemDTO);	
		if(incluido != null){
			model.addAttribute("mensagem", "Item incluido com sucesso");
		}else{
			model.addAttribute("mensagem", "não foi possivel incluir item");
		}
		
		Pedido pedidoAtualizado = pedidoService.atualizarComItem(incluido);
		
		ItemDTO outroItem = new ItemDTO();
		outroItem.setIdPedido(pedidoAtualizado.getIdPedido());
        return new ModelAndView("item/manter","item",outroItem);
    }
	
	@RequestMapping(path="/processar",method= RequestMethod.POST)
	public ModelAndView processar(Long idItem, Long idPedido){
		itemService.alterarSituacao(idItem);
		if(pedidoService.verificarSituacaoDosItens(idPedido)){
			pedidoService.atualizarSituacao(idPedido);
		}
		return new ModelAndView ("redirect:/pedido/processar/"+idPedido);
	}
	
	 @ModelAttribute("materiais")
	 public List<Material> comboMateriais() {
	     return materialService.listar();
	 }
	    
	 @ModelAttribute("servicos")
	 public List<Servico> comboServicos() {
	     return servicoService.listar();
	 }
}

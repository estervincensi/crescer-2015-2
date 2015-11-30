package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.DTO.ItemDTO;
import br.com.cwi.crescer.DTO.PedidoDTO;
import br.com.cwi.crescer.DTO.PedidoResumidoDTO;
import br.com.cwi.crescer.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.PedidoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	private PedidoService pedidoService;
	private ClienteService clienteService;
	private MaterialService materialService;
	private ServicoService servicoService;

	@Autowired
	public PedidoController(PedidoService pedidoService, ClienteService clienteService, MaterialService materialService,
			ServicoService servicoService) {
		super();
		this.pedidoService = pedidoService;
		this.clienteService = clienteService;
		this.materialService = materialService;
		this.servicoService = servicoService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidos());
	}

	@RequestMapping(path = "/lista", method = RequestMethod.GET)
	public ModelAndView buscarPedido(String cpf, String situacao) {
		if (!cpf.isEmpty()) {
			if (situacao != null) {
				return new ModelAndView("pedido/lista", "pedidos",
						pedidoService.listarPedidosPorCpfeSituacao(cpf, situacao));
			}
			return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosPorCpf(cpf));
		}
		if (situacao != null) {
			return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosPorSituacao(situacao));
		}
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidos());
	}

	@RequestMapping(path = "/processar/{id}", method = RequestMethod.GET)
	public ModelAndView processa(@PathVariable("id") Long id) {
		return new ModelAndView("pedido/processa", "pedido", pedidoService.buscarPedidoPorId(id));
	}

	@RequestMapping(path = "/processar", method = RequestMethod.POST)
	public ModelAndView processar(PedidoDTO pedidoDto) {
		PedidoResumidoDTO dto = new PedidoResumidoDTO();
		dto.setId(pedidoDto.getIdPedido());
		pedidoService.processarPedido(dto);
		return new ModelAndView("redirect:/pedido");
	}
	
	@RequestMapping(path="/retirar/{id}",method = RequestMethod.GET)
	public ModelAndView retira(@PathVariable("id")Long id){
		return new ModelAndView("pedido/retira","pedido",pedidoService.buscarPedidoPorId(id));
	}
	
	@RequestMapping(path="/retirar",method = RequestMethod.POST)
	public ModelAndView retirar(Long idPedido){
		pedidoService.retirar(idPedido);
		return new ModelAndView("redirect:/pedido");
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView exibe(@PathVariable("id") Long id) {
		return new ModelAndView("pedido/exibe", "pedido", pedidoService.buscarPedidoPorId(id));
	}

	@RequestMapping(path = "/incluir", method = RequestMethod.GET)
	public ModelAndView viewInlcuir(PedidoResumoDTO pedido) {
		return new ModelAndView("pedido/escolheCliente", "pedido", new PedidoResumoDTO());
	}

	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("pedido") PedidoResumoDTO pedidoResumo, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("pedido/incluir");
		}

		pedidoService.incluirInicial(pedidoResumo);
		Long idPedido = pedidoService.retornaUltimoID();
		redirectAttributes.addFlashAttribute("menssagemFlash", "agora você pode adicionar itens a esse pedido");
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setIdPedido(idPedido);
		return new ModelAndView("item/manter", "item", itemDTO);
	}

	@ModelAttribute("materiais")
	public List<Material> comboMateriais() {
		return materialService.listar();
	}

	@ModelAttribute("clientes")
	public List<Cliente> comboClientes() {
		return clienteService.listar();
	}

	@ModelAttribute("servicos")
	public List<Servico> comboServicos() {
		return servicoService.listar();
	}
}

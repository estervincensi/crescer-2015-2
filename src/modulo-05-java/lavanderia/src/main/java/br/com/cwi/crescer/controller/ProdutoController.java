package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.DTO.ProdutoDTO;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	private ProdutoService produtoService;
	private ServicoService servicoService;
	private MaterialService materialService;

	@Autowired
	public ProdutoController(ProdutoService produtoService, ServicoService servicoService,
			MaterialService materialService) {
		this.produtoService = produtoService;
		this.servicoService = servicoService;
		this.materialService = materialService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("produto/lista", "produtos", produtoService.listarProdutos());

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/novo", method = RequestMethod.GET)
	public ModelAndView viewNovo() {
		return new ModelAndView("produto/novo", "produto", new ProdutoDTO());
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/novo", method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("produto") ProdutoDTO dto, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("produto/novo");
		}
		if (produtoService.incluir(dto)) {
			redirectAttributes.addFlashAttribute("mensagem", "Operacao realizada com sucesso!");
			return new ModelAndView("redirect:/produto");
		} else {
			redirectAttributes.addFlashAttribute("mensagemProduto", "Impossivel incluir produto duplicado!");
			return new ModelAndView("redirect:/produto/novo");
		}
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView edita(@PathVariable("id") Long id) {
		return new ModelAndView("produto/edita", "produto", produtoService.buscarProdutoPorId(id));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(@Valid @ModelAttribute("produto") ProdutoDTO dto, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return new ModelAndView("produto/edita");
		}
		produtoService.atualizar(dto);
		redirectAttributes.addFlashAttribute("mensagem", "Operacao realizada com sucesso!");
		return new ModelAndView("redirect:/produto");
	}	

	@ModelAttribute("servicos")
	public List<Servico> comboServico() {
		return servicoService.listar();
	}

	@ModelAttribute("materiais")
	public List<Material> comboMaterial() {
		return materialService.listar();
	}
}

package br.com.cwi.crescer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.DTO.ClienteDTO;
import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteService clienteService;
	private CidadeService cidadeService;

	@Autowired
	public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientesAtivos());

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView exibe(@PathVariable("id") Long id) {
		return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
	}

	@RequestMapping(path = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(ClienteDTO dto) {
		clienteService.atualizar(dto);

		return new ModelAndView("redirect:/clientes");
	}

	@RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView edita(@PathVariable("id") Long id) {
		return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
	}
	
	@RequestMapping(path = "/novo", method = RequestMethod.GET)
	public ModelAndView viewNovo() {
		return new ModelAndView("cliente/novo", "cliente", new ClienteDTO());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView incluir(ClienteDTO dto) {
		clienteService.incluir(dto);
		return new ModelAndView("redirect:/clientes");
	}
	
	@RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
	public ModelAndView viewRemove(@PathVariable("id") Long id) {
		return new ModelAndView("cliente/remove", "cliente", clienteService.buscarClientePorId(id));
	}
	
    @RequestMapping(path = "/remover", method = RequestMethod.POST)
    public ModelAndView remove(ClienteDTO dto) {
        clienteService.remover(dto);
        return new ModelAndView("redirect:/clientes");
    }

	@ModelAttribute("cidades")
	public List<Cidade> comboCidade() {
		return cidadeService.listar();
	}
}
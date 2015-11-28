package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
private PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService){
		super();
		this.pedidoService = pedidoService;
	}
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidos());
	}
	
	@RequestMapping(path="/lista", method = RequestMethod.GET)
	public ModelAndView buscarPedido(String cpf, String situacao) {
		if(!cpf.isEmpty()){
			if(situacao!=null){
				return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosPorCpfeSituacao(cpf,situacao));
			}
			return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosPorCpf(cpf));
		}
		if(situacao!=null){
			return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosPorSituacao(situacao));
		}
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidos());
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView exibe(@PathVariable("id") Long id) {
		return new ModelAndView("pedido/exibe", "pedido", pedidoService.buscarPedidoPorId(id));
	}
}

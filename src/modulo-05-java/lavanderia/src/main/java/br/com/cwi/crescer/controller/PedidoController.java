package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.service.PedidoService;

@Controller
public class PedidoController {
private PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService){
		super();
		this.pedidoService = pedidoService;
	}
	
	@RequestMapping("/pedido")
	public String exercicios(Model model){
		SituacaoPedido nome = pedidoService.buscarSituacao(1L);
		model.addAttribute("tipo", "Pedido - Situação");
		model.addAttribute("mensagem", nome);
		return "index2";
	}
}

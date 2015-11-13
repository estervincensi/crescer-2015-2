﻿using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Serviços;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class LocacaoController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();
        private IClienteRepositorio repositorioCliente = new Repositorio.EF.ClienteRepositorio();
        private ServicoLocacao servicoLocacao = CriarModulos.CriarServicoLocacao();

        public ActionResult LocarJogo(int id)
        {

            LocarJogoModel model;
            var jogo = repositorio.BuscarPorId(id);
            model = new LocarJogoModel()
            {
                IdJogo = jogo.Id,
                Nome = jogo.Nome,
                Descricao = jogo.Descricao,
                Selo = jogo.Selo,
                DataDevolucao = servicoLocacao.VerificaDataPrevistaDeEntrega(jogo.Id),
                Imagem = jogo.Imagem,
                Valor = servicoLocacao.VerificaValorDoJogo(jogo.Id)
            };
            return View(model);
        }

        public ActionResult Salvar(JogoLocadoModel model)
        {
            if (servicoLocacao.PodeLocar(model.Cliente))
            {
                var jogo = repositorio.BuscarPorId(model.IdJogo);
                var cliente = repositorioCliente.BuscaUmClientePorNome(model.Cliente);
                jogo.LocarPara(cliente);
                jogo.DataLocacao = DateTime.Now;
                repositorio.Atualizar(jogo);
                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                return View("NaoPermitidoLocar");
            }

        }

        public ActionResult DevolverJogo()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Preenche(string jogo)
        {
            LocarJogoModel model;
            Jogo jogo1 = repositorio.BuscarPorNome(jogo).First();
            model = new LocarJogoModel() { IdJogo = jogo1.Id, DataDevolucao = jogo1.DataLocacao, Nome = jogo1.Nome };
            model.Valor = servicoLocacao.verificaValorFinal(jogo1.Id);

            return View("DevolverJogo", model);
        }
        public ActionResult FinalizaDevolucao(int IdJogo)
        {

            Jogo jogo = repositorio.BuscarPorId(IdJogo);
            jogo.DataLocacao = null;
            jogo.IdCliente = null;
            jogo.Cliente = null;
            repositorio.Atualizar(jogo);
            TempData["msg"] = "Jogo Devolvido com sucesso";
            return RedirectToAction("DevolverJogo");

        }

    }
}
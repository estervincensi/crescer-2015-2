using Locadora.Dominio.Repositorio;
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
                DataDevolucao = jogo.DataDevolucao,
                Imagem = jogo.Imagem
            };
            return View(model);
        }
    }
}
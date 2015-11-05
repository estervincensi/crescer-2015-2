using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class DetalhesController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
        public ActionResult DetalhesJogos(int id)
        {
            JogoModel jogoModel;
            var jogo = repositorio.BuscarPorId(id);
            jogoModel = new JogoModel()
            {
                IdJogo = jogo.Id,
                Nome = jogo.Nome,
                Preco = jogo.Preco,
                Descricao = jogo.Descricao,
                Categoria = jogo.Categoria.ToString(),
                Imagem = jogo.Imagem,
                Selo = jogo.Selo.ToString(),
                Video = jogo.Video
            };
            return View(jogoModel);
        }
    }
}
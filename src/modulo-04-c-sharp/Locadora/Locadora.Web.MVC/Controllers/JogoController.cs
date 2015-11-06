using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
        public ActionResult Manter(int? id)
        {
            
            if (id.HasValue)
            {
                int idComValor = (int)id;
                var jogo = repositorio.BuscarPorId(idComValor);
                var model = new JogoDetalheModel()
                {
                    IdJogo = jogo.Id,
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Selo = jogo.Selo.ToString(),
                    Categoria = jogo.Categoria.ToString(),
                    Imagem = jogo.Imagem,
                    Video = jogo.Video
                };
                return View(model);
            }
            else
            {
                return View();
            }
            
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(JogoDetalheModel model)
        {
            if (ModelState.IsValid)
            {
                //salvar no banco
                return RedirectToAction("JogosDisponiveis","Relatorio");
            }
            return RedirectToAction("JogosDisponiveis", "Relatorio");
        }
    }
}
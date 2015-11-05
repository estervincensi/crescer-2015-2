using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
        public ActionResult JogosDisponiveis(string nome)
        {

            var model = new RelatorioModel();
            foreach (var jogo in repositorio.BuscarTodos())
            {
                var jogoModel = new JogoModel() { IdJogo = jogo.Id, Nome = jogo.Nome, Preco = jogo.Preco, Categoria = jogo.Categoria.ToString() };
                model.Jogos.Add(jogoModel);
            }
            var lista = repositorio.BuscarTodos();
            model.JogoMaisCaro = lista.First(j => j.Preco == lista.Max(x => x.Preco)).Nome;
            model.JogoMaisBarato = lista.First(j => j.Preco == lista.Min(x => x.Preco)).Nome;
            model.ValorMedio = repositorio.BuscarTodos().Average(x => x.Preco);
            model.QuantidadeTotalDeJogos = repositorio.BuscarTodos().Count;
            return View(model);
        }

    }
}
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
        public ActionResult JogosDisponiveis()
        {

            var model = new RelatorioModel();
            foreach(var jogo in repositorio.BuscarTodos())
            {
                var jogoModel = new JogoModel() { Nome = jogo.Nome, Preco = jogo.Preco, Categoria = jogo.Categoria.ToString()};
                model.Jogos.Add(jogoModel);
            }
            var lista = repositorio.BuscarTodos();
            model.JogoMaisCaro = lista.First(j => j.Preco == lista.Max(j => j.Preco)).Nome;
            model.JogoMaisBarato = lista.First(j => j.Preco == lista.Min(j => j.Preco)).Nome;
            model.ValorMedio = repositorio.BuscarTodos().Average(x => x.Preco);
            model.QuantidadeTotalDeJogos = repositorio.BuscarTodos().Count;
            return View(model);
        }
    }
}
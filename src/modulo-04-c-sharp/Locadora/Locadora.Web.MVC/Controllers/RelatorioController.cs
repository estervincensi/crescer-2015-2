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
            decimal valorJogoMaisCaro = 0;
            decimal valorJogoMaisBarato = 10000000000;
            decimal valorTotal = 0;
            foreach(var jogo in repositorio.BuscarTodos())
            {
                var jogoModel = new JogoModel() { Nome = jogo.Nome, Preco = jogo.Preco, Categoria = jogo.Categoria.ToString()};
                model.Jogos.Add(jogoModel);
                if (jogo.Preco > valorJogoMaisCaro)
                {
                    valorJogoMaisCaro = jogo.Preco;
                    model.JogoMaisCaro = jogo.Nome;
                }
                if(jogo.Preco < valorJogoMaisBarato)
                {
                    valorJogoMaisBarato = jogo.Preco;
                    model.JogoMaisBarato = jogo.Nome;
                }
                valorTotal += jogo.Preco;
                model.QuantidadeTotalDeJogos++;
            }
            model.ValorMedio = valorTotal/ model.QuantidadeTotalDeJogos;
            return View(model);
        }
    }
}
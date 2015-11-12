using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Segurança;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();
        public ActionResult JogosDisponiveis(string nome)
        {

            var model = new RelatorioModel();
            IList<Jogo> lista;
            if (!string.IsNullOrWhiteSpace(nome))
            {
                lista = repositorio.BuscarPorNome(nome);
            }
            else
            {
                lista = repositorio.BuscarTodos();
            }
            if(lista.Count>0)
            {
                foreach (var jogo in lista)
                {
                    var jogoModel = new JogoModel() { IdJogo = jogo.Id, Nome = jogo.Nome, Categoria = jogo.Categoria.ToString(),Selo=jogo.Selo };
                    model.Jogos.Add(jogoModel);
                }
                model.QuantidadeTotalDeJogos = model.Jogos.Count;
                return View(model);
            }
            else
            {
                return View("JogoNaoEncontrado");
            }
        }

        public ActionResult DetalhesJogos(int id)
        {
            JogoDetalheModel jogoModel;
            var jogo = repositorio.BuscarPorId(id);
            jogoModel = new JogoDetalheModel()
            {
                IdJogo = jogo.Id,
                Nome = jogo.Nome,
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
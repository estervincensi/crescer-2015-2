using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
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
            if (lista.Count > 0)
            {
                foreach (var jogo in lista)
                {
                    if (jogo.DataDevolucao == null)
                    {
                        var jogoModel = new JogoModel() { IdJogo = jogo.Id, Nome = jogo.Nome, Categoria = jogo.Categoria.ToString(), Selo = jogo.Selo, DataDevolucao = jogo.DataDevolucao };
                        model.Jogos.Add(jogoModel);
                    }
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
        public JsonResult ClienteAutocomplete(string term)
        {
            IList<Cliente> ClientesEncontrados = ObterClientesPorFiltro(term);

            var json = ClientesEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }

        private IList<Cliente> ObterClientesPorFiltro(string nome)
        {
            IClienteRepositorio clienteRepositorio = new Repositorio.EF.ClienteRepositorio();

            if (string.IsNullOrEmpty(nome))
                return clienteRepositorio.BuscarTodos();
            else
                return clienteRepositorio.BuscarPorNome(nome);
        }
    }
}
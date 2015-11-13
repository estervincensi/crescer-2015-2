using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class AutoCompleteController : Controller
    {
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

        public JsonResult JogoAutocomplete(string term)
        {
            IList<Jogo> JogosEncontrados = ObterJogosPorFiltro(term);

            var json = JogosEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }

        private IList<Jogo> ObterJogosPorFiltro(string nome)
        {
            IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();
            if (string.IsNullOrEmpty(nome))
                return repositorio.BuscarTodos();
            else
                return repositorio.BuscarPorNome(nome);
        }
    }
}
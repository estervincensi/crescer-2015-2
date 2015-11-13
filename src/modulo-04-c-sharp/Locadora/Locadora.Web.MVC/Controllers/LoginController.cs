using Locadora.Web.MVC.Models;
using Locadora.Dominio.Serviços;
using Locadora.Web.MVC.Segurança;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Helpers;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View("Index","_LayoutSemLogin");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(LoginModel login)
        {
            if (ModelState.IsValid)
            {
                ServicoAutenticacao servico = CriarModulos.CriarServicoAutenticacao();
                Usuario usuario = servico.verificaEmailESenha(login.Email, login.Senha);

                if (usuario != null)
                {
                    ControleDeSessao.CriarSessao(usuario);
                    return RedirectToAction("Index", "Home");
                }
            }
            ModelState.AddModelError("INVALID LOGIN", "Login ou Senha Inválidos!");
            return View("Index", login);
        }
        public ActionResult Sair()
        {
            ControleDeSessao.Encerrar();
            return RedirectToAction("Index", "Login");
        }
    }
}
using Locadora.Web.MVC.Segurança;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Login(string email, string senha)
        {
            
            if (email == "teste@teste.com" && senha=="12345")
            {
                var usuarioLogado = new UsuarioLogado("teste@teste.com",new string[] { "NaoPodeEditar" });

                FormsAuthentication.SetAuthCookie(email,true);
                Session["USUARIO_LOGADO"] = usuarioLogado;
            }
            return RedirectToAction("Index", "Home");
        }
    }
}
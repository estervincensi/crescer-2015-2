using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace Locadora.Web.MVC.Segurança
{
    public class Autorizador: AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            UsuarioLogado usuarioLogado = ControleDeSessao.UsuarioLogado;

            if (usuarioLogado != null && AuthorizeCore(filterContext.HttpContext))
            {
                var identidade = new GenericIdentity(usuarioLogado.Email);
                string[] roles = usuarioLogado.Permissoes;

                var principal = new GenericPrincipal(identidade, roles);

                Thread.CurrentPrincipal = principal;
                HttpContext.Current.User = principal;

                base.OnAuthorization(filterContext);
            }
            else
            {
                RedirecionaParaTelaLogin(filterContext);
            }
            
        }
        private void RedirecionaParaTelaLogin(AuthorizationContext filterContext)
        {
            filterContext.Result = new RedirectToRouteResult(new RouteValueDictionary { { "action", "Index" }, { "controller", "Login" } });
        }
    }
}
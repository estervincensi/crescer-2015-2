using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;

namespace Locadora.Web.MVC.Segurança
{
    public class ControleDeSessao
    {
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";

        public static UsuarioLogado UsuarioLogado
        {
            get
            {
                return HttpContext.Current.Session[USUARIO_LOGADO] as UsuarioLogado;
            }
        }

        public static void CriarSessao(Usuario usuario){
            var usuarioLogado = new UsuarioLogado(usuario);
            FormsAuthentication.SetAuthCookie(usuarioLogado.Email,true);
            HttpContext.Current.Session[USUARIO_LOGADO] = usuarioLogado;

        }

    }
}
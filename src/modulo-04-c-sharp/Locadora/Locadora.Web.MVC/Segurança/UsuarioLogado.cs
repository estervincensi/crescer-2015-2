using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Segurança
{
    public class UsuarioLogado
    {
        public string Email { get; set; }
        public string[] Permissoes { get; set; }

        public UsuarioLogado(string email, string[] permissoes)
        {
            this.Email = email;
            this.Permissoes = permissoes;
        }
    }
}
using Locadora.Dominio;
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

        public UsuarioLogado(Usuario usuario)
        {
            this.Email = usuario.Email;
            this.Permissoes = usuario.Permissoes.Select(p=>p.Nome).ToArray();
        }
    }
}
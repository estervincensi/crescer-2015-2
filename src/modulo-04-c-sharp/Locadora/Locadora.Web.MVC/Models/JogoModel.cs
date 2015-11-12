using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoModel
    {
        public int IdJogo { get; set; }
        public string Nome { get; set; }
        public string Categoria { get; set; }
        public Selo Selo { get; set; }
    }
}
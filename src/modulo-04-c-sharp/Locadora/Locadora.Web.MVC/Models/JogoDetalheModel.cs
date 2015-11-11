using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace Locadora.Web.MVC.Models
{
    public class JogoDetalheModel
    {
        public int IdJogo { get; set; }
        public string Nome { get; set; }
        public string Categoria { get; set; }
        public string Selo { get; set; }
        public string Imagem { get; set; }
        public string Descricao { get; set; }
        public string Video { get; set; }
    }
}
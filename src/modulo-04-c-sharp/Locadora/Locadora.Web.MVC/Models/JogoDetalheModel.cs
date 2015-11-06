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
        [Required]
        public string Nome { get; set; }
        [Required]
        public decimal Preco { get; set; }
        [Required]
        public string Categoria { get; set; }
        [Required]
        public string Selo { get; set; }
        public string Imagem { get; set; }
        [Required]
        public string Descricao { get; set; }
        public string Video { get; set; }
    }
}
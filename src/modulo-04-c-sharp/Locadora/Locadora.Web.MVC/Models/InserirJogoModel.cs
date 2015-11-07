using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Models
{
    public class InserirJogoModel
    {
        public int? IdJogo { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public string Descricao { get; set; }

        [Required]
        public decimal Preco { get; set; }

        [Required]
        public Categoria Categoria { get; set; }

        [Required]
        public Selo Selo { get; set; }

        public string Imagem { get; set; }        

        public string Video { get; set; }

        
    }
}
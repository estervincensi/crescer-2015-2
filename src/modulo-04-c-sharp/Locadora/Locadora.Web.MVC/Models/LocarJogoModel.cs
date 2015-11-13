using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LocarJogoModel
    {
        public int IdJogo { get; set; }
        public string Nome { get; set; }
        public string Imagem { get; set; }
        public string Descricao { get; set; }
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}",ApplyFormatInEditMode = true)]
        [Display(Name="Data de Locacao:")]
        public DateTime? DataDevolucao { get; set; }
        public Selo Selo { get; set; }
        [Display(Name = "Valor Final:")]
        public decimal Valor { get; set; }
    }
}
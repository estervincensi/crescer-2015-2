using Locadora.Dominio;
using System;
using System.Collections.Generic;
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
        public DateTime? DataDevolucao { get; set; }
        public Selo Selo { get; set; }
        public decimal Valor { get; set; }
    }
}
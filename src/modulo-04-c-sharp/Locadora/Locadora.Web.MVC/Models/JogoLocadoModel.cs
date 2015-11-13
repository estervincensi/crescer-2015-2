using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoLocadoModel
    {
        public int IdJogo { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public string Cliente { get; set; }
        public decimal valorFinal { get; set; }
    }
}
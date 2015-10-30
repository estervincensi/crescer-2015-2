using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aula4Ado
{
    class Cargo
    {
        public int IDCargo { get; set; }
        public string Nome { get; set; }
        public string Situacao { get; set; }

        public Cargo(int idCargo, string nome)
        {
            this.IDCargo = idCargo;
            this.Nome = nome;
        }

    }
}

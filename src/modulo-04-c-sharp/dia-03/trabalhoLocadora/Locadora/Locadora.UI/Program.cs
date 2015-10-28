using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Program
    {
        static void Main(string[] args)
        {
            Jogo j = new Jogo("Mario",25.00,Categoria.AVENTURA);
            j.Id = 21;
            Banco b = new Banco();
            b.CadastrarNovoJogo(j);

            Console.ReadLine();
        }
    }
}

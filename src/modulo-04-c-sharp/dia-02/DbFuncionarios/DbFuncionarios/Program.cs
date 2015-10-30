
using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;

namespace DbFuncionarios
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Ordenados por cargo");
            IList<Funcionario> lista = new BaseDeDados().FiltrarPorIdadeAproximada(20);
            foreach (var item in lista)
            {
                Console.WriteLine(item.Nome);
            }

            Console.WriteLine("funcionarios por turno:");
            IList<dynamic> lista1 = new BaseDeDados().QtdFuncionariosPorTurno();
            foreach (var item in lista1)
            {
                Console.WriteLine(item.turno + " - " + item.count);
            }
            Console.Read();
        }

        
    }
}

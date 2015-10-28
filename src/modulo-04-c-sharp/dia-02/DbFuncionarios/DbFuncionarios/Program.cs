
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
            IList<Funcionario> lista = OrdenadosPorCargo();
            foreach (var item in lista)
            {
                Console.WriteLine(item.Nome + " - " + item.Cargo.Titulo + "\n");
            }

            Console.WriteLine("funcionarios por turno:");
            IList<dynamic> lista1 = QtdFuncionariosPorTurno();
            foreach (var item in lista1)
            {
                Console.WriteLine(item.turno + " - " + item.count);
            }
            Console.Read();
        }

        static IList<Funcionario> OrdenadosPorCargo()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            return funcionarios.OrderBy(f => f.Cargo.Titulo).ToList();

        }

        static IList<Funcionario> BuscarPorNome(string nome)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var query = from f in funcionarios
                        where f.Nome.Contains(nome)
                        select f;
            return query.OrderBy(f => f.Nome).ToList();
            //return funcionarios.Where(f => f.Nome.Contains(nome)).OrderBy(f=>f.Nome).ToList(); 

        }

        static IList<dynamic> BuscaRapida(string nome)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var query = from f in funcionarios
                        where f.Nome.Contains(nome)
                        select new
                        {
                            Nome = f.Nome,
                            TituloCargo = f.Cargo.Titulo
                        };

            return query.ToList<dynamic>();
        }

        //static IList<dynamic> BuscaRapida(string nome)
        //{
        //    var baseDeDados = new BaseDeDados();
        //    return baseDeDados.Funcionarios
        //      .Where(x => x.Nome.Contains(nome))
        //     .Select(x => new { Nome = x.Nome, TituloCargo = x.Cargo.Titulo })
        //     .ToList<dynamic>();
        //}

        static IList<Funcionario> BuscaPorTurno(params TurnoTrabalho[] turno)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            return funcionarios.Where(f => turno.Contains(f.TurnoTrabalho)).ToList();
        }


        static IList<dynamic> QtdFuncionariosPorTurno()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            return funcionarios.GroupBy(f => f.TurnoTrabalho).Select(f => new
            {
                turno = f.Key,
                count = f.Count()
            }).ToList<dynamic>();

        }

        static IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            return funcionarios.Where(f => f.Cargo.Titulo == cargo.Titulo).ToList();
        }

        static IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            //alterar, so esta pegando os que tem 5 anos antes, 5 depois e a data atual
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            DateTime data = DateTime.Now;
            return funcionarios.Where(f => (data.Year - f.DataNascimento.Year) > idade - 5 && (data.Year - f.DataNascimento.Year) < idade + 5).ToList();

        }

        //static double SalarioMedio(params TurnoTrabalho[] turno)
        //{
            
        //}

        static IList<Funcionario> AniversariantesDoMes()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            return funcionarios.Where(f => f.DataNascimento.Month == DateTime.Now.Month).ToList();
        }
    }
}

﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios
        {
            get; private set;
        }

        public BaseDeDados()
        {
            CriarBase();
        }



        public IList<Funcionario> OrdenadosPorCargo()
        {
            return this.Funcionarios.OrderBy(f => f.Cargo.Titulo).ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return this.Funcionarios.Where(f => f.Nome.IndexOf(nome, StringComparison.InvariantCultureIgnoreCase) >= 0).ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
            return this.Funcionarios.Select(f =>
            {
                dynamic r = new ExpandoObject();
                r.NomeFuncionario = f.Nome;
                r.TituloCargo = f.Cargo.Titulo;
                return r;
            }).ToList();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            return this.Funcionarios.Where(f => turnos.Length == 0 || turnos.Contains(f.TurnoTrabalho)).ToList();
        }

        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            return this.Funcionarios.GroupBy(funcionario => funcionario.TurnoTrabalho)
                                    .OrderBy(turno => turno.Key)
                                    .Select(grupo =>
            {
                dynamic resultado = new ExpandoObject();
                resultado.Turno = grupo.Key;
                resultado.Qtd = grupo.Count();
                return resultado;
            }).ToList();
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return this.Funcionarios.Where(f => f.Cargo.Equals(cargo)).ToList();
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            return this.Funcionarios.Where(f =>
            {
                int idadeFunc = CalcularIdade(f.DataNascimento);
                return idadeFunc >= idade - 5 && idadeFunc <= idade + 5;
            }).ToList();
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            return this.Funcionarios.Where(f => !turno.HasValue || f.TurnoTrabalho == turno.Value)
                                    .Average(f => f.Cargo.Salario);
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            int mesAtual = DateTime.Now.Month;
            return this.Funcionarios.Where(f => f.DataNascimento.Month == mesAtual).ToList();
        }

        public dynamic FuncionarioMaisComplexo()
        {
            int tamanhoMaiorNomeComConsoantes = this.Funcionarios.Max(f => Regex.Replace(f.Nome, "aouieyAOUIEY", "").Length);
            CultureInfo ptCulture = new CultureInfo("pt-BR");
            CultureInfo entCulture = new CultureInfo("en-US");

            return this.Funcionarios.Where(f => f.Nome.Length == tamanhoMaiorNomeComConsoantes)
                                    .Select(f => 
                                    {
                                        dynamic funcionario = new ExpandoObject();
                                        funcionario.Nome = f.Nome;
                                        funcionario.SalarioRS = f.Cargo.Salario.ToString("C", ptCulture);
                                        funcionario.SalarioUS = f.Cargo.Salario.ToString("C", entCulture);
                                        return funcionario;
                                    }).First();
        }

        private int CalcularIdade(DateTime dataNascimento)
        {
            int anos = DateTime.Now.Year - dataNascimento.Year;
            bool mesMenor = DateTime.Now.Month < dataNascimento.Month;
            bool mesIgualEDiaMenor = DateTime.Now.Month == dataNascimento.Month && DateTime.Now.Day < dataNascimento.Day;

            if (mesMenor || mesIgualEDiaMenor)
            {
                anos--;
            }
               
            return anos;
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);
            
            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);
            
            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);
            
            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);
            
            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);
            
            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);
            
            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);
            
            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);
            
            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);
            
            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);
            
            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }
        
        //Exercicio A
        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(f => f.Cargo.Titulo).ToList();
        }

        //Exercicio B
        public IList<Funcionario> BuscarPorNome(string nome)
        {

            var query = from f in Funcionarios
                        where f.Nome.Contains(nome)
                        select f;
            return query.OrderBy(f => f.Nome).ToList();
            //return Funcionarios.Where(f => f.Nome.Contains(nome)).OrderBy(f=>f.Nome).ToList(); 

        }

        //Exercicio C
        public IList<dynamic> BuscaRapida()
        {
            var query = from f in Funcionarios
                        select new
                        {
                            Nome = f.Nome,
                            TituloCargo = f.Cargo.Titulo
                        };

            return query.ToList<dynamic>();
        }

        //public IList<dynamic> BuscaRapida()
        //{
        //    var baseDeDados = new BaseDeDados();
        //    return baseDeDados.Funcionarios
        //     .Select(x => new { Nome = x.Nome, TituloCargo = x.Cargo.Titulo })
        //     .ToList<dynamic>();
        //}

        // Exercicio D
        public IList<Funcionario> BuscaPorTurno(params TurnoTrabalho[] turno)
        {
            return Funcionarios.Where(f => turno.Contains(f.TurnoTrabalho)).ToList();
        }

        //Exercicio E
        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            return Funcionarios.GroupBy(f => f.TurnoTrabalho).Select(f => new
            {
                turno = f.Key,
                count = f.Count()
            }).ToList<dynamic>();

        }

        //Exercicio F
        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(f => f.Cargo.Titulo == cargo.Titulo).ToList();
        }

        //Exercicio G
        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            DateTime data = DateTime.Now;
            return Funcionarios.Where(f => (data.Year - f.DataNascimento.Year) > idade - 5 && (data.Year - f.DataNascimento.Year) < idade + 5).ToList();
        }

        // Exercicio H
        public double salariomedio(TurnoTrabalho? turno)
        {
            TurnoTrabalho[] turnosDeTrabalho = { TurnoTrabalho.Manha, TurnoTrabalho.Tarde, TurnoTrabalho.Noite };
            IList<Funcionario> funcio;
            if (turno.HasValue)
            {
                funcio = BuscaPorTurno(turno.Value);
            }
            else
            {
                funcio = BuscaPorTurno(turnosDeTrabalho);
            }
            return funcio.Average(f => f.Cargo.Salario);
        }

        // Exercicio I
        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.Where(f => f.DataNascimento.Month == DateTime.Now.Month).ToList();
        }

        //Exercicio J
        public dynamic FuncionarioMaisComplexo()
        {
            string padrao = "[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z]";
            int maiorIncidenciaDeConasoantes = Funcionarios.Max(funcionario => Regex.Matches(funcionario.Nome, padrao).Count);

            Funcionario funcionarioComplexo = Funcionarios.First(funcionario => Regex
            .Matches(funcionario.Nome, padrao)
            .Count == maiorIncidenciaDeConasoantes);

            double salario = funcionarioComplexo.Cargo.Salario;
            return new
            {
                Nome = funcionarioComplexo.Nome,
                SalarioRS = "R$" + String.Format("{0:0.00}", salario),
                SalarioUS = "U$" + String.Format("{0:0.00}", salario)
            };
        }
    }
}

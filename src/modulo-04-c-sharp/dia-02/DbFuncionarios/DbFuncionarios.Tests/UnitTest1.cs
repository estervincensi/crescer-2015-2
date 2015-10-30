using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace DbFuncionarios.Tests
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void FuncionariosSaoOrdenadosPorCargoEmOrdemAlfabetica()
        {
            IList<Funcionario> lista = new BaseDeDados().OrdenadosPorCargo();
            Assert.AreEqual("Analista",lista[0].Cargo.Titulo);
            Assert.AreEqual("Desenvolvedor", lista[2].Cargo.Titulo);
        }

        [TestMethod]
        public void BuscarPorNomeRetornaOsDadosDoFuncionarioQueFoiPassadoONome()
        {
            IList<Funcionario> lista = new BaseDeDados().BuscarPorNome("Gabriel Alboy");
            Assert.AreEqual("Gabriel Alboy", lista[0].Nome);
            Assert.AreEqual("Analista",lista[0].Cargo.Titulo);
        }
        
        [TestMethod]
        public void BuscaRapidaTeste()
        {
            IList<dynamic> lista = new BaseDeDados().BuscaRapida();
            Assert.AreEqual(11, lista.Count);
        }
        [TestMethod]
        public void BuscaPorTurnoRetornaTodosOsFuncionariosDoTurnoDigitado()
        {
            IList<Funcionario> lista = new BaseDeDados().BuscaPorTurno(TurnoTrabalho.Manha);
            Assert.AreEqual(5,lista.Count);
        }
        [TestMethod]
        public void BuscaPorTurnoPodeReceberMaisDeUmParametro()
        {
            IList<Funcionario> lista = new BaseDeDados().BuscaPorTurno(TurnoTrabalho.Manha, TurnoTrabalho.Tarde);
            Assert.AreEqual(9, lista.Count);
        }
        [TestMethod]
        public void BuscaPorCargoRetornaTodosOsFuncionariosDoCargoDigitado()
        {
            Cargo analista = new Cargo("Analista", 250);
            IList<Funcionario> lista = new BaseDeDados().BuscarPorCargo(analista);
            Assert.AreEqual(2,lista.Count);
        }
        [TestMethod]
        public void FiltrarPorIdadeAproximadaRetornaTodosComIdadeNoIntervaloDe5AnosAMaisOuAMenosQueADigitada()
        {
            IList<Funcionario> lista = new BaseDeDados().FiltrarPorIdadeAproximada(20);
            Assert.AreEqual(6,lista.Count);
        }
        [TestMethod]
        public void SalarioMedioRetornaAMediaDeSalariosDeUmTurno()
        {
            double media = new BaseDeDados().salariomedio(TurnoTrabalho.Noite);
            Assert.AreEqual(190,media);
        }
        [TestMethod]
        public void SalariMedioPodeReceberNullComoParametroERetornaAMediaDeTodosOsSalarios()
        {
            double media = new BaseDeDados().salariomedio(null);
            Assert.AreEqual(233.68, media,0.2);
        }

        [TestMethod]
        public void QtdFuncionariosPorTurnoRetornaOsTurnosEQuantidades()
        {
            string esperadoManha = "{ turno = Manha, count = 5 }";
            string esperadoTarde = "{ turno = Tarde, count = 4 }";
            string esperadoNoite = "{ turno = Noite, count = 2 }";
            IList<dynamic> lista = new BaseDeDados().QtdFuncionariosPorTurno();
            Assert.AreEqual(esperadoManha, lista[0].ToString());
            Assert.AreEqual(esperadoTarde, lista[1].ToString());
            Assert.AreEqual(esperadoNoite, lista[2].ToString());
        }

        [TestMethod]
        public void FuncionarioMaisComplexoTest()
        {
            string esperado = new
            {
                Nome = "Leandro Andreolli",
                SalarioRS = "R$190,00",
                SalarioUS = "U$190,00"
            }.ToString();

            string atual = new BaseDeDados().FuncionarioMaisComplexo().ToString();
            Assert.AreEqual(esperado, atual);
        }

    }
}

using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;
using System.Collections.Generic;

namespace Locadora.Testes
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void RealizarPesquisaPorNome()
        {
            Banco banco = new Banco();
            IList<Jogo> jogos = banco.RealizarPesquisaPorNome("Super Mario Kart");
            Jogo jogo = new Jogo("Super Mario Kart",40.00,Categoria.CORRIDA);
            jogo.Id = 6;
            Assert.AreEqual(jogo.Id, jogos[0].Id);
            Assert.AreEqual(jogo.Nome, jogos[0].Nome);
            Assert.AreEqual(jogo.Preco, jogos[0].Preco);
            Assert.AreEqual(jogo.Categoria, jogos[0].Categoria);
        }
        [TestMethod]
        public void CadastrarNovoUsuario()
        {
            Banco banco = new Banco();
            Jogo jogo = new Jogo("Jogo Teste", 20.00, Categoria.AVENTURA);
            int ultimoValor = banco.PegarUltimoId();
            banco.CadastrarNovoJogo(jogo);
            Assert.AreEqual(jogo.Nome, banco.RealizarPesquisaPorNome("Jogo Teste")[0].Nome);
            Assert.AreEqual(jogo.Preco, banco.RealizarPesquisaPorNome("Jogo Teste")[0].Preco);
            Assert.AreEqual(jogo.Categoria, banco.RealizarPesquisaPorNome("Jogo Teste")[0].Categoria);
        }
        [TestMethod]
        public void EditarNomeDoJogo()
        {
            Banco banco = new Banco();
            banco.EditarNomeDoJogo("Jogo Teste", "Teste");
            Assert.AreEqual("Teste",banco.RealizarPesquisaPorNome("Teste")[0].Nome);
        }
        [TestMethod]
        public void EditarPrecoDoJogo()
        {
            Banco banco = new Banco();
            banco.EditarPrecoDoJogo("Teste", 50.00);
            Assert.AreEqual(50.00, banco.RealizarPesquisaPorNome("Teste")[0].Preco);
        }
        [TestMethod]
        public void EditarCategoriaDoJogo()
        {
            Banco banco = new Banco();
            banco.EditarCategoriaDoJogo("Teste", Categoria.LUTA);
            Assert.AreEqual(Categoria.LUTA, banco.RealizarPesquisaPorNome("Teste")[0].Categoria);
        }
    }
}

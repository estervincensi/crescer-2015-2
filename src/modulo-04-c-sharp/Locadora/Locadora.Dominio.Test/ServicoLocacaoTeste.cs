using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio.Test.Mocks;
using Locadora.Dominio.Serviços;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class ServicoLocacaoTeste
    {
        private ServicoLocacao CriarServicoLocacao()
        {
            return new ServicoLocacao(new JogoRepositorioMock(), new ClienteRepositorioMock());
        }
        [TestMethod]
        public void DataPrevistaDeEntregaEh1DiaQuandoSeloOuro()
        {
            ServicoLocacao locacao = CriarServicoLocacao();
            Jogo j = new Jogo(1, "teste", Selo.OURO, "abc");
            var data = locacao.VerificaDataPrevistaDeEntrega(j.Id);
            Assert.AreEqual(data.Date, DateTime.Now.AddDays(1).Date);
        }
        [TestMethod]
        public void DataPrevistaDeEntregaEh2DiasQuandoSeloPrata()
        {
            ServicoLocacao locacao = CriarServicoLocacao();
            Jogo j = new Jogo(2, "teste", Selo.PRATA, "abc");
            var data = locacao.VerificaDataPrevistaDeEntrega(j.Id);
            Assert.AreEqual(data.Date, DateTime.Now.AddDays(2).Date);
        }

        [TestMethod]
        public void DataPrevistaDeEntregaEh3DiasQuandoSeloBronze()
        {
            ServicoLocacao locacao = CriarServicoLocacao();
            Jogo j = new Jogo(3, "teste", Selo.BRONZE, "abc");
            var data = locacao.VerificaDataPrevistaDeEntrega(j.Id);
            Assert.AreEqual(data.Date, DateTime.Now.AddDays(3).Date);
        }

        [TestMethod]
        public void ValorDoJogoEh15QuandoSeloOuro()
        {
            ServicoLocacao locacao = CriarServicoLocacao();
            Jogo j = new Jogo(1, "teste", Selo.OURO, "abc");
            var preco = locacao.VerificaValorDoJogo(j.Id);
            Assert.AreEqual(15, preco);
        }
        [TestMethod]
        public void ValorDoJogoEh10QuandoSeloPrata()
        {
            ServicoLocacao locacao = CriarServicoLocacao();
            Jogo j = new Jogo(2, "teste", Selo.PRATA, "abc");
            var preco = locacao.VerificaValorDoJogo(j.Id);
            Assert.AreEqual(10, preco);
        }
        [TestMethod]
        public void ValorDoJogoEh5QuandoSeloBronze()
        {
            ServicoLocacao locacao = CriarServicoLocacao();
            Jogo j = new Jogo(3, "teste", Selo.BRONZE, "abc");
            var preco = locacao.VerificaValorDoJogo(j.Id);
            Assert.AreEqual(5, preco);
        }
    }
}

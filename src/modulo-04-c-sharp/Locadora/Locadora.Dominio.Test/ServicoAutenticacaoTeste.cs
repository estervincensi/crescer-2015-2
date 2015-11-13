﻿using Locadora.Dominio.Serviços;
using Locadora.Dominio.Test.Mocks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class ServicoAutenticacaoTeste
    {
        [TestMethod]
        public void UsuarioLogadoComSucesso()
        {
            ServicoAutenticacao servicoAutenticacao = CriarServicoAutenticacao();
            Usuario usuarioAutenticado = servicoAutenticacao.verificaEmailESenha("teste@teste.com", "123");

            Assert.IsNotNull(usuarioAutenticado);
        }

        [TestMethod]
        public void UsuarioNaoPodeLogar()
        {
            ServicoAutenticacao servicoAutenticacao = CriarServicoAutenticacao();
            Usuario usuarioNaoAutenticado = servicoAutenticacao.verificaEmailESenha("teste@teste.com", "1234");

            Assert.IsNull(usuarioNaoAutenticado);
        }

        private ServicoAutenticacao CriarServicoAutenticacao()
        {
            return new ServicoAutenticacao(new UsuarioRepositorioMock(), new ServicoCriptografiaMock());
        }
    }
}

using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class PermissaoTeste
    {
        [TestMethod]
        public void PermissaoAdminEhCriada()
        {
            var permissao = new Permissao(Permissao.ADMIN);
            Assert.AreEqual(Permissao.ADMIN, permissao.Nome);
            Assert.IsNull(permissao.Usuarios);
        }

        [TestMethod]
        public void PermissaoUsuarioEhCriada()
        {
            var permissao = new Permissao("usuario");
            Assert.AreEqual("usuario", permissao.Nome);
            Assert.IsNull(permissao.Usuarios);
        }
    }
}

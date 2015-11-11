using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Infraestrutura.Servicos.Test
{
    [TestClass]
    public class ServicoCriptografiaTeste
    {
        [TestMethod]
        public void SenhaCriptografada()
        {
            ServicoCriptografia servicoCriptografia = new ServicoCriptografia();
            string senhaPadrao = "teste";

            string senhaCriptografada = servicoCriptografia.CriptografarSenha(senhaPadrao);
            Assert.AreEqual("91C2AF6949B72B38875361770D93478F", senhaCriptografada);
        }
    }
}

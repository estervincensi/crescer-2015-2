using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.Testes
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();
            agenda.AdicionarContato(new Contato() {Nome = "Julio Cesar", Numero = 12345543 });
            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }
    }
}

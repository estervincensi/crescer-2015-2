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

        [TestMethod]
        public void AgendaRemoveContatoPorNome()
        {
            var agenda = new Agenda();
            agenda.AdicionarContato(new Contato() { Nome = "Ester", Numero = 12345543 });
            agenda.AdicionarContato(new Contato() { Nome = "Teste", Numero = 123456789 });

            agenda.RemoverContatoPorNome("Ester");
            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaRemoveContatoPorNumero()
        {
            var agenda = new Agenda();
            agenda.AdicionarContato(new Contato() { Nome = "Ester", Numero = 12345543 });
            agenda.AdicionarContato(new Contato() { Nome = "Teste", Numero = 123456789 });

            agenda.RemoverContatoPorNumero(12345543);
            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaRemoveMaisDeUmContatoPorNumeroSeTiverMesmoNumero()
        {
            var agenda = new Agenda();
            agenda.AdicionarContato(new Contato() { Nome = "Ester", Numero = 12345543 });
            agenda.AdicionarContato(new Contato() { Nome = "Abdefg", Numero = 12345543 });
            agenda.AdicionarContato(new Contato() { Nome = "Teste", Numero = 123456789 });

            agenda.RemoverContatoPorNumero(12345543);
            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaRemoveMaisDeUmContatoPorNomeSeTiverMesmoNome()
        {
            var agenda = new Agenda();
            agenda.AdicionarContato(new Contato() { Nome = "Ester", Numero = 12345543 });
            agenda.AdicionarContato(new Contato() { Nome = "Ester", Numero = 76543274 });
            agenda.AdicionarContato(new Contato() { Nome = "Teste", Numero = 123456789 });

            agenda.RemoverContatoPorNome("Ester");
            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }
    }
}

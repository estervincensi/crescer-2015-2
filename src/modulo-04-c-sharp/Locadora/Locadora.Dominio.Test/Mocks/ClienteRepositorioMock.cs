using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Test.Mocks
{
    class ClienteRepositorioMock : IClienteRepositorio
    {
        public IList<Cliente> BuscarPorNome(string nome)
        {
            return Db().Where(j => j.Nome == nome).ToList();
        }

        public Cliente BuscaUmClientePorNome(string nome)
        {
            return Db().FirstOrDefault(j => j.Nome == nome);
        }

        public IList<Cliente> BuscarTodos()
        {
            return Db().ToList();
        }

        private IList<Cliente> Db()
        {
            var clientes = new List<Cliente>();
            var cliente1 = new Cliente(1);
            cliente1.Nome = "Teste";
            clientes.Add(cliente1);
            return clientes;
        }
    }
}

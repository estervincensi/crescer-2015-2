using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Test.Mocks
{
    class JogoRepositorioMock : IJogoRepositorio
    {
        public IList<Jogo> BuscarPorNome(string nome)
        {
            throw new NotImplementedException();
        }

        public IList<Jogo> BuscarTodos()
        {
            throw new NotImplementedException();
        }

        public int Criar(Jogo jogo)
        {
            throw new NotImplementedException();
        }

        public int Atualizar(Jogo jogo)
        {
            throw new NotImplementedException();
        }

        public int Excluir(int id)
        {
            throw new NotImplementedException();
        }

        public Jogo BuscarPorId(int id)
        {
            return Db().First(x => x.Id == id);
        }

        private IList<Jogo> Db()
        {
            var jogos = new List<Jogo>();
            var jogo = new Jogo(1,"teste",Selo.OURO,"teste");
            return jogos;
        }
    }
}

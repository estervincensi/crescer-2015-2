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
            var jogo1 = new Jogo(1,"teste",Selo.OURO,"teste");
            var jogo2 = new Jogo(2, "teste1", Selo.PRATA, "teste1");
            var jogo3 = new Jogo(3, "teste2", Selo.BRONZE, "teste2");
            jogos.Add(jogo1);
            jogos.Add(jogo2);
            jogos.Add(jogo3);
            return jogos;
        }
    }
}

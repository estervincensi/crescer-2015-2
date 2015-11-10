using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : IJogoRepositorio
    {

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (var db = new BancoDeDados())
            {
                return db.Jogo.Include("cliente").Where(j => j.Nome == nome).ToList();
            }
            
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var db = new BancoDeDados())
            {
                return db.Jogo.Include("cliente").ToList();
            }
        }

        public int Criar(Jogo jogo)
        {
            using (var db = new BancoDeDados())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }
        }

        public int Atualizar(Jogo jogo)
        {
            using (var db = new BancoDeDados())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Modified;
                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var db = new BancoDeDados())
            {
                Jogo j = db.Jogo.Find(id);
                db.Entry(j).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (var db = new BancoDeDados())
            {
                return db.Jogo.Include("cliente").FirstOrDefault(j=>j.Id==id);
            }
        }
    }
}

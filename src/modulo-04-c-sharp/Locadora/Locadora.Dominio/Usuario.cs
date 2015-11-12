using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Usuario : EntidadeBase
    {
        public string NomeCompleto { get; private set; }
        public string Email { get; private set; }
        public string Senha { get; private set; }
        public ICollection<Permissao> Permissoes { get; private set; }

        public Usuario(string nomeCompleto, string email, string senha)
        {
            this.NomeCompleto = nomeCompleto;
            this.Senha = senha;
            this.Email = email;
            this.Permissoes = new HashSet<Permissao>();
        }

        private Usuario()
        {

        }

        public void AdicionarPermissao(Permissao permissao)
        {
            if (this.Permissoes == null)
            {
                this.Permissoes = new HashSet<Permissao>();
            }

            if (!TemPermissao(permissao.Nome))
            {
                this.Permissoes.Add(permissao);
            }
        }

        public bool TemPermissao(string nomePermissao)
        {
            return this.Permissoes != null
                   && this.Permissoes.Any(p => p.Nome.Equals(nomePermissao));
        }

    }
}

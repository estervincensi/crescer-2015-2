﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Usuario
    {
        public int Id { get; set; }
        public string NomeCompleto { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public ICollection<Permissao> Permissoes { get; set; }

        public Usuario()
        {
            this.Permissoes = new HashSet<Permissao>();
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

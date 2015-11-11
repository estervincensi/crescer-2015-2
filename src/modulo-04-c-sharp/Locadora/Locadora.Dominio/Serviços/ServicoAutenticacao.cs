using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Serviços
{
    public class ServicoAutenticacao
    {
        private IUsuarioRepositorio usuarioRepositorio;
        private IServicoCriptografia servicoCriptografia;

        public ServicoAutenticacao(IUsuarioRepositorio usuarioRepositorio, IServicoCriptografia servicoCriptografia)
        {
            this.usuarioRepositorio = usuarioRepositorio;
            this.servicoCriptografia = servicoCriptografia;
        }

        public Usuario verificaEmailESenha(string email, string senha)
        {
            Usuario usuario = usuarioRepositorio.BuscarPorEmail(email);
            if (usuario != null)
            {
                string senhaCriptografada = servicoCriptografia.CriptografarSenha(senha);

                if (senhaCriptografada != usuario.Senha)
                {
                    return null;
                }
            }
            return usuario;
        }
    }
}

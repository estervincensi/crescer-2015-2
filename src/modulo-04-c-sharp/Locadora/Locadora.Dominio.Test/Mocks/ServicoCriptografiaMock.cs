using Locadora.Dominio.Serviços;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Test.Mocks
{
    class ServicoCriptografiaMock : IServicoCriptografia
    {
        public const string SALT = "$CWI";

        public string CriptografarSenha(string senha)
        {
            return senha + SALT;
        }
    }
}
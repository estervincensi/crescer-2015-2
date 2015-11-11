using Locadora.Dominio.Serviços;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Security.Cryptography;

namespace Locadora.Infraestrutura.Servicos
{
    public class ServicoCriptografia : IServicoCriptografia
    {
        public string CriptografarSenha(string senha)
        {
            senha += "%$CRIPTOGRAFANDO_NO_CRESCER&%";
            return GerarMd5(senha);
        }
        private string GerarMd5(string senha)
        {
            MD5 md5 = MD5.Create();
            byte[] inputBytes = Encoding.ASCII.GetBytes(senha);
            byte[] hash = md5.ComputeHash(inputBytes);

            var sb = new StringBuilder();

            for (int i = 0; i < hash.Length; i++)
            {
                sb.Append(hash[i].ToString("X2"));
            }

            return sb.ToString();
        }
    }
}

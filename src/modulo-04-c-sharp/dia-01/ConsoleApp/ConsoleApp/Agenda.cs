using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();

        public int QuantidadeContatos { get { return contatos.Count; } }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        //public void RemoverContato(String nomeContato)
        //{
        //    foreach (var contato in contatos)
        //    {
        //        if(contato.Nome == nomeContato)
        //        {
        //            contatos.Remove(contato);
        //            break;
        //        }
        //    }
        //}

        public void RemoverContatoPorNome(String nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();
            for(int i=0; i<contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                {
                    contatosASeremRemovidos.Add(contatos[i]);
                }
            }
            foreach(var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void RemoverContatoPorNumero(int numeroContato)
        {
            var contatosASeremRemovidos = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numeroContato)
                {
                    contatosASeremRemovidos.Add(contatos[i]);
                }
            }
            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public List<Contato> ListarContatos()
        {
            return this.contatos;
        }

        /*public List<Contato> ListarContatosOrdenadosPorNome()
        {
           
        }*/
    }
}

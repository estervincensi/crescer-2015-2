using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public abstract class Robo
    {
        public string Nome { get; set; }

        public Robo(string nome)
        {
            this.Nome = nome;
        }

        internal void DebitarMunicao()
        {
            //somente dentro desta solução irá ver esse método
            Console.WriteLine("debitou munição");
            
        }

        public virtual void Atacar()
        {
            Console.WriteLine("Atacou");
            DebitarMunicao();
        }

        protected abstract void Defender();
    }
}

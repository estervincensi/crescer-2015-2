using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public class Mercurio : Robo,IVoar
    {
        public int Idade { get; set; }

        public Mercurio(string nome, int idade) : base (nome)
        {
            this.Idade = idade;
        }

        public override void Atacar()
        {
            base.Atacar();
            Console.WriteLine("Atacando");
        }

        protected override void Defender()
        {
            Console.WriteLine("Defendido");
        }

        public void Avoa()
        {
            Console.WriteLine("Avoa");
        }

        public void ExplodeiaTudo()
        {
            Console.WriteLine("Explodiu tudo");
        }
    }
}

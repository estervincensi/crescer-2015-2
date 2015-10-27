using ConsoleApplication1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {
            Robo r = new Mercurio("Mercurio",10);
            r.Atacar();
            Console.ReadLine();
        }
    }
}

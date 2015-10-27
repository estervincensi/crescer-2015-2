using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            String opcao;
            var agenda = new Agenda();
            do
            {
                Console.Clear();
                Console.WriteLine("1 - Inserir contato");
                Console.WriteLine("2 - Excluir contato por nome");
                Console.WriteLine("3 - Excluir contato por numero");
                Console.WriteLine("4 - Mostrar lista de contatos");
                Console.WriteLine("5 - sair");

                Console.WriteLine("Digite uma opção: ");
                opcao = Console.ReadLine();

                if (opcao == "1")
                {
                    Console.WriteLine("Digite o nome");
                    var nome = Console.ReadLine();
                    Console.WriteLine("Digite o numero");
                    var numero = Console.ReadLine();

                    var contato = new Contato();
                    contato.Nome = nome;
                    contato.Numero = Convert.ToInt32(numero);

                    agenda.AdicionarContato(contato);

                }
                else if (opcao == "2")
                {
                    Console.WriteLine("Digite o nome");
                    var nome = Console.ReadLine();

                    agenda.RemoverContatoPorNome(nome);
                }
                else if (opcao == "3")
                {
                    Console.WriteLine("Digite o numero");
                    var numero = Console.ReadLine();

                    agenda.RemoverContatoPorNumero(Convert.ToInt32(numero));
                }
                else if (opcao == "4")
                {
                    Console.WriteLine("Lista de Contatos");
                    List<Contato> lista = agenda.ListarContatos();
                    foreach (var contato in lista)
                    {
                        Console.WriteLine("Nome:"+contato.Nome+"\nNumero: "+contato.Numero);
                    }
                    Console.WriteLine("Digite uma tecla para continuar: ");
                    Console.ReadLine(); ;   
                }

            } while (opcao != "5");
        }
    }
}

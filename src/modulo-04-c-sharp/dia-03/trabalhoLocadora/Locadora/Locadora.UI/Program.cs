using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Program
    {
        static void Main(string[] args)
        {
            Banco b = new Banco();
            int opcao = 0;
            do
            {
                try
                {
                    Console.WriteLine("1 - Cadastrar novo jogo");
                    Console.WriteLine("2 - Pesquisar Jogo");
                    Console.WriteLine("3 - Editar jogo");
                    Console.WriteLine("4 - Exportar relatório");
                    Console.WriteLine("5 - Sair");
                    Console.WriteLine("Digite uma opcao:");
                    opcao = Convert.ToInt32(Console.ReadLine());
                    Console.Clear();
                    switch (opcao)
                    {
                        case 1:
                            try
                            {
                                Console.WriteLine("Digite o nome do Jogo:");
                                string nomeDoJogo = Console.ReadLine();
                                Console.WriteLine("Digite o valor do Jogo:");
                                string valor1 = Console.ReadLine();
                                string valorCorreto = valor1.Replace(".", ",");
                                double valor = Convert.ToDouble(valorCorreto);
                                Categoria categoria = EscolheCategoria();
                                Jogo jogo = new Jogo(nomeDoJogo, valor, categoria);
                                b.CadastrarNovoJogo(jogo);
                                Console.Clear();
                                Console.WriteLine("Jogo Inserido Com Sucesso!");
                            }
                            catch (Exception)
                            {
                                Console.WriteLine("Ocorreu um erro inesperado, tente novamente!");
                            }

                            break;
                        case 2:
                            Console.WriteLine("Digite o nome do jogo:");
                            string nome = Console.ReadLine();
                            Console.Clear();
                            IList<Jogo> lista = b.RealizarPesquisaPorNome(nome);
                            foreach (var item in lista)
                            {
                                Console.WriteLine("ID: " + item.Id);
                                Console.WriteLine("Nome: " + item.Nome);
                                Console.WriteLine("Preco: R$" + item.Preco);
                                Console.WriteLine("Categoria: " + item.Categoria);
                                Console.WriteLine("--------------------------------");
                            }
                            Console.WriteLine("Digite ENTER para continuar");
                            Console.ReadLine();
                            Console.Clear();
                            break;
                        case 3:
                            try
                            {
                                Console.WriteLine("1 - Editar nome do jogo");
                                Console.WriteLine("2 - Editar preço do jogo");
                                Console.WriteLine("3 - Editar categoria do jogo");
                                Console.WriteLine("4 - Editar nome e preco do jogo");
                                Console.WriteLine("5 - Editar nome e categoria do jogo");
                                Console.WriteLine("6 - Editar preço e categoria do jogo");
                                Console.WriteLine("7 - Editar todas as informações do jogo");
                                Console.WriteLine("Digite uma opção: ");
                                int opcao2 = int.Parse(Console.ReadLine());
                                Console.Clear();
                                Console.WriteLine("Digite o nome completo do jogo que você quer editar: ");
                                string nomeJogo = Console.ReadLine();
                                if (opcao2 == 1)
                                {
                                    EditarNome(nomeJogo);

                                }
                                else if (opcao2 == 2)
                                {
                                    EditarPreco(nomeJogo);

                                }
                                else if (opcao2 == 3)
                                {
                                    EditarCategoria(nomeJogo);

                                }
                                else if (opcao2 == 4)
                                {
                                    EditarNome(nomeJogo);
                                    EditarPreco(nomeJogo);
                                }
                                else if (opcao2 == 5)
                                {
                                    EditarNome(nomeJogo);
                                    EditarCategoria(nomeJogo);
                                }
                                else if (opcao2 == 6)
                                {
                                    EditarPreco(nomeJogo);
                                    EditarCategoria(nomeJogo);
                                }
                                else if (opcao2 == 7)
                                {
                                    EditarNome(nomeJogo);
                                    EditarPreco(nomeJogo);
                                    EditarCategoria(nomeJogo);
                                }
                                Console.Clear();
                                Console.WriteLine("Jogo Alterado com Sucesso!");
                                Console.WriteLine();
                            }
                            catch (InvalidOperationException)
                            {
                                Console.WriteLine("Você digitou um nome que não existia!");
                            }
                            break;

                        case 4:
                            string caminho = b.ExportarRelatorio();
                            Console.WriteLine("Relatório exportado para o caminho: " + caminho);
                            Console.WriteLine();
                            break;
                        
                        default:
                            Console.WriteLine("Opçao inválida!");
                            Console.WriteLine();
                            break;
                    }
                }
                catch(FormatException)
                {
                    Console.Clear();
                    Console.WriteLine("Digite apenas numeros!");
                    Console.WriteLine();
                }
                
            } while (opcao != 5);


        }
        static void EditarNome(string nomeJogo)
        {
            Banco b = new Banco();
            Console.WriteLine("Digite o novo nome:");
            string novoNome = Console.ReadLine();
            b.EditarNomeDoJogo(nomeJogo, novoNome);
            Console.Clear();
        }
        static void EditarPreco(string nomeJogo)
        {
            Banco b = new Banco();
            Console.WriteLine("Digite o novo preço:");
            string novoPreco1 = Console.ReadLine();
            string precoCerto = novoPreco1.Replace(".", ",");
            double novoPreco = double.Parse(precoCerto);
            b.EditarPrecoDoJogo(nomeJogo, novoPreco);
        }
        static void EditarCategoria(string nomeJogo)
        {
            Banco b = new Banco();
            Categoria novaCategoria = EscolheCategoria();
            b.EditarCategoriaDoJogo(nomeJogo, novaCategoria);

        }
        static Categoria EscolheCategoria()
        {
            Console.WriteLine("1 - Aventura");
            Console.WriteLine("2 - RPG");
            Console.WriteLine("3 - Corrida");
            Console.WriteLine("4 - Luta");
            Console.WriteLine("5 - Esporte");
            Console.WriteLine("Digite uma das categorias (numero)");
            int categoria = int.Parse(Console.ReadLine());
            Categoria novaCategoria = Categoria.AVENTURA;
            if (categoria == 1)
            {
                novaCategoria = Categoria.AVENTURA;
            }
            else if (categoria == 2)
            {
                novaCategoria = Categoria.RPG;
            }
            else if (categoria == 3)
            {
                novaCategoria = Categoria.CORRIDA;
            }
            else if (categoria == 4)
            {
                novaCategoria = Categoria.LUTA;
            }
            else if (categoria == 5)
            {
                novaCategoria = Categoria.ESPORTE;
            }
            return novaCategoria;
        }
    }
}

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace TrabalhandoComArquivos
{
    class Program
    {
        static void Main(string[] args)
        {
            string caminhoArquivoTXT = @"C:\Users\ester.oliveira\Desktop\arquivos\meu-arquivo.txt";
            //string textoDoArquivo = "didi must die";

            //File.AppendAllText(caminhoArquivo, textoDoArquivo); //sempre adiciona quando é executado
            //string[] linhas = File.ReadAllLines(caminhoArquivo); //retorna vetor com linhas do texto
            //string texto = File.ReadAllText(caminhoArquivo); //retorna string com texto inteiro

            //byte[] arquivo = File.ReadAllBytes(caminhoArquivo);

            //var writer = new StreamWriter(caminhoArquivo, false); //aqui abre o arquivo!
            //writer.WriteLine("didi must die");
            //writer.Close(); // não esquecer de fechar senão ele não salva

            //using(var reader = new StreamReader(caminhoArquivo))
            //{
            //    reader.ReadLine();
            //}

            //string caminhoArquivo = @"C:\Users\ester.oliveira\Desktop\arquivos\jogos.xml";
            //XElement xmlJogos = XElement.Load(caminhoArquivo);

            //foreach(XElement jogo in xmlJogos.Elements("Jogo"))
            //{
            //    XElement nome = jogo.Element("nome");
            //    Console.WriteLine(jogo.Attribute("id").Value);
            //    Console.WriteLine(nome.Value);
            //}

            //string format
            //double salario = 10;
            //string text = string.Format("meu salario eh {0}", salario); //dentro das chaves coloca a posição dos paramtros que sao passados depois das aspas.

            //Console.WriteLine(DateTime.Now);
            //Console.WriteLine(DateTime.Now.ToString("dd-MM-yyyy"));

            string texto = string.Format("minha data de pagamento eh {0:dd-MM-yyyy}", DateTime.Now);
            Console.WriteLine(texto);

            Console.ReadLine();
        }
    }
}

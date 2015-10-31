using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;
using System.IO;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Banco
    {
        //coloquei os dois caminhos pra funcionar na minha casa e na cwi, dai é só eu descomentar :)
        //static string caminhoArquivo = @"C:\Users\ester.oliveira\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\trabalhoLocadora\arquivos\game_store.xml";
        static string caminhoArquivo = @"C:\Users\Ester\Documents\ProjetoCrescer\crescer-2015-2\src\modulo-04-c-sharp\dia-03\trabalhoLocadora\arquivos\game_store.xml";

        public void CadastrarNovoJogo(Jogo jogo)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);

            int LastId = Convert.ToInt32(xmlJogos.Elements("jogo").Last().Attribute("id").Value);

            XElement xmlTree = new XElement("jogo",
                new XElement("nome", jogo.Nome),
                new XElement("preco", jogo.Preco.ToString("0.00", System.Globalization.CultureInfo.InvariantCulture)),
                new XElement("categoria", jogo.Categoria)
                );

            xmlTree.SetAttributeValue("id", LastId + 1);
            xmlJogos.Add(xmlTree);

            xmlJogos.Save(caminhoArquivo);

        }

        public int PegarUltimoId()
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            return Convert.ToInt32(xmlJogos.Elements("jogo").Last().Attribute("id").Value);
        }

        public IList<Jogo> RealizarPesquisaPorNome(string nome)
        {
            var nomeMaiusulo = nome.ToUpper();
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogos = xmlJogos.Elements("jogo").Where(jogo => jogo.Element("nome").Value.ToUpper().Contains(nomeMaiusulo)).ToList();

            IList<Jogo> lista = new List<Jogo>();
            foreach (var item in jogos)
            {
                lista.Add(new Jogo(item.Element("nome").Value,
                    double.Parse(item.Element("preco").Value) / 100,
                    (Categoria)Enum.Parse(typeof(Categoria), item.Element("categoria").Value)
                    ) { Id = Convert.ToInt32(item.Attribute("id").Value) });

            }
            return lista;
        }

        public void EditarNomeDoJogo(string nome, string nomeNovo)
        {
            var nomeMaiusulo = nome.ToUpper();
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogo = xmlJogos.Elements("jogo").First(j => j.Element("nome").Value.ToUpper() == nomeMaiusulo);
            jogo.Element("nome").SetValue(nomeNovo);
            xmlJogos.Save(caminhoArquivo);
        }

        public void EditarPrecoDoJogo(string nome, double precoNovo)
        {
            var nomeMaiusculo = nome.ToUpper();
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogo = xmlJogos.Elements("jogo").First(j => j.Element("nome").Value.ToUpper() == nomeMaiusculo);
            jogo.Element("preco").SetValue(precoNovo.ToString("0.00", System.Globalization.CultureInfo.InvariantCulture));
            xmlJogos.Save(caminhoArquivo);
        }

        public void EditarCategoriaDoJogo(string nome, Categoria categoriaNova)
        {
            var nomeMaiusulo = nome.ToUpper();
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogo = xmlJogos.Elements("jogo").First(j => j.Element("nome").Value.ToUpper() == nomeMaiusulo);
            jogo.Element("categoria").SetValue(categoriaNova);
            xmlJogos.Save(caminhoArquivo);
        }

        public string ExportarRelatorio()
        {
            StringBuilder sb = new StringBuilder();
            XElement xmlJogo = XElement.Load(caminhoArquivo);
            string caminhoTxt = @"C:\Users\Ester\Documents\ProjetoCrescer\crescer-2015-2\src\modulo-04-c-sharp\dia-03\trabalhoLocadora\arquivos\Relatorio.txt";
            //string caminhoTxt = @"C:\Users\ester.oliveira\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\trabalhoLocadora\arquivos\Relatorio.txt";
            string data = DateTime.Now.ToString("dd/MM/yyy");
            string hora = DateTime.Now.ToString("T");
            int totalJogos = 0;
            string jogoMaisCaro = "";
            string jogoMaisBarato = "";
            double valorMaisCaro = 0;
            double valorMaisBarato = 100000;
            double valorMedioPorJogo = 0;
            var query = from jogo in xmlJogo.Elements("jogo")
                        select new Jogo()
                        {
                            Id = int.Parse(jogo.Attribute("id").Value),
                            Nome = jogo.Element("nome").Value,
                            Categoria = (Categoria)Enum.Parse(typeof(Categoria), jogo.Element("categoria").Value),
                            Preco = double.Parse(jogo.Element("preco").Value) / 100
                        };
            sb.Append("LOCADORA NUNES GAMES".PadLeft(50));
            sb.Append(Environment.NewLine);
            sb.Append(data);
            sb.AppendFormat("{0,65}", hora);
            sb.Append(Environment.NewLine);
            sb.Append("Relatório de Jogos".PadLeft(50));
            sb.Append(Environment.NewLine);
            sb.Append(Environment.NewLine);
            sb.Append("===========================================================================");
            sb.Append(Environment.NewLine);
            sb.AppendFormat("{0,-8}", "ID");
            sb.AppendFormat("{0,-45}", "NOME");
            sb.AppendFormat("{0,-18}", "CATEGORIA");
            sb.Append("PRECO");
            sb.Append(Environment.NewLine);


            foreach (var item in query)
            {
                totalJogos++;
                valorMedioPorJogo += item.Preco;
                if (valorMaisCaro < item.Preco)
                {
                    valorMaisCaro = item.Preco;
                    jogoMaisCaro = item.Nome;
                }
                if (valorMaisBarato > item.Preco)
                {
                    valorMaisBarato = item.Preco;
                    jogoMaisBarato = item.Nome;
                }

                sb.AppendFormat("{0,-8}", item.Id.ToString().PadLeft(3, '0'));
                sb.AppendFormat("{0,-45}", item.Nome);
                sb.AppendFormat("{0,-18}", item.Categoria);
                sb.Append("R$");
                sb.Append(item.Preco);
                sb.Append(Environment.NewLine);
            }
            valorMedioPorJogo = valorMedioPorJogo / totalJogos;

            string valorMedio = valorMedioPorJogo.ToString("0.00");

            //sb.AppendFormat("{0}{1}{2}{3}{4}{5}{6}{7}{8}",
            sb.Append("---------------------------------------------------------------------------");
            sb.Append(Environment.NewLine);
            sb.Append("Quantidade total de jogos: ");
            sb.Append(totalJogos);
            sb.Append(Environment.NewLine);
            sb.Append("Valor médio por jogo: R$");
            sb.Append(string.Format("{0:0.00}", valorMedio));
            sb.Append(Environment.NewLine);
            sb.Append("Jogo mais caro: ");
            sb.Append(jogoMaisCaro);
            sb.Append(Environment.NewLine);
            sb.Append("Jogo mais barato: ");
            sb.Append(jogoMaisBarato);
            sb.Append(Environment.NewLine);
            sb.Append("===========================================================================");

            File.WriteAllText(caminhoTxt, sb.ToString());
            return caminhoTxt;
        }
    }
}

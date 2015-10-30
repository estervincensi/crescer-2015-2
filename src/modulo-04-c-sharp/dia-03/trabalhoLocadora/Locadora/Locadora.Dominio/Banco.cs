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
                new XElement("preco", jogo.Preco),
                new XElement("categoria", jogo.Categoria)
                );

            xmlTree.SetAttributeValue("id", LastId + 1);
            xmlJogos.Add(xmlTree);

            xmlJogos.Save(caminhoArquivo);

        }


        public IList<Jogo> RealizarPesquisaPorNome(string nome)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogos = xmlJogos.Elements("jogo").Where(jogo => jogo.Element("nome").Value.Contains(nome)).ToList();

            IList<Jogo> lista = new List<Jogo>();
            foreach (var item in jogos)
	        {
                lista.Add(new Jogo(item.Element("nome").Value, double.Parse(item.Element("preco").Value), (Categoria)Enum.Parse(typeof(Categoria),item.Element("categoria").Value)));
	        }
            return lista;
        }

        public void EditarNomeDoJogo(string nome, string nomeNovo)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogo = xmlJogos.Elements("jogo").First(j => j.Element("nome").Value == nome);
            jogo.Element("nome").SetValue(nomeNovo);
            xmlJogos.Save(caminhoArquivo);
        }

        public void EditarPrecoDoJogo(string nome, double precoNovo)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogo = xmlJogos.Elements("jogo").First(j => j.Element("nome").Value == nome);
            jogo.Element("preco").SetValue(precoNovo);
            xmlJogos.Save(caminhoArquivo);
        }

        public void EditarCategoriaDoJogo(string nome, Categoria categoriaNova)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogo = xmlJogos.Elements("jogo").First(j => j.Element("nome").Value == nome);
            jogo.Element("categoria").SetValue(categoriaNova);
            xmlJogos.Save(caminhoArquivo);
        }

        public void ExportarRelatorio()
        {
            StringBuilder sb = new StringBuilder();
            XElement xmlJogo = XElement.Load(caminhoArquivo);
            string caminhoTxt = @"C:\Users\Ester\Documents\ProjetoCrescer\crescer-2015-2\src\modulo-04-c-sharp\dia-03\trabalhoLocadora\arquivos\Relatorio.txt";
            //string caminhoTxt = @"C:\Users\ester.oliveira\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\trabalhoLocadora\arquivos\Relatorio.txt";
            string data = DateTime.Now.ToString("dd/MM/yyy");
            string hora = DateTime.Now.ToString("T");
            int totalJogos=0;
            double valorMedioPorJogo=0;
            var query = from jogo in xmlJogo.Elements("jogo")
                        select new Jogo()
                        {
                            Id = int.Parse(jogo.Attribute("id").Value),
                            Nome = jogo.Element("nome").Value,
                            Categoria = (Categoria)Enum.Parse(typeof(Categoria), jogo.Element("categoria").Value),
                            Preco = double.Parse(jogo.Element("preco").Value)
                        };
            sb.AppendFormat("{0}{1}{2}{3,65}{4}{5}{6}{7}{8}{9}{10,-8}{11,-45}{12,-18}{13}{14}",
                "LOCADORA NUNES GAMES".PadLeft(50),
                Environment.NewLine,
                data,
                hora,
                Environment.NewLine,
                "Relatório de Jogos".PadLeft(50),
                Environment.NewLine,
                Environment.NewLine,
                "===========================================================================",
                Environment.NewLine,
                "ID",
                "NOME",
                "CATEGORIA",
                "PRECO",
                Environment.NewLine);

            foreach (var item in query)
            {
                //ListaDeJogos += @"  " + item.Attribute("id").Value + "     "
                //    + item.Element("categoria").Value + "    "
                //    + item.Element("nome").Value + "     "
                //    + item.Element("preco").Value + "     "
                //    + Environment.NewLine;
                totalJogos++;
                valorMedioPorJogo += item.Preco;
               

                sb.AppendFormat("{0,-8}{1,-45}{2,-20}{3}{4,-20}{5}",
                    item.Id.ToString().PadLeft(3, '0'),
                    item.Nome,
                    item.Categoria,
                    "R$",
                    item.Preco,
                    Environment.NewLine);
            }
            valorMedioPorJogo = valorMedioPorJogo / totalJogos;
            
            string valorMedio = valorMedioPorJogo.ToString("0.00");

            sb.AppendFormat("{0}{1}{2}{3}{4}{5}{6}{7}{8}",
                "---------------------------------------------------------------------------",
                Environment.NewLine,
                "Quantidade total de jogos: ",
                totalJogos,
                Environment.NewLine,
                "Valor médio por jogo: R$",
                string.Format("{0:0.00}",valorMedio),
                Environment.NewLine,
                "===========================================================================");

            File.WriteAllText(caminhoTxt, sb.ToString());

        }
    }
}

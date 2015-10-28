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
        static string caminhoArquivo = @"C:\Users\ester.oliveira\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\trabalhoLocadora\arquivos\game_store.xml";
        

        public void CadastrarNovoJogo(Jogo jogo)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);

            XElement xmlTree = new XElement("jogo",
                new XElement("nome", jogo.Nome),
                new XElement("preco",jogo.Preco),
                new XElement("categoria",jogo.Categoria)
                );

            xmlTree.SetAttributeValue("id",jogo.Id);
            xmlJogos.Add(xmlTree);

            xmlJogos.Save(caminhoArquivo);
            
        }

        public void RealizarPesquisaPorNome(string nome)
        {

        }

        public void EditarJogo(string id, Jogo jogo)
        {

        }

        public void ExportarRelatorio()
        {

        }
    }
}

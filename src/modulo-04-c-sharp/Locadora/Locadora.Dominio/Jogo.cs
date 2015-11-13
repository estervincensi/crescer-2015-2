using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public Categoria Categoria { get; set; }

        public int? IdCliente { get; set; }

        public Cliente Cliente { get; set; }

        public Selo Selo { get; set; }

        public string Imagem { get; set; }

        public string Descricao { get; set; }

        public string Video { get; set; }

        public DateTime? DataLocacao { get; set; }

        public Jogo()
        {

        }

        public Jogo(int id,string nome, Selo selo, string descricao, Cliente cliente = null)
        {
            this.Id = id;
            this.Cliente = cliente;
            this.Selo = selo;
            this.Descricao = descricao;
            this.Nome = nome;
        }

        public void LocarPara(Cliente cliente)
        {
            this.IdCliente = cliente.Id;
            this.Cliente = cliente;
            this.DataLocacao = DateTime.Now;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Categoria: " + this.Categoria);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if (obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Categoria == jogoComp.Categoria
                    && this.Cliente.Id == jogoComp.Cliente.Id;
            }

            return false;
        }
    }
}

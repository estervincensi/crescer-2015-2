using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Serviços
{
    public class ServicoLocacao
    {
        private IJogoRepositorio jogoRepositorio;
        private IClienteRepositorio clienteRepositorio;

        public ServicoLocacao(IJogoRepositorio jogoRepositorio, IClienteRepositorio clienteRepositorio)
        {
            this.jogoRepositorio = jogoRepositorio;
            this.clienteRepositorio = clienteRepositorio;

        }
        public DateTime VerificaDataPrevistaDeEntrega(int id)
        {
            Selo selo = BuscaSeloDoJogo(id);
            if (selo == Selo.OURO)
            {
                return DateTime.Now.AddDays(1);
            }
            else if (selo == Selo.PRATA)
            {
                return DateTime.Now.AddDays(2);
            }
            else
            {
                return DateTime.Now.AddDays(3);
            }
        }

        public decimal VerificaValorDoJogo(int id)
        {
            Selo selo = BuscaSeloDoJogo(id);
            if (selo == Selo.OURO)
            {
                return 15;
            }
            else if (selo == Selo.PRATA)
            {
                return 10;
            }
            else
            {
                return 5;
            }
        }

        private Selo BuscaSeloDoJogo(int id)
        {
            Jogo jogo = jogoRepositorio.BuscarPorId(id);
            return jogo.Selo;
        }

        public bool PodeLocar(string nomeCliente)
        {
            Cliente cliente = clienteRepositorio.BuscaUmClientePorNome(nomeCliente);
            var lista = jogoRepositorio.BuscarTodos().Where(j => j.Cliente.Id == cliente.Id);
            return true;
        }

    }
}

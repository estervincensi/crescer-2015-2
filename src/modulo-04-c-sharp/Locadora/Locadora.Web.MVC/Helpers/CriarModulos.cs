﻿using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Serviços;
using Locadora.Infraestrutura.Servicos;
using Locadora.Repositorio.EF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Helpers
{
    public class CriarModulos
    {
        public static IJogoRepositorio CriarJogoRepositorio()
        {
            return new JogoRepositorio();
        }
        
        public static IClienteRepositorio CriarClienteRepositorio()
        {
            return new ClienteRepositorio();
        }
        public static IUsuarioRepositorio CriarUsuarioRepositorio()
        {
            return new UsuarioRepositorio();
        }

        public static IServicoCriptografia CriarServicoCriptografia()
        {
            return new ServicoCriptografia();
        }

        public static ServicoAutenticacao CriarServicoAutenticacao()
        {
            return new ServicoAutenticacao(CriarUsuarioRepositorio(),CriarServicoCriptografia());
        }

        public static ServicoLocacao CriarServicoLocacao()
        {
            return new ServicoLocacao(CriarJogoRepositorio(),CriarClienteRepositorio());
        }
    }
}
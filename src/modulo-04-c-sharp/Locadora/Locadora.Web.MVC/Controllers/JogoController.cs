﻿using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        //private IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();
        private IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();

        public ActionResult Manter(int? id)
        {

            if (id.HasValue)
            {
                int idComValor = (int)id;
                var jogo = repositorio.BuscarPorId(idComValor);
                var model = new InserirJogoModel()
                {
                    IdJogo = jogo.Id,
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Selo = jogo.Selo,
                    Categoria = jogo.Categoria,
                    Imagem = jogo.Imagem,
                    Video = jogo.Video,
                    Descricao = jogo.Descricao
                };
                return View(model);
            }
            else
            {
                return View();
            }

        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(InserirJogoModel model)
        {
            if (ModelState.IsValid)
            {
                //salvar no banco
                if (model.IdJogo==null)
                {
                    Jogo inserir = new Jogo()
                    {
                        Nome = model.Nome,
                        Preco = model.Preco,
                        Selo = model.Selo,
                        Categoria = model.Categoria,
                        Imagem = model.Imagem,
                        Video = model.Video,
                        Descricao = model.Descricao

                    };
                    repositorio.Criar(inserir);
                }
                else
                {
                    int id = model.IdJogo ?? default(int);
                    Jogo atualizar = new Jogo(id, model.Selo,model.Descricao)
                    {
                        Nome = model.Nome,
                        Preco = model.Preco,
                        Categoria = model.Categoria,
                        Imagem = model.Imagem,
                        Video = model.Video,

                    };
                    repositorio.Atualizar(atualizar);
                }
                return RedirectToAction("JogosDisponiveis","Relatorio");
            }
            else
            {
                var errors = ModelState.Values.SelectMany(v=>v.Errors);
                return View("Manter", model);
            }
        }
    }
}
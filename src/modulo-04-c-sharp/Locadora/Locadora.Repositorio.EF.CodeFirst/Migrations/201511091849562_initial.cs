namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;

    public partial class initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                    })
                .PrimaryKey(t => t.Id);
            CreateTable(
                "dbo.Selo",
                c => new
                {
                    IdSelo = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false)
                })
                .PrimaryKey(f => f.IdSelo);
            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    IdCategoria = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false)
                })
                .PrimaryKey(f => f.IdCategoria);
            CreateTable(
                "dbo.Jogo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCategoria = c.Int(nullable: false),
                        IdSelo = c.Int(nullable: false),
                        Imagem = c.String(),
                        Descricao = c.String(nullable: false),
                        Video = c.String(),
                        IdClienteLocacao = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdClienteLocacao)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .ForeignKey("dbo.Categoria", t => t.IdCategoria)
                .Index(t => t.IdClienteLocacao);
            Sql("INSERT INTO dbo.Categoria VALUES ('RPG')");
            Sql("INSERT INTO dbo.Categoria VALUES ('Corrida')");
            Sql("INSERT INTO dbo.Categoria VALUES ('Aventura')");
            Sql("INSERT INTO dbo.Categoria VALUES ('Luta')");
            Sql("INSERT INTO dbo.Categoria VALUES ('Esporte')");
            Sql("INSERT INTO dbo.Selo VALUES ('Ouro')");
            Sql("INSERT INTO dbo.Selo VALUES ('Prata')");
            Sql("INSERT INTO dbo.Selo VALUES ('Bronze')");

        }

        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
        }
    }
}

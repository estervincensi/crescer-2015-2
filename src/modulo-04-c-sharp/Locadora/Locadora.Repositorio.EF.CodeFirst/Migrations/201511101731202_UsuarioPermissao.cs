namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class UsuarioPermissao : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NomeCompleto = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissaos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PermissaoUsuarios",
                c => new
                    {
                        Permissao_Id = c.Int(nullable: false),
                        Usuario_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Permissao_Id, t.Usuario_Id })
                .ForeignKey("dbo.Permissaos", t => t.Permissao_Id, cascadeDelete: true)
                .ForeignKey("dbo.Usuarios", t => t.Usuario_Id, cascadeDelete: true)
                .Index(t => t.Permissao_Id)
                .Index(t => t.Usuario_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.PermissaoUsuarios", "Usuario_Id", "dbo.Usuarios");
            DropForeignKey("dbo.PermissaoUsuarios", "Permissao_Id", "dbo.Permissaos");
            DropIndex("dbo.PermissaoUsuarios", new[] { "Usuario_Id" });
            DropIndex("dbo.PermissaoUsuarios", new[] { "Permissao_Id" });
            DropTable("dbo.PermissaoUsuarios");
            DropTable("dbo.Permissaos");
            DropTable("dbo.Usuarios");
        }
    }
}

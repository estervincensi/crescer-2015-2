namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class correcoes : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.PermissaoUsuarios", newName: "UsuarioPermissaos");
            DropPrimaryKey("dbo.UsuarioPermissaos");
            AddPrimaryKey("dbo.UsuarioPermissaos", new[] { "Usuario_Id", "Permissao_Id" });
        }
        
        public override void Down()
        {
            DropPrimaryKey("dbo.UsuarioPermissaos");
            AddPrimaryKey("dbo.UsuarioPermissaos", new[] { "Permissao_Id", "Usuario_Id" });
            RenameTable(name: "dbo.UsuarioPermissaos", newName: "PermissaoUsuarios");
        }
    }
}

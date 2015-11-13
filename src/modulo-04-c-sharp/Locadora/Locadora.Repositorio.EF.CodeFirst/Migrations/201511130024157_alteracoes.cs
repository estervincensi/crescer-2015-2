namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class alteracoes : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Jogo", "DataLocacao", c => c.DateTime());
            DropColumn("dbo.Jogo", "DataDevolucao");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "DataDevolucao", c => c.DateTime());
            DropColumn("dbo.Jogo", "DataLocacao");
        }
    }
}

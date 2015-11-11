namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Cria_Coluna_Data_em_Jogo : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Jogo", "DataDevolucao", c => c.DateTime());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Jogo", "DataDevolucao");
        }
    }
}

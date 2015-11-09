using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA2")
        {

        }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Jogo> Jogo { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new JogoMap());
            base.OnModelCreating(modelBuilder);
        }
    }


    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(c => c.Id);
            Property(p => p.Nome).IsRequired().HasMaxLength(250);
        }
    }
    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(j => j.Id);
            Property(j => j.Nome).IsRequired().HasMaxLength(250);
            Property(j => j.Preco).IsRequired();
            Property(j => j.Descricao).IsRequired();
            Property(j => j.Imagem).IsOptional();
            Property(j => j.Video).IsOptional();
            Property(j => j.Categoria).IsRequired().HasColumnName("IdCategoria");
            Property(j => j.Selo).IsRequired().HasColumnName("IdSelo");

            HasOptional(p => p.Cliente).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
        }
    }
}

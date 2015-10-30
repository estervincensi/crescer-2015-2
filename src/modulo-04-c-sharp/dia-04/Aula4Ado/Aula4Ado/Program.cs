using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace Aula4Ado
{
    class Program
    {
        static void Main(string[] args)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "UPDATE Cargo SET Nome = @paramNome WHERE IDCargo = 1";

                comando.AddParameter("paramNome","Didi");
                
                connection.Open();

                comando.ExecuteNonQuery();

   
                transacao.Complete();

                connection.Close();
            }        

            Console.Read();
        }
    }
}

/*
//Exemplo de Comando sem select no banco
string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
IDbConnection connection = new SqlConnection(connectionString);

IDbCommand comando = connection.CreateCommand();
string novoNome = "voto null";
comando.CommandText = "UPDATE Candidato SET NomeCompleto=@paramNomeCompleto WHERE IDCandidato=1";

var parameter = comando.CreateParameter();
parameter.ParameterName = "paramNomeCompleto";
parameter.Value = novoNome;

comando.Parameters.Add(parameter);

connection.Open();

int afetados = comando.ExecuteNonQuery();

connection.Close();
*/
/*
//Exemplo select
string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT * FROM Partido";

                connection.Open();

                var reader = comando.ExecuteReader();

                while (reader.Read())
                {
                    string nome = reader["Nome"].ToString();
                    Console.WriteLine(nome);
                }
                connection.Close();
            }    
*/

using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aula4Ado
{
    class CargoRepositorio : IRepositorio<Cargo>
    {
        public Cargo BuscarPorId(int id)
        {
            Cargo cargoEncontrado = null;
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT * FROM Cargo WHERE IdCargo=@paramIdCargo";

                comando.AddParameter("paramIdCargo", "idCargo");

                connection.Open();

                IDataReader reader = comando.ExecuteReader();
                if (reader.Read()){
                    int idDb = Convert.ToInt32(reader["IDCargo"]);
                    string nome = reader["Nome"].ToString();
                    string situacao = reader["Situacao"].ToString();

                    cargoEncontrado = new Cargo(idDb,nome);
                    cargoEncontrado.Situacao = situacao;
                }
                connection.Close();
                return cargoEncontrado;
            }
        }
    }
}

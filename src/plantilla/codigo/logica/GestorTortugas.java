package plantilla.codigo.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import plantilla.codigo.pojo.Tortuga;
import plantilla.codigo.utils.DBUtils;

public class GestorTortugas implements GestorInterfaz <Tortuga>{

	public List<Tortuga> obtenerTodosLosAnimales() {
		List<Tortuga> ret = null;
		String sql = "select * from t_tortugas";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Tortuga>();

				Tortuga tortuga = new Tortuga();
				tortuga.setId(resultSet.getInt("id"));
				tortuga.setEspecie(resultSet.getString("especie"));
				tortuga.setAguaDulce(resultSet.getBoolean("aguaDulce"));

				ret.add(tortuga);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
		}
		return ret;
	}

	@Override
	public List<Tortuga> obtenerAnimalPorId(int id) {
		List<Tortuga> ret = null;
		String sql = "select * from t_tortugas where id = " + id;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Tortuga>();

				Tortuga tortuga = new Tortuga();
				tortuga.setId(resultSet.getInt("id"));
				tortuga.setEspecie(resultSet.getString("especie"));
				tortuga.setAguaDulce(resultSet.getBoolean("aguaDulce"));

				ret.add(tortuga);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
		}
		return ret;
	}

	@Override
	public List<Tortuga> anadirAnimal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tortuga> borrarAnimal(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tortuga> modificarAnimal(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

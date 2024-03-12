package plantilla.codigo.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import plantilla.codigo.pojo.Perro;
import plantilla.codigo.utils.DBUtils;

public class GestorPerros implements GestorInterfaz <Perro>{

	public List<Perro> obtenerTodosLosAnimales() {
		List<Perro> ret = null;
		String sql = "select * from t_perros";

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
					ret = new ArrayList<Perro>();

				Perro perro = new Perro();
				perro.setId(resultSet.getInt("id"));
				perro.setNombre(resultSet.getString("nombre"));
				perro.setRaza(resultSet.getString("raza"));
				perro.setVacunado(resultSet.getBoolean("vacunado"));

				ret.add(perro);
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
	public List<Perro> obtenerAnimalPorId(int id) {
		List<Perro> ret = null;
		String sql = "select * from t_perros where id =" + id;

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
					ret = new ArrayList<Perro>();

				Perro perro = new Perro();
				perro.setId(resultSet.getInt("id"));
				perro.setNombre(resultSet.getString("nombre"));
				perro.setRaza(resultSet.getString("raza"));
				perro.setVacunado(resultSet.getBoolean("vacunado"));

				ret.add(perro);
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
	public List<Perro> anadirAnimal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Perro> borrarAnimal(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Perro> modificarAnimal(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

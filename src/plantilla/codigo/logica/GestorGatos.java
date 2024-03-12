package plantilla.codigo.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import plantilla.codigo.pojo.Gato;
import plantilla.codigo.utils.DBUtils;

public class GestorGatos implements GestorInterfaz <Gato>{

	public List<Gato> obtenerTodosLosAnimales() {
		List<Gato> ret = null;
		String sql = "select * from t_gatos";

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
					ret = new ArrayList<Gato>();

				Gato gato = new Gato();
				gato.setId(resultSet.getInt("id"));
				gato.setNombre(resultSet.getString("nombre"));
				gato.setRaza(resultSet.getString("raza"));
				gato.setColor(resultSet.getString("color"));

				ret.add(gato);
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
	public List<Gato> obtenerAnimalPorId(int id) {
		List<Gato> ret = null;
		String sql = "select * from t_gatos where id = " + id;

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
					ret = new ArrayList<Gato>();

				Gato gato = new Gato();
				gato.setId(resultSet.getInt("id"));
				gato.setNombre(resultSet.getString("nombre"));
				gato.setRaza(resultSet.getString("raza"));
				gato.setColor(resultSet.getString("color"));

				ret.add(gato);
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
	public List<Gato> anadirAnimal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gato> borrarAnimal(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gato> modificarAnimal(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

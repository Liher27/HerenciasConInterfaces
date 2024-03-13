package plantilla.codigo.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import plantilla.codigo.pojo.Gato;
import plantilla.codigo.utils.DBUtils;

public class GestorGatos implements GestorInterfaz<Gato> {

	Scanner teclado = null;

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
	public boolean anadirAnimal() {
		teclado = new Scanner(System.in);

		System.out.println("Introduce el id del nuevo gato: ");
		int getInputCatId = teclado.nextInt();

		System.out.println("Introduce el nombre del nuevo gato: ");
		String getInputCatName = teclado.next();

		System.out.println("Introduce la raza del nuevo gato: ");
		String getInputCatRace = teclado.next();

		System.out.println("Introduce la raza del nuevo gato: ");
		String getInputCatColor = teclado.next();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "INSERT INTO t_gatos (`id`, `nombre`, `raza`, `color`)" + " VALUES (?,?,?,?);";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, getInputCatId);
			preparedStatement.setString(2, getInputCatName);
			preparedStatement.setString(3, getInputCatRace);
			preparedStatement.setString(4, getInputCatColor);

			int i = preparedStatement.executeUpdate();

			if (i > 0) {
				return true;
			}

		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();

			DBUtils reto3Utils = new DBUtils();
			reto3Utils.release(connection, preparedStatement, null);
		}

		return false;

	}

	@Override
	public void borrarAnimal(int id) {
		try {
			Class.forName(DBUtils.DRIVER);

			Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			Statement statement = connection.createStatement();

			String sql = "DELETE FROM t_gatos WHERE id = '" + id + "'";
			statement.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			System.out.println("Ha dado fallo -> " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Malformacion sqlazo -> " + e.getMessage());
		}
	}

	@Override
	public boolean modificarAnimal(int id) {
		return false;
	}
}

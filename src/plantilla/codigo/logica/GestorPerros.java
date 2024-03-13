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

import plantilla.codigo.pojo.Perro;
import plantilla.codigo.utils.DBUtils;

public class GestorPerros implements GestorInterfaz<Perro> {

	Scanner teclado = null;

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
				perro.setVacunado(resultSet.getString("vacunado"));

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
				perro.setVacunado(resultSet.getString("vacunado"));

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

	public boolean anadirAnimal() {

		teclado = new Scanner(System.in);

		System.out.println("Introduce el id del nuevo perro: ");
		int getInputDogId = teclado.nextInt();

		System.out.println("Introduce el nombre del nuevo perro: ");
		String getInputDogName = teclado.next();

		System.out.println("Introduce la raza del nuevo perro: ");
		String getInputDogRace = teclado.next();

		System.out.println("Introduce si el nuevo perro esta vacunado (si o no): ");
		String getInputDogVaccinated = teclado.next();

		if (getInputDogVaccinated.equalsIgnoreCase("Si") || getInputDogVaccinated.equalsIgnoreCase("No")) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				Class.forName(DBUtils.DRIVER);

				connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

				String sql = "INSERT INTO t_perros (`id`, `nombre`, `raza`, `vacunado`)" + " VALUES (?,?,?,?);";
				preparedStatement = connection.prepareStatement(sql);

				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, getInputDogId);
				preparedStatement.setString(2, getInputDogName);
				preparedStatement.setString(3, getInputDogRace);
				preparedStatement.setString(4, getInputDogVaccinated);

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
		} else {
			System.out.println(
					"No has insertado una opcion correcta a la hora de vacunar, vuelve a intentar (Solo Si o No.");
		}
		return false;
	}

	@Override
	public void borrarAnimal(int id) {
		try {
			Class.forName(DBUtils.DRIVER);

			Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			Statement statement = connection.createStatement();

			String sql = "DELETE FROM t_perros WHERE id = '" + id + "'";
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

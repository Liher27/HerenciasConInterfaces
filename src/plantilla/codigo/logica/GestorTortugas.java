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

import plantilla.codigo.pojo.Tortuga;
import plantilla.codigo.utils.DBUtils;

public class GestorTortugas implements GestorInterfaz<Tortuga> {

	Scanner teclado = null;
	Tortuga tortuga = new Tortuga();

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
				tortuga.setAguaDulce(resultSet.getString("aguaDulce"));

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
				tortuga.setAguaDulce(resultSet.getString("aguaDulce"));

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
	public boolean anadirAnimal() {
		teclado = new Scanner(System.in);

		System.out.println("Introduce el id de la nueva tortuga: ");
		int getInputTortId = teclado.nextInt();

		System.out.println("Introduce el nombre de la nueva tortuga: ");
		String getInputTortSpecies = teclado.next();

		System.out.println("Introduce si la nueva tortuga es de agua dulce o no(si o no): ");
		String getInputTortWaterType = teclado.next();

		if (getInputTortWaterType.equalsIgnoreCase("Si") || getInputTortWaterType.equalsIgnoreCase("No")) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				Class.forName(DBUtils.DRIVER);

				connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

				String sql = "INSERT INTO t_tortugas (`id`, `especie`, `aguaDulce`)" + " VALUES (?,?,?);";
				preparedStatement = connection.prepareStatement(sql);

				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, getInputTortId);
				preparedStatement.setString(2, getInputTortSpecies);
				preparedStatement.setString(3, getInputTortWaterType);

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
					"No has insertado una opcion correcta a la hora de seleccionar si es de agua dulce, vuelve a intentar (Solo Si o No.");
		}
		return false;
	}

	@Override
	public void borrarAnimal(int id) {
		try {
			Class.forName(DBUtils.DRIVER);

			Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			Statement statement = connection.createStatement();

			String sql = "DELETE FROM t_tortugas WHERE id = '" + id + "'";
			statement.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			System.out.println("Ha dado fallo -> " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Malformacion sqlazo -> " + e.getMessage());
		}
	}

	@Override
	public boolean modificarAnimal(int id) {

		try {
			Class.forName(DBUtils.DRIVER);

			Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			Statement statement = connection.createStatement();

			String sql = "DELETE FROM t_tortugas WHERE id = '" + id + "'";
			statement.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			System.out.println("Ha dado fallo -> " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Malformacion sqlazo -> " + e.getMessage());
		}

		teclado = new Scanner(System.in);

		System.out.println("Introduce la especie de la nueva tortuga: ");
		String getInputTortSpecies = teclado.next();

		System.out.println("Introduce si la nueva tortuga es de agua dulce o no(si o no): ");
		String getInputTortWaterType = teclado.next();

		if (getInputTortWaterType.equalsIgnoreCase("Si") || getInputTortWaterType.equalsIgnoreCase("No")) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				Class.forName(DBUtils.DRIVER);

				connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

				String sql = "INSERT INTO t_tortugas (`id`, `especie`, `aguaDulce`)" + " VALUES (" + id + ","
						+ getInputTortSpecies + "," + getInputTortWaterType + ");";

				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, getInputTortSpecies);
				preparedStatement.setString(3, getInputTortWaterType);

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
					"No has insertado una opcion correcta a la hora de seleccionar si es de agua dulce, vuelve a intentar (Solo Si o No.");
		}
		return false;

	}

}

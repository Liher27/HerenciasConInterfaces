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

import plantilla.codigo.pojo.Cocodrilo;
import plantilla.codigo.utils.DBUtils;

public class GestorCocodrilos implements GestorInterfaz<Cocodrilo> {

	Scanner teclado = null;

	public List<Cocodrilo> obtenerTodosLosAnimales() {
		List<Cocodrilo> ret = null;
		String sql = "select * from t_cocodrilos";

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
					ret = new ArrayList<Cocodrilo>();

				Cocodrilo cocodrilo = new Cocodrilo();
				cocodrilo.setId(resultSet.getInt("id"));
				cocodrilo.setEspecie(resultSet.getString("especie"));
				cocodrilo.setAguaDulce(resultSet.getString("aguaDulce"));
				cocodrilo.setNumeroDientes(resultSet.getInt("numero de dientes"));

				ret.add(cocodrilo);
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
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}
		return ret;
	}

	@Override
	public List<Cocodrilo> obtenerAnimalPorId(int id) {

		List<Cocodrilo> ret = null;
		String sql = "select * from t_cocodrilos where id = " + id;

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
					ret = new ArrayList<Cocodrilo>();

				Cocodrilo cocodrilo = new Cocodrilo();
				cocodrilo.setId(resultSet.getInt("id"));
				cocodrilo.setEspecie(resultSet.getString("especie"));
				cocodrilo.setAguaDulce(resultSet.getString("aguaDulce"));
				cocodrilo.setNumeroDientes(resultSet.getInt("numero de dientes"));

				ret.add(cocodrilo);
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
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}
		return ret;

	}

	@Override
	public boolean anadirAnimal() {
		teclado = new Scanner(System.in);

		System.out.println("Introduce el id del nuevo cocodrilo: ");
		int getInputCrocId = teclado.nextInt();

		System.out.println("Introduce el nombre del nuevo cocodrilo: ");
		String getInputCrocSpecies = teclado.next();

		System.out.println("Introduce si el nuevo cocodrilo es de agua dulce o no (si o no): ");
		String getInputCrocWaterType = teclado.next();

		System.out.println("Introduce el numero de dientes del cocodrilo: ");
		int getInputCrocTeethNum = teclado.nextInt();

		if (getInputCrocWaterType.equalsIgnoreCase("Si") || getInputCrocWaterType.equalsIgnoreCase("No")) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				Class.forName(DBUtils.DRIVER);

				connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

				String sql = "INSERT INTO t_cocodrilos (`id`, `especie`, `aguaDulce`, `numDientes`)"
						+ " VALUES (?,?,?,?);";
				preparedStatement = connection.prepareStatement(sql);

				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, getInputCrocId);
				preparedStatement.setString(2, getInputCrocSpecies);
				preparedStatement.setString(3, getInputCrocWaterType);
				preparedStatement.setInt(4, getInputCrocTeethNum);

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

			String sql = "DELETE FROM t_cocodrilos WHERE id = '" + id + "'";
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

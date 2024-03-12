package plantilla.codigo.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import plantilla.codigo.pojo.Cocodrilo;
import plantilla.codigo.utils.DBUtils;

public class GestorCocodrilos implements GestorInterfaz <Cocodrilo>{

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
				cocodrilo.setAguaDulce(resultSet.getBoolean("aguaDulce"));
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
				cocodrilo.setAguaDulce(resultSet.getBoolean("aguaDulce"));
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
	public List<Cocodrilo> anadirAnimal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cocodrilo> borrarAnimal(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cocodrilo> modificarAnimal(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

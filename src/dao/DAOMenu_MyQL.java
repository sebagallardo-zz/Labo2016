package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOMenu_MyQL implements DAOMenu {
	
	@Override
	public void guardar(Menu m) {
		
		Connection connection = Conexion.getConnection();
		String insertar = 
				"INSERT INTO menus (nombre, descripcion ,precio)"
				+"VALUES (?,?,?);";
		try {
			PreparedStatement st = connection.prepareStatement(insertar);
			st.clearParameters();
			st.setString(1, m.getNombre());
			st.setString(2, m.getDescripcion());
			st.setFloat(3, m.getPrecio());
			
			st.executeUpdate();
			st.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(Menu m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Menu m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Menu buscarPorNombre(String nombre) {
		Connection connection = Conexion.getConnection();
		String buscar = 
				"SELECT * FROM menus WHERE nombre = ?";
		try {
			PreparedStatement st = connection.prepareStatement(buscar);
			st.clearParameters();
			st.setString(1, nombre);
			
			ResultSet result = st.executeQuery();
			
			if (result.next()){
				Menu m = new Menu(
						result.getString("nombre"),
						result.getString("descripcion"),
						result.getFloat("precio")
					);
				st.close();
				connection.close();
				return m;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exploto con todo");
		}
		return null;
	}

	@Override
	public List<Menu> listar() {
		Connection connection = Conexion.getConnection();
		String buscar = 
				"SELECT * FROM menus";
		try {
			PreparedStatement st = connection.prepareStatement(buscar);
			
			ResultSet result = st.executeQuery();
			
			List<Menu> list = new ArrayList<Menu>();
			
			while (result.next()){
				Menu m = new Menu(
						result.getString("nombre"),
						result.getString("descripcion"),
						result.getFloat("precio")
					);
				list.add(m);
			}
			
			st.close();
			connection.close();
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exploto con todo");
		}
		return null;
	}
	
}

package dao;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		Menu m = new Menu();
		m.setNombre("tarta");
		m.setDescripcion("j y q");
		m.setPrecio((float) 150.0);
		
		DAOMenu dao = Factory.getDAOMenu();
		
		dao.guardar(m);
		
		Menu resultado = dao.buscarPorNombre("tarta");
		
		System.out.println(resultado.getNombre());
		
		List<Menu> list = dao.listar();
		System.out.println(list.size());

	}

}

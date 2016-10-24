package dao;

import java.util.List;

public interface DAOMenu {
	
	public void 		guardar(Menu m);
	public void 		modificar(Menu m);
	public void 		borrar(Menu m);
	public Menu 		buscarPorNombre(String nombre);
	public List<Menu> 	listar();
		
}

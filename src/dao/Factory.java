package dao;

public class Factory {

	public static DAOMenu getDAOMenu(){
		return new DAOMenu_MyQL();
	}
}

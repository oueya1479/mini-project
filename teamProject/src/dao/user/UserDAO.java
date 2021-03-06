package dao.user;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;

public interface UserDAO {

	public Customer  searchMyInform(String id, String password) throws SQLException;

	public int modifyMyInform(String password, String pname, double pweight)throws SQLException;

	public int deleteMyInform(String id, String password)throws SQLException;

}

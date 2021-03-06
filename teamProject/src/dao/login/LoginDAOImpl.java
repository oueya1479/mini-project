package dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.DBUtil;
import dto.Customer;

public class LoginDAOImpl implements LoginDAO {
	
	private Properties proFile = DBUtil.getProfile();
	
	@Override
	public Customer checkLogin (String id, String password)throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("login.checkLogin");
		Customer customer = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, password);

			rs = ps.executeQuery();
			if(rs.next()) {
				String cstmName=rs.getString("cstm_name");
				
				customer = new Customer(id, password, cstmName);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return customer;
		
	}
	



}

package controller.login;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;
import service.login.LoginService;
import service.login.LoginServiceImpl;
import view.FailView;
import view.SuccessView;
import view.menu.SubView;

public class LoginController {

	LoginService service = new LoginServiceImpl();
	
	/**
	 * 입력한 id와 pw를 확인하여 로그인하는 메소드
	 */
	
		
	public Customer checkLogin(String id, String password) {
		try {
			Customer customer=service.checkLogin(id,password);	
			
			SuccessView.printMessage("원하시는 서비스를 선택해주세요 ^^");
			System.out.println();
			SubView.printSubView();
			return customer;
			
		}catch(SQLException e) {
			FailView.printMessage(e.getMessage());
			
	
		
		}
		return null;
	
	}
	
	
}
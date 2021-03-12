package controller.reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Customer;
import dto.Price;
import dto.Reservation;
import service.reservation.ReservationServiceImpl;
import view.FailView;
import view.SuccessView;

public class ReservationController {
	private ReservationServiceImpl service = ReservationServiceImpl.getInstance();
	
	public boolean checkType(List<Price> list, String type) {
		if(service.checkType(list, type) != null) return true;
		else {
			FailView.printMessage("해당 항목이 존재하지 않습니다.");
			FailView.printMessage("다시 선택해주세요.");
			return false;
		}
	}
	
	public List<Integer> getReservationState(String calendar) {
		try {
			List<Integer> timeList = service.getReservationState(calendar);
			if(timeList != null) return timeList;
			else FailView.printMessage("예약가능한 시간이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Price> getPrice(int weight) {
		List<Price> list = null;
		try {
			list = new ArrayList<Price>();
			list = service.getPrice(weight);
			SuccessView.printPrice(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
		return list;
	}
	
	public Customer getCustomer() {
		Customer customer = null;
		try {
			customer = service.getCustomer();
		} catch(SQLException e) {
			FailView.printMessage("일치하는 사용자가 없습니다.");
		}
		return customer;
	}

	public void setReservation(Reservation reservation) {
		try {
			service.setReservation(reservation);
		} catch(SQLException e) {
			System.out.println("예약에 실패하셨습니다.");
		}
	}
}

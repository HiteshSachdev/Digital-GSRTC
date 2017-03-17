package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ReservationStatusBean;
import com.dsynhub.digitalgsrtc.dao.ReservationStatusDAO;


public class ReservationStatusListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ReservationStatusBean> listofReservationStatus = new ReservationStatusDAO().list();
		if(listofReservationStatus != null)
		{
			System.out.println("Hello");
			request.setAttribute("listofReservationStatus",listofReservationStatus);
			request.getRequestDispatcher("reservationStatusList.jsp").forward
			(request, response);
		}else{
			System.out.println("No Record Found....");
		}

		
	}

}
package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ReservationStatusBean;
import com.dsynhub.digitalgsrtc.dao.ReservationStatusDAO;


public class ReservationStatusEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String reservationStatusId = request.getParameter("reservationStatusId");
		
		ReservationStatusBean reservationStatusBean = new ReservationStatusDAO().getByPK(reservationStatusId);
		if(reservationStatusBean!=null){
				request.setAttribute("reservationStatusBean", reservationStatusBean);
				request.getRequestDispatcher("reservationStatusEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("ReservationStatusListServlet");
		}

		
	}

}

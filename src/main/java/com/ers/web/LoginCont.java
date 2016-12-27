package com.ers.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.beans.ERS_REIMBURSEMENT;
import com.ers.beans.ERS_USERS;
import com.ers.dao.Facade;
import com.ers.middle.BusinessDelegate;

public class LoginCont {

public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String username = request.getParameter("username");
		String password = request.getParameter("password");
		BusinessDelegate delegate = new BusinessDelegate();
		ERS_USERS user;
		
		HttpSession session = request.getSession();
		//boolean userOn = false;
		

		try {
			if(request.getSession().getAttribute("userSession")==null){
				user = delegate.login(username, password);
				if(user==null){
					//request.setAttribute();
				}
			}else{
				user = (ERS_USERS) session.getAttribute("userSession");
			}
			 
			if(user!=null && user.getRoleId().getId()>1){
				List<ERS_REIMBURSEMENT> reimb = new Facade().queryAllEmp(user);
				request.setAttribute("reimb", reimb);
				request.getSession().setAttribute("userSession", user);
				request.getRequestDispatcher("empLogged.jsp").forward(request, response); 
				
			}else if(user!=null && user.getRoleId().getId()==1){
				List<ERS_REIMBURSEMENT> reimb = new Facade().queryAllMan();
				request.setAttribute("resolverList", reimb);
				request.getSession().setAttribute("userSession", user);
				request.getRequestDispatcher("manLogged.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
	}

}

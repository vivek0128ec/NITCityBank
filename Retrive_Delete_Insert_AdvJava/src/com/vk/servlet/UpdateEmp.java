package com.vk.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dao.MyDao;
import com.nt.dto.MyDto;

public class UpdateEmp extends HttpServlet {
private Connection conn;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int empid=Integer.parseInt(req.getParameter("eid"));
		String salar=req.getParameter("salary");
	String desg=	req.getParameter("desg");
		try {
			PreparedStatement ps1=conn.prepareStatement("update  nareshit set salary=?,designation=? where empid=? ");
		      ps1.setString(1, salar);
		      ps1.setString(2, desg);
		      ps1.setInt(3, empid);
		      int k=ps1.executeUpdate();
		      String msg=null;
		      if(k>0) {
		    	  msg="record update";
		      }
		      else {
		    	  msg="record not update";
		      }
		      req.setAttribute("msg", msg);
		  	ArrayList<MyDto> al=new ArrayList<MyDto>();
			PreparedStatement ps2=conn.prepareStatement("select * from nareshit");
			ResultSet rs=ps2.executeQuery();
			while(rs.next()) {
				MyDto dto=new MyDto();
				dto.setEmpid(rs.getInt(1));
				dto.setEmployee(rs.getString(2));
				dto.setSalary(rs.getString(3));
				dto.setDesignstion(rs.getString(4));
				al.add(dto);}
				HttpSession hs=req.getSession();
				hs.setAttribute("mdto", al);
				RequestDispatcher rd=req.getRequestDispatcher("dis1");
				rd.forward(req, resp);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			conn=MyDao.getDbConn();
		}
		catch(Exception e) {
		e.printStackTrace();	
		}
	}

}

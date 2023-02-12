package com.spring.practice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.practice.dao.UserTestDAO;
import com.spring.practice.dto.UserTestDTO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		System.out.println(path);
		
		if(path.equals("/insert.do")) {
			UserTestDTO dto = new UserTestDTO();
			
			dto.setId("아이디 등록6");
			dto.setPass("비밀번호 등록6");
			
			UserTestDAO dao = new UserTestDAO();
			
			dao.insertUserDTO(dto);
		}
		
		if(path.equals("/list.do")) {
			UserTestDAO dao = new UserTestDAO();
			
			List<UserTestDTO> user_list = dao.getAllUsers();
			
			HttpSession session = request.getSession();
			session.setAttribute("user_list_session", user_list);
			
			
			response.sendRedirect("list.jsp");
			
		}
		
		if(path.equals("/detail.do")) {
			
			int idx=Integer.parseInt(request.getParameter("idx_f"));
			
			UserTestDTO dto = new UserTestDTO();
			System.out.println(idx);
			dto.setIdx(idx);
			
			UserTestDAO dao = new UserTestDAO();
			
			UserTestDTO user_detail=dao.getUserDetail(dto);
			
			HttpSession session = request.getSession();
			session.setAttribute("user_detail", user_detail);
			
			response.sendRedirect("detail.jsp");
			
		}
		
	}

}

package com.SweetChildhood.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.SweetChildhood.web.Service.SetPasswordService;

/**
 * Servlet implementation class UpPasswordServlet
 */
@WebServlet("/UpPassword")
public class UpPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");//UTF-8编码
        response.setHeader("Context-Type","text/html;charset=utf-8");
        String username;
        String userpass;
        HttpSession session = request.getSession();
        if (session!=null) {
        	if (session.getAttribute("username")!=null) {
                username = (String)session.getAttribute("username");
                userpass = request.getParameter("pass");
            int i = 0;
            try {
    		i = SetPasswordService.setPasswordService(username, userpass);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            if (i==1) {
    			request.setAttribute("message", "账号密码修改成功！");
    	        request.getRequestDispatcher("/Student/ok.jsp").forward(request, response);
    		}
            else {
            	request.setAttribute("err", "账号密码修改失败！");
    	        request.getRequestDispatcher("GoSetpass").forward(request, response);
    		}

    	}
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

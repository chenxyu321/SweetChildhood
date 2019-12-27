package com.SweetChildhood.web.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SweetChildhood.web.Bean.FankuiBean;
import com.SweetChildhood.web.Service.GetFankuiInfoService;

/**
 * Servlet implementation class FankuiServlet
 */
@WebServlet("/Fankui")
public class FankuiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FankuiServlet() {
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
        HttpSession session = request.getSession();
        if (session!=null) {
            String username;
            if (session.getAttribute("username")!=null) {
            	username = (String)session.getAttribute("username");
    			try {
    				ArrayList<FankuiBean> list = new ArrayList<FankuiBean>();
    				list = GetFankuiInfoService.getFankuiInfoService(username);
    				if (list!=null) {
    					request.setAttribute("Fankui", list);
    				}
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();

    			}
			}
	        request.getRequestDispatcher("/Student/Fankui.jsp").forward(request, response);
		}else {
			
			
			request.getRequestDispatcher("/Parent/index.jsp").forward(request, response);
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

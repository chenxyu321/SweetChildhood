package com.SweetChildhood.web.Servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SweetChildhood.web.Bean.NewsBean;
import com.SweetChildhood.web.Service.GetNewsInfoService;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/News")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
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
        if (request.getParameter("id")!=null) {
        	  int id = Integer.parseInt((String) request.getParameter("id"));
              ArrayList<NewsBean> list = new ArrayList<NewsBean>();
              try {
      			list = GetNewsInfoService.getNewsInfoService(id);
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
              if (list!=null) {
      			request.setAttribute("Newsinfo", list);
      		}
              request.getRequestDispatcher("News/index.jsp").forward(request,response);
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

package com.SweetChildhood.web.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.SweetChildhood.web.Bean.*;
import com.SweetChildhood.web.Service.*;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");//UTF-8编码
        response.setHeader("Context-Type","text/html;charset=utf-8");
		ArrayList<ReturnBean> list = null;
		ArrayList<PictureBean> piclist = null;
		ArrayList<NewsBean> newslist = null;
		ArrayList<ActiveBean> actList= null;
		try {
			list = GetReturnInfoService.getReturnInfoService();
			piclist = GetPictureInfoService.getPictureInfoService();
			newslist = GetNewsInfoService.getNewsInfoService();
			actList = GetActiveInfoService.getActiveInfoService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list!=null) {
			request.setAttribute("Return", list);
		}
		if (piclist!=null) {
			request.setAttribute("Picture", piclist);
		}
		if (newslist!=null) {
			request.setAttribute("News", newslist);
		}
		if (actList!=null) {
			request.setAttribute("Active", actList);
		}
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

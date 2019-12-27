package com.SweetChildhood.web.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SweetChildhood.web.Bean.ChengguoBean;
import com.SweetChildhood.web.Bean.ChengguophotoBean;
import com.SweetChildhood.web.Service.GetChengguoInfoService;
import com.SweetChildhood.web.Service.GetChengguophotoInfoService;

/**
 * Servlet implementation class ChengguophotoServlet
 */
@WebServlet("/ChengguoPhoto")
public class ChengguophotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChengguophotoServlet() {
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
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<ChengguoBean> list1 = new ArrayList<ChengguoBean>();
        ArrayList<ChengguophotoBean> list2 = new ArrayList<ChengguophotoBean>();
        try {
			list1 = GetChengguoInfoService.getChengguoInfoService(id);
			request.setAttribute("Chengguo", list1);
			list2 = GetChengguophotoInfoService.getChengguophotoInfoService(String.valueOf(id));
			request.setAttribute("Chengguophoto", list2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.getRequestDispatcher("/News/Chengguo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

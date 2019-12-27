package com.SweetChildhood.web.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SweetChildhood.web.Bean.ParentfankuiBean;
import com.SweetChildhood.web.Service.SetParentfankuiService;

/**
 * Servlet implementation class SetParentfankui
 */
@WebServlet("/SetParentfankui")
public class SetParentfankuiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetParentfankuiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//UTF-8编码
		response.setCharacterEncoding("UTF-8");//UTF-8编码
        response.setHeader("Context-Type","text/html;charset=utf-8");
        HttpSession session = request.getSession();
        if (session!=null) {
			String username = (String) session.getAttribute("username");
			String text = request.getParameter("name");
			Calendar c1 = Calendar.getInstance();
			String time =  c1.get(Calendar.YEAR)+"-"+(c1.get(Calendar.MONTH)+1)+"-"+c1.get(Calendar.DATE);
			ArrayList<ParentfankuiBean> list = new ArrayList<ParentfankuiBean>();
			ParentfankuiBean parentfankuiBean = new ParentfankuiBean();
			parentfankuiBean.setSid(username);
			parentfankuiBean.setText(text);
			parentfankuiBean.setTime(time);
			list.add(parentfankuiBean);
			int i = 0;
			try {
				i = SetParentfankuiService.setParentfankuiService(list);
				if (i!=0) {
					request.setAttribute("message", "谢谢您我们收到了您的反馈");
				}
				else {
					request.setAttribute("message", "抱歉系统好像出现了故障");
				}
				request.getRequestDispatcher("/Student/Message.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

package com.SweetChildhood.web.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.SweetChildhood.web.Service.GetParentInfoService;

/**
 * Servlet implementation class ParentloginServlet
 */
@WebServlet("/Parentlogin")
public class ParentloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParentloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");//UTF-8编码
        response.setHeader("Context-Type","text/html;charset=utf-8");
        String usernameString = null;
        String passwordString = null;
        usernameString = request.getParameter("name");
        passwordString = request.getParameter("pass");
        if (usernameString!=null&&passwordString!=null) {
        	boolean bo = false;
        	try {
				bo = GetParentInfoService.getParentInfoService(usernameString, passwordString);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if (bo) {
        		HttpSession session = request.getSession();
        		if (session.getAttribute("userlogin")==null) {
					session.setAttribute("username", usernameString);
					session.setAttribute("userlogin", "1");
					if (session.isNew()) {
						session.setAttribute("visit",  0);
					}
					else {
						 int i;
						 if (session.getAttribute("visit")!=null) {
							 i = (Integer)session.getAttribute("visit");
						     i += 1;
						     session.setAttribute("visit",  i);
						}
						
					}
				}
        		else {
        			  // 获取session创建时间
        			   Date createTime = new Date(session.getCreationTime());
        			   session.setAttribute("createTime", createTime);
        			   // 获取最后访问页面的时间
        			   Date lastAccessTime = new Date(session.getLastAccessedTime());
        			   session.setAttribute("lastTime", lastAccessTime);
				}
				request.getRequestDispatcher("StudentIndex").forward(request, response);
			}
        	else {
        		request.setAttribute("err", "用户名不存在或密码错误！");
				request.getRequestDispatcher("Parent").forward(request, response);
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

package com.SweetChildhood.web.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SweetChildhood.web.Bean.ChengyuanBean;
import com.SweetChildhood.web.Bean.HuodongBean;
import com.SweetChildhood.web.Bean.KetangbiaoxianBean;
import com.SweetChildhood.web.Bean.RuxuetestBean;
import com.SweetChildhood.web.Bean.SmininfoBean;
import com.SweetChildhood.web.Bean.ZuoyeBean;
import com.SweetChildhood.web.Service.GetChengyuanInfoService;
import com.SweetChildhood.web.Service.GetHuodongInfoService;
import com.SweetChildhood.web.Service.GetKetangbiaoxianInfoService;
import com.SweetChildhood.web.Service.GetSmininfoService;
import com.SweetChildhood.web.Service.GetZuoyeInfoService;
import com.SweetChildhood.web.Service.GetruxuekaoshiService;

/**
 * Servlet implementation class ZuoyeServlet
 */
@WebServlet("/dangan")
public class TodanganServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodanganServlet() {
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
        HttpSession session = request.getSession();
        if(session.getAttribute("username")!=null)
        {
        	String username = (String)session.getAttribute("username");
        		try {
					ArrayList<SmininfoBean> list1 = GetSmininfoService.getSmininfoService(username);
					ArrayList<ChengyuanBean> list2 = GetChengyuanInfoService.getChengyuanInfoService(username);
					ArrayList<KetangbiaoxianBean> list3 = GetKetangbiaoxianInfoService.getKetangbiaoxianInfoService(username, String.valueOf(id));
					ArrayList<RuxuetestBean> list4 = GetruxuekaoshiService.getruxuekaoshiService(username, id);
					ArrayList<HuodongBean> list5 = GetHuodongInfoService.getHuodongInfoService(username, String.valueOf(id));
					request.setAttribute("sinfo", list1);
					request.setAttribute("chengyuan", list2);
					request.setAttribute("ketang", list3);
					request.setAttribute("ruxue", list4);
					request.setAttribute("huodong", list5);
					if (list1.size()==0||list2.size()==0||list3.size()==0||list4.size()==0||list5.size()==0) {
						request.setAttribute("errors", "请报名课程后再进行查询");
					}
				} catch (Exception e) {

					e.printStackTrace();
				}
				if (id == 1) {
					request.getRequestDispatcher("/Student/Koucaidangan.jsp").forward(request, response);
				}
				if (id == 2) {
					request.getRequestDispatcher("/Student/Bianchengdangan.jsp").forward(request, response);
				}
				if (id == 3) {
					request.getRequestDispatcher("/Student/Jiqirendangan.jsp").forward(request, response);
				}
				if (id == 4) {
					request.getRequestDispatcher("/Student/Qiannengdangan.jsp").forward(request, response);
				}
        }
        else {
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

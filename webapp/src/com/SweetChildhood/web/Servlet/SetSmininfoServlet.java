package com.SweetChildhood.web.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.SweetChildhood.web.Bean.SmininfoBean;
import com.SweetChildhood.web.Service.SetSmininfoService;

/**
 * Servlet implementation class SetSmininfoServlet
 */
@WebServlet("/SetSmininfoServlet")
public class SetSmininfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetSmininfoServlet() {
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
        	int i = 0;
        	String id = request.getParameter("id");
			String sname = request.getParameter("sname");
			String ssex = request.getParameter("ssex");
			String sbirth = request.getParameter("sbirth");
			String sminzu = request.getParameter("sminzu");
			String snianji = request.getParameter("snianji");
			String sjiiguan = request.getParameter("sjiiguan");
			String stechang  = request.getParameter("stechang");
			String saihao = request.getParameter("saihao");
			String slixiang = request.getParameter("slixiang");
			String srongyu = request.getParameter("srongyu");
			String saddress = request.getParameter("saddress");
			String sinfo = request.getParameter("sinfo");
			String sphotopath = request.getParameter("sphotopath");
			ArrayList<SmininfoBean> list = new ArrayList<SmininfoBean>();
			SmininfoBean smininfoBean = new SmininfoBean();
			smininfoBean.setId(id);
			smininfoBean.setSaddress(saddress);
			smininfoBean.setSaihao(saihao);
			smininfoBean.setSbirth(sbirth);
			smininfoBean.setSinfo(sinfo);
			smininfoBean.setSjiiguan(sjiiguan);
			smininfoBean.setSlixiang(slixiang);
			smininfoBean.setSminzu(sminzu);
			smininfoBean.setSname(sname);
			smininfoBean.setSnianji(snianji);
			smininfoBean.setSphotopath(sphotopath);
			smininfoBean.setSrongyu(srongyu);
			smininfoBean.setSsex(ssex);
			smininfoBean.setStechang(stechang);
			list.add(smininfoBean);
			try {
				i = SetSmininfoService.setSmininfoService(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i==0) {
				request.setAttribute("message", "出错啦数据没有任何改变！");
			}
			else {
				request.setAttribute("message", "更改成功！");
			}
			request.getRequestDispatcher("StudentIndex").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

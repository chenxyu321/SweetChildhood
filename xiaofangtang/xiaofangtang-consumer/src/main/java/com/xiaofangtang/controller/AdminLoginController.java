package com.xiaofangtang.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaofangtang.model.Teacher;
import com.xiaofangtang.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

    @Reference
    private TeacherService teacherService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/adminLogin")
    public Object Login(HttpServletRequest request, Model model, @RequestParam(required = false,value="username") String username, @RequestParam(required = false,value="password") String password){
        HttpSession session = request.getSession();
        if (session.getAttribute("user")==null) {
            if (username==null||password==null)
                return "login";
            boolean bo = teacherService.login(username, password);
            if (bo == true) {
                Teacher teacher = teacherService.selectteacherBytname(username);
                model.addAttribute("admin", teacher);
                session.setAttribute("user",teacher);
                int i = teacher.getQuanxian();
                if (i==1)
                    return "views/index";
                if (i==2)
                    return "views/index2";
                if (i==3)
                    return "views/index3";
                if (i==4)
                    return "views/index4";
                if (i==5)
                    return "views/index5";
                return "views/index";
            } else {
                String message = "登录失败，请检查用户名密码是否正确。";
                model.addAttribute("message", message);
                return "error";
            }
        }
        else
        {
            model.addAttribute("admin", session.getAttribute("user"));
            return "views/index";
        }
    }

    @RequestMapping("/Logout")
    public Object Logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "login";
    }

}


package com.xiaofangtang.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaofangtang.model.Teacher;
import com.xiaofangtang.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class JumpController {
    @Reference
    private ActiveService activeService;
    @Reference
    private BumenService bumenService;
    @Reference
    private CansaiService cansaiService;
    @Reference
    private ChengguophotoService chengguophotoService;
    @Reference
    private ChengguoService chengguoService;
    @Reference
    private ChengyuanService chengyuanService;
    @Reference
    private FankuiService fankuiService;
    @Reference
    private HuifangService huifangService;
    @Reference
    private HuodongService huodongService;
    @Reference
    private HuojiangService huojiangService;
    @Reference
    private KetangbiaoxianService ketangbiaoxianService;
    @Reference
    private NewsService newsService;
    @Reference
    private ParentfankuiService parentfankuiService;
    @Reference
    private ParentService parentService;
    @Reference
    private PictureService pictureService;
    @Reference
    private QiandanService qiandanService;
    @Reference
    private ReturnService returnService;
    @Reference
    private RuxuetestService ruxuetestService;
    @Reference
    private ShangkeService shangkeService;
    @Reference
    private SmininfoService smininfoService;
    @Reference
    private SystongzhiService systongzhiService;
    @Reference
    private TeacherService teacherService;
    @Reference
    private YaoyueService yaoyueService;
    @Reference
    private ZuoyeService zuoyeService;

//    @RequestMapping("/toInsertactive")
//    public String toInsertorder(Model model){
//        model.addAttribute("user", userService.getUser());
//        model.addAttribute("author",authorService.getauthor());
//        model.addAttribute("classes",classesService.getclasses());
//        return "views/insert/active";
//    }
    @RequestMapping("/toInsertactive")
    public String toInsertorder(){
        return "views/insert/active";
    }

    @RequestMapping("/toInsertbumen")
    public String toInsertbumen(){
        return "views/insert/bumen";
    }

    @RequestMapping("/toInsertcansai")
    public String toInsertcansai(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        return "views/insert/cansai";
    }

    @RequestMapping("/toInsertchengguo")
    public String toInsertchengguo(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        return "views/insert/chengguo";
    }

    @RequestMapping("/toInsertchengguophoto")
    public String toInsertchengguophoto(Model model){
        model.addAttribute("chengguo",chengguoService.getchengguo());
        return "views/insert/chengguophoto";
    }

    @RequestMapping("/toInsertchengyuan")
    public String toInsertchengyuan(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        return "views/insert/chengyuan";
    }

    @RequestMapping("/toInsertfankui")
    public String toInsertfankui(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        model.addAttribute("teacher",teacherService.getteacher());
        return "views/insert/fankui";
    }

    @RequestMapping("/toInserthuifang")
    public String toInserthuifang(Model model){
        model.addAttribute("yaoyue",yaoyueService.getyaoyue());
        return "views/insert/huifang";
    }

    @RequestMapping("/toInserthuodong")
    public String toInserthuodong(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        model.addAttribute("teacher",teacherService.getteacher());
        return "views/insert/huodong";
    }

    @RequestMapping("/toInserthuojiang")
    public String toInserthuojiang(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        return "views/insert/huojiang";
    }

    @RequestMapping("/toInsertketangbiaoxian")
    public String toInsertketangbiaoxian(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        model.addAttribute("teacher",teacherService.getteacher());
        return "views/insert/ketangbiaoxian";
    }

    @RequestMapping("/toInsertnews")
    public String toInsertnews(){
        return "views/insert/news";
    }

    @RequestMapping("/toInsertparent")
    public String toInsertparent(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        return "views/insert/parent";
    }

    @RequestMapping("/toInsertparentfankui")
    public String toInsertparentfankui(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        return "views/insert/parentfankui";
    }

    @RequestMapping("/toInsertpicture")
    public String toInsertpicture(Model model){
        return "views/insert/picture";
    }

    @RequestMapping("/toInsertqiandan")
    public String toInsertqiandan(Model model){
        model.addAttribute("yaoyue",yaoyueService.getyaoyue());
        model.addAttribute("teacher",teacherService.getteacher());
        return "views/insert/qiandan";
    }

    @RequestMapping("/toInsertreturn")
    public String toInsertreturn(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        return "views/insert/return";
    }

    @RequestMapping("/toInsertruxuetest")
    public String toInsertruxuetest(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        model.addAttribute("teacher",teacherService.getteacher());
        return "views/insert/ruxuetest";
    }

    @RequestMapping("/toInsertshangke")
    public String toInsertshangke(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        model.addAttribute("teacher",teacherService.getteacher());
        return "views/insert/shangke";
    }

    @RequestMapping("/toInsertsmininfo")
    public String toInsertsmininfo(){
        return "views/insert/smininfo";
    }

    @RequestMapping("/toInsertsystongzhi")
    public String toInsertsystongzhi(){
        return "views/insert/systongzhi";
    }

    @RequestMapping("/toInsertteacher")
    public String toInsertteacher(Model model){
        model.addAttribute("bumen",bumenService.getbumen());
        return "views/insert/teacher";
    }

    @RequestMapping("/toInsertyaoyue")
    public String toInsertyaoyue(Model model){
        model.addAttribute("teacher",teacherService.getteacher());
        return "views/insert/yaoyue";
    }

    @RequestMapping("/toInsertzuoye")
    public String toInsertzuoye(Model model){
        model.addAttribute("student",smininfoService.getsmininfo());
        return "views/insert/zuoye";
    }

    @RequestMapping("/toMy")
    public String toMy(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        if (session.getAttribute("user")==null) {
                return "views/index";
        }
        else
        {
            Teacher teacher = (Teacher) session.getAttribute("user");
            model.addAttribute("teacher",teacher);
            model.addAttribute("bumen",bumenService.getbumenByid(teacher.getBumenid()));
            return "views/component/table/my";
        }
    }

    @RequestMapping("/Jumpto")
    public String index(@RequestParam("url") String url){
        url = "views/"+url;
        return url;
    }

}

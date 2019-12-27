package com.xiaofangtang.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaofangtang.model.*;
import com.xiaofangtang.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UpController {

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

    @RequestMapping("/upactive")
    public boolean upactive(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                               @RequestParam(value = "updateValue") String updateValue){
        Active active = activeService.getactiveByid(id);
        if (field.equals("title"))
        active.setTitle(updateValue);
        if (field.equals("text"))
        active.setText(updateValue);
        if (field.equals("address"))
        active.setAddress(updateValue);
        if (field.equals("time"))
        active.setTime(updateValue);
        if (field.equals("open"))
        active.setOpen(Integer.parseInt(updateValue));
        int i = activeService.upactive(active);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upbumen")
    public boolean upbumen(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue){
        Bumen bumen = bumenService.getbumenByid(id);
        if (field.equals("bname"))
            bumen.setBname(updateValue);
        int i = bumenService.upbumen(bumen);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upcansai")
    public boolean upcansai(@RequestParam(value = "id") int id,
                           @RequestParam(value = "field") String field,
                           @RequestParam(value = "updateValue") String updateValue){
        Cansai cansai = cansaiService.getcansaiByid(id);
        if (field.equals("matchname"))
            cansai.setMatchname(updateValue);
        if (field.equals("time"))
            cansai.setTime(updateValue);
        int i = cansaiService.upcansai(cansai);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upchengguo")
    public boolean upchengguo(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue){
        Chengguo chengguo = chengguoService.getchengguoByid(id);
        if (field.equals("text"))
            chengguo.setText(updateValue);
        if (field.equals("time"))
            chengguo.setTime(updateValue);
        int i = chengguoService.upchengguo(chengguo);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upchengguophoto")
    public boolean upchengguophoto(@RequestParam(value = "id") int id,
                              @RequestParam(value = "field") String field,
                              @RequestParam(value = "updateValue") String updateValue){
        Chengguophoto chengguophoto = chengguophotoService.getchengguophotoByid(id);
        if (field.equals("chengguoid"))
            chengguophoto.setChengguoid(updateValue);
        if (field.equals("path"))
            chengguophoto.setPhotopath(updateValue);
        int i = chengguophotoService.upchengguophoto(chengguophoto);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upchengyuan")
    public boolean upchengyuan(@RequestParam(value = "id") int id,
                                   @RequestParam(value = "field") String field,
                                   @RequestParam(value = "updateValue") String updateValue){
        Chengyuan chengyuan = chengyuanService.getchengyuanByid(id);
        if (field.equals("name"))
            chengyuan.setName(updateValue);
        if (field.equals("tel"))
            chengyuan.setTel(updateValue);
        if (field.equals("guanxi"))
            chengyuan.setGuanxi(updateValue);
        if (field.equals("danwei"))
            chengyuan.setDanwei(updateValue);
        int i = chengyuanService.upchengyuan(chengyuan);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upfankui")
    public boolean upfankui(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue){
        Fankui fankui = fankuiService.getfankuiByid(id);
        if (field.equals("title"))
            fankui.setClasses(updateValue);
        if (field.equals("text"))
            fankui.setSid(updateValue);
        if (field.equals("address"))
            fankui.setTeacher(updateValue);
        if (field.equals("time"))
            fankui.setText(updateValue);
        if (field.equals("open"))
            fankui.setTime(updateValue);
        int i = fankuiService.upfankui(fankui);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/uphuifang")
    public boolean uphuifang(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue){
        Huifang huifang = huifangService.gethuifangByid(id);
        if (field.equals("info"))
            huifang.setHuifanginfo(updateValue);
        if (field.equals("teacher"))
            huifang.setHuifangteacher(updateValue);
        if (field.equals("yid"))
            huifang.setYid(updateValue);
        if (field.equals("time"))
            huifang.setHuifangtime(updateValue);
        int i = huifangService.uphuifang(huifang);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/uphuodong")
    public boolean uphuodong(@RequestParam(value = "id") int id,
                             @RequestParam(value = "field") String field,
                             @RequestParam(value = "updateValue") String updateValue){
        Huodong huodong = huodongService.gethuodongByid(id);
        if (field.equals("chengguo"))
            huodong.setChengguo(updateValue);
        if (field.equals("pingjia"))
            huodong.setPingjia(updateValue);
        if (field.equals("shixiang"))
            huodong.setShixiang(updateValue);
        if (field.equals("time"))
            huodong.setTime(updateValue);
        if (field.equals("zid"))
            huodong.setZid(updateValue);
        int i = huodongService.uphuodong(huodong);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/uphuojiang")
    public boolean uphuojiang(@RequestParam(value = "id") int id,
                             @RequestParam(value = "field") String field,
                             @RequestParam(value = "updateValue") String updateValue){
        Huojiang huojiang = huojiangService.gethuojiangByid(id);
        if (field.equals("jiangxiang"))
            huojiang.setJiangxiang(updateValue);
        if (field.equals("matchname"))
            huojiang.setMatchname(updateValue);
        if (field.equals("time"))
            huojiang.setTime(updateValue);
        int i = huojiangService.uphuojiang(huojiang);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upketangbiaoxian")
    public boolean upketangbiaoxian(@RequestParam(value = "id") int id,
                              @RequestParam(value = "field") String field,
                              @RequestParam(value = "updateValue") String updateValue){
        Ketangbiaoxian ketangbiaoxian = ketangbiaoxianService.getketangbiaoxianByid(id);
        if (field.equals("biaoxian"))
            ketangbiaoxian.setBiaoxian(updateValue);
        if (field.equals("jihua"))
            ketangbiaoxian.setJihua(updateValue);
        if (field.equals("jilv"))
            ketangbiaoxian.setJilv(updateValue);
        if (field.equals("text1"))
            ketangbiaoxian.setText1(updateValue);
        if (field.equals("text2"))
            ketangbiaoxian.setText2(updateValue);
        if (field.equals("text3"))
            ketangbiaoxian.setText3(updateValue);
        if (field.equals("zid"))
            ketangbiaoxian.setZid(updateValue);
        if (field.equals("zhanxiannum"))
            ketangbiaoxian.setZhanxiannum(updateValue);
        if (field.equals("time"))
            ketangbiaoxian.setTime(updateValue);
        int i = ketangbiaoxianService.upketangbiaoxian(ketangbiaoxian);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upnews")
    public boolean upnews(@RequestParam(value = "id") int id,
                                    @RequestParam(value = "field") String field,
                                    @RequestParam(value = "updateValue") String updateValue){
        News news = newsService.getnewsByid(id);
        if (field.equals("mintext"))
            news.setMintext(updateValue);
        if (field.equals("people"))
            news.setPeople(updateValue);
        if (field.equals("picpath"))
            news.setPicpath(updateValue);
        if (field.equals("text"))
            news.setText(updateValue);
        if (field.equals("title"))
            news.setTitle(updateValue);
        if (field.equals("time"))
            news.setTime(updateValue);
        int i = newsService.upnews(news);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upparent")
    public boolean upparent(@RequestParam(value = "id") int id,
                          @RequestParam(value = "field") String field,
                          @RequestParam(value = "updateValue") String updateValue){
        Parent parent = parentService.getparentByid(id);
        if (field.equals("id"))
            parent.setId(updateValue);
        if (field.equals("pass"))
            parent.setPass(updateValue);
        if (field.equals("active"))
            parent.setActive(Integer.parseInt(updateValue));
        int i = parentService.upparent(parent);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upparentfankui")
    public boolean upparentfankui(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue){
        Parentfankui parentfankui = parentfankuiService.getparentfankuiByid(id);
        if (field.equals("text"))
            parentfankui.setText(updateValue);
        if (field.equals("time"))
            parentfankui.setTime(updateValue);
        int i = parentfankuiService.upparentfankui(parentfankui);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/uppicture")
    public boolean uppicture(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "field") String field,
                                  @RequestParam(value = "updateValue") String updateValue){
        Picture picture = pictureService.getpictureByid(id);
        if (field.equals("path"))
            picture.setPicpath(updateValue);
        if (field.equals("text"))
            picture.setPictext(updateValue);
        int i = pictureService.uppicture(picture);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upqiandan")
    public boolean upqiandan(@RequestParam(value = "id") int id,
                             @RequestParam(value = "field") String field,
                             @RequestParam(value = "updateValue") String updateValue){
        Qiandan qiandan = qiandanService.getqiandanByid(id);
        if (field.equals("info"))
            qiandan.setInfo(updateValue);
        if (field.equals("price"))
            qiandan.setPrice(updateValue);
        if (field.equals("yid"))
            qiandan.setYid(updateValue);
        if (field.equals("time"))
            qiandan.setTime(updateValue);
        int i = qiandanService.upqiandan(qiandan);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upreturn")
    public boolean upreturn(@RequestParam(value = "id") int id,
                             @RequestParam(value = "field") String field,
                             @RequestParam(value = "updateValue") String updateValue){
        Return returnn = returnService.getreturnByid(id);
        if (field.equals("text"))
            returnn.setText(updateValue);
        int i = returnService.upreturn(returnn);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upruxuetest")
    public boolean upruxuetest(@RequestParam(value = "id") int id,
                            @RequestParam(value = "field") String field,
                            @RequestParam(value = "updateValue") String updateValue){
        Ruxuetest ruxuetest = ruxuetestService.getruxuetestByid(id);
        if (field.equals("age"))
            ruxuetest.setAge(updateValue);
        if (field.equals("beizhu"))
            ruxuetest.setBeizhu(updateValue);
        if (field.equals("guihua"))
            ruxuetest.setGuihua(updateValue);
        if (field.equals("score"))
            ruxuetest.setScore(updateValue);
        if (field.equals("text1"))
            ruxuetest.setText1(updateValue);
        if (field.equals("text2"))
            ruxuetest.setText2(updateValue);
        if (field.equals("text3"))
            ruxuetest.setText3(updateValue);
        if (field.equals("text4"))
            ruxuetest.setText4(updateValue);
        if (field.equals("text5"))
            ruxuetest.setText5(updateValue);
        if (field.equals("time"))
            ruxuetest.setTime(updateValue);
        int i = ruxuetestService.upruxuetest(ruxuetest);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upshangke")
    public boolean upshangke(@RequestParam(value = "id") int id,
                               @RequestParam(value = "field") String field,
                               @RequestParam(value = "updateValue") String updateValue){
        Shangke shangke = shangkeService.getshangkeByid(id);
        if (field.equals("time"))
            shangke.setTime(updateValue);
        int i = shangkeService.upshangke(shangke);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upsmininfo")
    public boolean upsmininfo(@RequestParam(value = "id") int id,
                             @RequestParam(value = "field") String field,
                             @RequestParam(value = "updateValue") String updateValue){
        Smininfo smininfo = smininfoService.getsmininfoByid(id);
        if (field.equals("address"))
            smininfo.setSaddress(updateValue);
        if (field.equals("aihao"))
            smininfo.setSaihao(updateValue);
        if (field.equals("birth"))
            smininfo.setSbirth(updateValue);
        if (field.equals("info"))
            smininfo.setSinfo(updateValue);
        if (field.equals("jiguan"))
            smininfo.setSjiguan(updateValue);
        if (field.equals("lixiang"))
            smininfo.setSlixiang(updateValue);
        if (field.equals("minzu"))
            smininfo.setSminzu(updateValue);
        if (field.equals("name"))
            smininfo.setSname(updateValue);
        if (field.equals("nianji"))
            smininfo.setSnianji(updateValue);
        if (field.equals("photopath"))
            smininfo.setSphotopath(updateValue);
        if (field.equals("rongyu"))
            smininfo.setSrongyu(updateValue);
        if (field.equals("sex"))
            smininfo.setSsex(updateValue);
        if (field.equals("techang"))
            smininfo.setStechang(updateValue);
        int i = smininfoService.upsmininfo(smininfo);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upsystongzhi")
    public boolean upsystongzhi(@RequestParam(value = "id") int id,
                              @RequestParam(value = "field") String field,
                              @RequestParam(value = "updateValue") String updateValue){
        Systongzhi systongzhi = systongzhiService.getsystongzhiByid(id);
        if (field.equals("text"))
            systongzhi.setText(updateValue);
        if (field.equals("time"))
            systongzhi.setTime(updateValue);
        if (field.equals("active"))
            systongzhi.setActive(Integer.parseInt(updateValue));

        int i = systongzhiService.upsystongzhi(systongzhi);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upteacher")
    public boolean upteacher(@RequestParam(value = "id") int id,
                                @RequestParam(value = "field") String field,
                                @RequestParam(value = "updateValue") String updateValue){
        Teacher teacher = teacherService.getteacherByid(id);
        if (field.equals("birth"))
            teacher.setBirth(updateValue);
        if (field.equals("password"))
            teacher.setPassword(updateValue);
        if (field.equals("nickname"))
            teacher.setNickname(updateValue);
        if (field.equals("quanxian"))
            teacher.setQuanxian(Integer.parseInt(updateValue));
        if (field.equals("ruzhitime"))
            teacher.setRuzhitime(updateValue);
        if (field.equals("tname"))
            teacher.setTname(updateValue);
        int i = teacherService.upteacher(teacher);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upyaoyue")
    public boolean upyaoyue(@RequestParam(value = "id") int id,
                             @RequestParam(value = "field") String field,
                             @RequestParam(value = "updateValue") String updateValue){
        Yaoyue yaoyue = yaoyueService.getyaoyueByid(id);
        if (field.equals("daofang"))
            yaoyue.setDaofang(updateValue);
        if (field.equals("info"))
            yaoyue.setInfo(updateValue);
        if (field.equals("iswx"))
            yaoyue.setIswx(updateValue);
        if (field.equals("time"))
            yaoyue.setTime(updateValue);
        if (field.equals("age"))
            yaoyue.setSage(updateValue);
        if (field.equals("name"))
            yaoyue.setTname(updateValue);
        if (field.equals("sex"))
            yaoyue.setSsex(updateValue);
        if (field.equals("tel"))
            yaoyue.setTel(updateValue);
        if (field.equals("othername"))
            yaoyue.setOthername(updateValue);
        int i = yaoyueService.upyaoyue(yaoyue);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upzuoye")
    public boolean upzuoye(@RequestParam(value = "id") int id,
                           @RequestParam(value = "field") String field,
                           @RequestParam(value = "updateValue") String updateValue){
        Zuoye zuoye = zuoyeService.getzuoyeByid(id);
        if (field.equals("text"))
            zuoye.setText(updateValue);
        if (field.equals("time"))
            zuoye.setTime(updateValue);
        int i = zuoyeService.upzuoye(zuoye);
        if (i!=0)
            return true;
        else
            return false;
    }

    @RequestMapping("/upadmininfo")
    public boolean upadmininfo(@RequestParam(value = "tname") String tname,
                           @RequestParam(value = "birth") String birth,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "nickname") String nickname){
        Teacher teacher = teacherService.selectteacherBytname(tname);
            teacher.setBirth(birth);
            teacher.setPassword(password);
            teacher.setNickname(nickname);
        int i = teacherService.upteacher(teacher);
        if (i!=0)
            return true;
        else
            return false;
    }
}

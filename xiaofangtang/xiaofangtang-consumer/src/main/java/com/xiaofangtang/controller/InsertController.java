package com.xiaofangtang.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaofangtang.model.*;
import com.xiaofangtang.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


@RestController
public class InsertController {

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

    @RequestMapping("/InsertActive")
    public String InsertUser(@RequestParam(value = "title") String title,
                             @RequestParam(value = "text") String text,
                             @RequestParam(value="address") String address,
                             @RequestParam(value = "time") String time,
                             @RequestParam(value = "open") int open){
        int i = 0;
        Calendar calendar= Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy年 MM月 dd日 HH:mm:ss");
        Active active = new Active();
//        active.setRegisttime(dateFormat.format(calendar.getTime()));
        active.setTitle(title);
        active.setText(text);
        active.setAddress(address);
        active.setTime(time);
        active.setOpen(open);
        i = activeService.insertactive(active);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertBumen")
    public String InsertBumen(@RequestParam(value = "bname") String bname){
        int i = 0;
        Bumen bumen = new Bumen();
        bumen.setBname(bname);
        i = bumenService.insertbumen(bumen);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertCansai")
    public String InsertCansai(@RequestParam(value = "matchname") String matchname,
                               @RequestParam(value = "sid") String sid,
                               @RequestParam(value = "time") String time){
        int i = 0;
        Cansai cansai = new Cansai();
        cansai.setTime(time);
        cansai.setMatchname(matchname);
        cansai.setSid(sid);
        i = cansaiService.insertcansai(cansai);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertChengguo")
    public String InsertChengguo(@RequestParam(value = "text") String text,
                               @RequestParam(value = "sid") String sid,
                               @RequestParam(value = "time") String time){
        int i = 0;
        Chengguo chengguo = new Chengguo();
        chengguo.setTime(time);
        chengguo.setText(text);
        chengguo.setSid(sid);
        i = chengguoService.insertchengguo(chengguo);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertChengguophoto")
    public String InsertChengguophoto(@RequestParam(value = "chengguoid") String id,
                                 @RequestParam(value = "path") String path){
        int i = 0;
        Chengguophoto chengguophoto = new Chengguophoto();
        chengguophoto.setChengguoid(id);
        chengguophoto.setPhotopath(path);
        i = chengguophotoService.insertchengguophoto(chengguophoto);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertChengyuan")
    public String InsertChengyuan(@RequestParam(value = "name") String name,
                                      @RequestParam(value = "tel") String tel,
                                  @RequestParam(value = "danwei") String danwei,
                                  @RequestParam(value = "guanxi") String guanxi,
                                  @RequestParam(value = "sid") String sid){
        int i = 0;
        Chengyuan chengyuan = new Chengyuan();
        chengyuan.setName(name);
        chengyuan.setDanwei(danwei);
        chengyuan.setGuanxi(guanxi);
        chengyuan.setTel(tel);
        chengyuan.setSid(sid);
        i = chengyuanService.insertchengyuan(chengyuan);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertFankui")
    public String InsertFankui(@RequestParam(value = "teacher") String teacher,
                                  @RequestParam(value = "text") String text,
                                  @RequestParam(value = "time") String time,
                                  @RequestParam(value = "classes") String classes,
                                  @RequestParam(value = "sid") String sid){
        int i = 0;
        Fankui fankui = new Fankui();
        fankui.setTeacher(teacher);
        fankui.setTime(time);
        fankui.setText(text);
        fankui.setSid(sid);
        fankui.setClasses(classes);
        i = fankuiService.insertfankui(fankui);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertHuifang")
    public String InsertHuifang(@RequestParam(value = "info") String info,
                               @RequestParam(value = "teacher") String teacher,
                               @RequestParam(value = "time") String time,
                               @RequestParam(value = "yid") String yid){
        int i = 0;
        Huifang huifang = new Huifang();
        huifang.setHuifangtime(time);
        huifang.setHuifangteacher(teacher);
        huifang.setHuifanginfo(info);
        huifang.setYid(yid);
        i = huifangService.inserthuifang(huifang);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertHuodong")
    public String InsertHuodong(@RequestParam(value = "sid") String sid,
                                @RequestParam(value = "cid") String cid,
                                @RequestParam(value = "zid") String zid,
                                @RequestParam(value = "time") String time,
                                @RequestParam(value = "teacher") String teacher,
                                @RequestParam(value = "shixiang") String shixiang,
                                @RequestParam(value = "chengguo") String chengguo,
                                @RequestParam(value = "pingjia") String pingjia){
        int i = 0;
        Huodong huodong = new Huodong();
        huodong.setSid(sid);
        huodong.setCid(cid);
        huodong.setZid(zid);
        huodong.setTime(time);
        huodong.setTeacher(teacher);
        huodong.setShixiang(shixiang);
        huodong.setChengguo(chengguo);
        huodong.setPingjia(pingjia);
        i = huodongService.inserthuodong(huodong);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertHuojiang")
    public String InsertHuojiang(@RequestParam(value = "sid") String sid,
                                @RequestParam(value = "cid") String cid,
                                @RequestParam(value = "time") String time,
                                @RequestParam(value = "jiangxiang") String jiangxiang,
                                @RequestParam(value = "matchname") String matchname){
        int i = 0;
        Huojiang huojiang = new Huojiang();
        huojiang.setSid(sid);
        huojiang.setClasses(cid);
        huojiang.setJiangxiang(jiangxiang);
        huojiang.setTime(time);
        huojiang.setMatchname(matchname);
        i = huojiangService.inserthuojiang(huojiang);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertKetangbiaoxian")
    public String Insertketangbiaoxian(@RequestParam(value = "sid") String sid,
                                 @RequestParam(value = "cid") String cid,
                                 @RequestParam(value = "zid") String zid,
                                 @RequestParam(value = "tid") String tid,
                                 @RequestParam(value = "time") String time,
                                 @RequestParam(value = "jilv") String jilv,
                                 @RequestParam(value = "zhanxiannum") String zhanxiannum,
                                 @RequestParam(value = "biaoxian") String biaoxian,
                                 @RequestParam(value = "text1") String text1,
                                 @RequestParam(value = "text2") String text2,
                                 @RequestParam(value = "text3") String text3,
                                 @RequestParam(value = "jihua") String jihua){
        int i = 0;
        Ketangbiaoxian ketangbiaoxian = new Ketangbiaoxian();
        ketangbiaoxian.setSid(sid);
        ketangbiaoxian.setCid(cid);
        ketangbiaoxian.setZid(zid);
        ketangbiaoxian.setTeacher(tid);
        ketangbiaoxian.setTime(time);
        ketangbiaoxian.setJilv(jilv);
        ketangbiaoxian.setZhanxiannum(zhanxiannum);
        ketangbiaoxian.setBiaoxian(biaoxian);
        ketangbiaoxian.setText1(text1);
        ketangbiaoxian.setText2(text2);
        ketangbiaoxian.setText3(text3);
        ketangbiaoxian.setJihua(jihua);
        i = ketangbiaoxianService.insertketangbiaoxian(ketangbiaoxian);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertNews")
    public String InsertNews(@RequestParam(value = "text") String text,
                                       @RequestParam(value = "people") String people,
                                       @RequestParam(value = "title") String title,
                                       @RequestParam(value = "picpath") String picpath,
                                       @RequestParam(value = "mintext") String mintext,
                                       @RequestParam(value = "time") String time){
        int i = 0;
        News news = new News();
        news.setTime(time);
        news.setTitle(title);
        news.setText(text);
        news.setPicpath(picpath);
        news.setPeople(people);
        news.setMintext(mintext);
        i = newsService.insertnews(news);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertParent")
    public String InsertParent(@RequestParam(value = "sid") String sid,
                             @RequestParam(value = "active") int active){
        int i = 0;
        Parent parent = new Parent();
        parent.setId(sid);
        parent.setActive(active);
        i = parentService.insertparent(parent);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertParentfankui")
    public String InsertParentfankui(@RequestParam(value = "sid") int sid,
                               @RequestParam(value = "text") String text,
                               @RequestParam(value = "time") String time){
        int i = 0;
        Parentfankui parentfankui = new Parentfankui();
        parentfankui.setId(sid);
        parentfankui.setText(text);
        parentfankui.setTime(time);
        i = parentfankuiService.insertparentfankui(parentfankui);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertPicture")
    public String InsertPicture( @RequestParam(value = "text") String text,
                                 @RequestParam(value = "path") String path){
        int i = 0;
        Picture picture = new Picture();
        picture.setPictext(text);
        picture.setPicpath(path);
        i = pictureService.insertpicture(picture);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertQiandan")
    public String Insertqiandan( @RequestParam(value = "yid") String yid,
                                 @RequestParam(value = "classes") String classes,
                                 @RequestParam(value = "price") String price,
                                 @RequestParam(value = "time") String time,
                                 @RequestParam(value = "teacher") String teacher,
                                 @RequestParam(value = "classteacher") String classteacher,
                                 @RequestParam(value = "info") String info){
        int i = 0;
        Qiandan qiandan = new Qiandan();
        qiandan.setYid(yid);
        qiandan.setClasses(classes);
        qiandan.setPrice(price);
        qiandan.setTime(time);
        qiandan.setTeacher(teacher);
        qiandan.setClassteacher(classteacher);
        qiandan.setInfo(info);
        i = qiandanService.insertqiandan(qiandan);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertReturn")
    public String Insertreturn( @RequestParam(value = "cid") String cid,
                                 @RequestParam(value = "sid") String sid,
                                 @RequestParam(value = "text") String text){
        int i = 0;
        Return returnn = new Return();
        returnn.setClasses(cid);
        returnn.setText(text);
        returnn.setPeople(sid);
        i = returnService.insertreturn(returnn);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertRuxuetest")
    public String InsertRuxuetest( @RequestParam(value = "cid") String cid,
                                @RequestParam(value = "sid") String sid,
                                @RequestParam(value = "tid") String tid,
                                   @RequestParam(value = "text1") String text1,
                                   @RequestParam(value = "text2") String text2,
                                   @RequestParam(value = "text3") String text3,
                                   @RequestParam(value = "text4") String text4,
                                   @RequestParam(value = "text5") String text5,
                                   @RequestParam(value = "age") String age,
                                   @RequestParam(value = "score") String score,
                                   @RequestParam(value = "guihua") String guihua,
                                   @RequestParam(value = "beizhu") String beizhu,
                                   @RequestParam(value = "time") String time){
        int i = 0;
        Ruxuetest ruxuetest = new Ruxuetest();
        ruxuetest.setCid(cid);
        ruxuetest.setSid(sid);
        ruxuetest.setAge(age);
        ruxuetest.setBeizhu(beizhu);
        ruxuetest.setGuihua(guihua);
        ruxuetest.setScore(score);
        ruxuetest.setTeacher(tid);
        ruxuetest.setText1(text1);
        ruxuetest.setText2(text2);
        ruxuetest.setText3(text3);
        ruxuetest.setText4(text4);
        ruxuetest.setText5(text5);
        ruxuetest.setTime(time);
        i = ruxuetestService.insertruxuetest(ruxuetest);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertShangke")
    public String InsertShangke( @RequestParam(value = "cid") String cid,
                                   @RequestParam(value = "sid") String sid,
                                   @RequestParam(value = "tid") String tid,
                                   @RequestParam(value = "time") String time){
        int i = 0;
        Shangke shangke = new Shangke();
        shangke.setClasses(cid);
        shangke.setSid(sid);
        shangke.setTeacher(tid);
        shangke.setTime(time);
        i = shangkeService.insertshangke(shangke);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertSmininfo")
    public String InsertSmininfo( @RequestParam(value = "id") String id,
                                   @RequestParam(value = "address") String address,
                                   @RequestParam(value = "aihao") String aihao,
                                   @RequestParam(value = "birth") String birth,
                                   @RequestParam(value = "info") String info,
                                   @RequestParam(value = "jiguan") String jiguan,
                                   @RequestParam(value = "lixiang") String lixiang,
                                   @RequestParam(value = "minzu") String minzu,
                                   @RequestParam(value = "name") String name,
                                   @RequestParam(value = "nianji") String nianji,
                                   @RequestParam(value = "photopath") String photopath,
                                   @RequestParam(value = "techang") String techang,
                                   @RequestParam(value = "rongyu") String rongyu,
                                   @RequestParam(value = "sex") String sex){
        int i = 0;
        Smininfo smininfo = new Smininfo();
        smininfo.setStechang(techang);
        smininfo.setSsex(sex);
        smininfo.setSrongyu(rongyu);
        smininfo.setSphotopath(photopath);
        smininfo.setSnianji(nianji);
        smininfo.setSname(name);
        smininfo.setSminzu(minzu);
        smininfo.setSlixiang(lixiang);
        smininfo.setSjiguan(jiguan);
        smininfo.setSinfo(info);
        smininfo.setSbirth(birth);
        smininfo.setSaihao(aihao);
        smininfo.setSaddress(address);
        smininfo.setId(id);
        i = smininfoService.insertsmininfo(smininfo);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertSystongzhi")
    public String InsertSystongzhi(@RequestParam(value = "text") String text,
                                  @RequestParam(value = "time") String time,
                                  @RequestParam(value = "active") int active){
        int i = 0;
        Systongzhi systongzhi = new Systongzhi();
        systongzhi.setText(text);
        systongzhi.setTime(time);
        systongzhi.setActive(active);
        i = systongzhiService.insertsystongzhi(systongzhi);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertTeacher")
    public String InsertTeacher(@RequestParam(value = "birth") String birth,
                                @RequestParam(value = "bumenid") int bumenid,
                                @RequestParam(value = "nickname") String nickname,
                                @RequestParam(value = "password") String password,
                                @RequestParam(value = "quanxian") int quanxian,
                                @RequestParam(value = "ruzhitime") String ruzhitime,
                                @RequestParam(value = "tname") String tname){
        int i = 0;
        Teacher teacher = new Teacher();
        teacher.setQuanxian(quanxian);
        teacher.setRuzhitime(ruzhitime);
        teacher.setTname(tname);
        teacher.setNickname(nickname);
        teacher.setPassword(password);
        teacher.setBumenid(bumenid);
        teacher.setBirth(birth);
        i = teacherService.insertteacher(teacher);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertYaoyue")
    public String InsertYaoyue(@RequestParam(value = "sname") String sname,
                                @RequestParam(value = "sage") String sage,
                                @RequestParam(value = "tel") String tel,
                                @RequestParam(value = "classes") String classes,
                                @RequestParam(value = "ssex") String ssex,
                                @RequestParam(value = "iswx") String iswx,
                                @RequestParam(value = "time") String time,
                                @RequestParam(value = "info") String info,
                                @RequestParam(value = "daofang") String daofang,
                                @RequestParam(value = "tname") String tname,
                                @RequestParam(value = "othername") String othername){
        int i = 0;
        Yaoyue yaoyue = new Yaoyue();
        yaoyue.setSname(sname);
        yaoyue.setSage(sage);
        yaoyue.setTel(tel);
        yaoyue.setClasses(classes);
        yaoyue.setSsex(ssex);
        yaoyue.setIswx(iswx);
        yaoyue.setTime(time);
        yaoyue.setInfo(info);
        yaoyue.setDaofang(daofang);
        yaoyue.setTname(tname);
        yaoyue.setOthername(othername);
        i = yaoyueService.insertyaoyue(yaoyue);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }

    @RequestMapping("/InsertZuoye")
    public String InsertZuoye(@RequestParam(value = "sid") String sid,
                               @RequestParam(value = "cid") String cid,
                               @RequestParam(value = "time") String time,
                               @RequestParam(value = "text") String text){
        int i = 0;
        Zuoye zuoye = new Zuoye();
        zuoye.setTime(time);
        zuoye.setText(text);
        zuoye.setClasses(cid);
        zuoye.setSid(sid);
        i = zuoyeService.insertzuoye(zuoye);
        if (i!=0)
            return "添加成功请关闭窗口";
        return "添加失败请联系管理员";
    }
}

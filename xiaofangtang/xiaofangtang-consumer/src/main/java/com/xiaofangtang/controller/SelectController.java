package com.xiaofangtang.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaofangtang.model.*;
import com.xiaofangtang.service.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SelectController {

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

    @RequestMapping("/selectactive")
    public Map<String,Object> selectactive(){
        List<Active> actives = activeService.getactive();
        List<Map<String,Object>> list = new ArrayList<>();
        if (actives!=null)
        for(Active active:actives){
            int id = active.getId();
            String title = active.getTitle();
            String text = active.getText();
            String address= active.getAddress();
            String time = active.getTime();
            int open = active.getOpen();
            Map map = new HashMap();
            map.put("id",id);
            map.put("title",title);
            map.put("text",text);
            map.put("address",address);
            map.put("time",time);
            map.put("open",open);
            list.add(map);
        }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }
    @RequestMapping("/selectactiveByopen")
    public List<Active> selectactiveByopen(Model model){
        model.addAttribute("active",activeService.getactiveByopen());
        return activeService.getactiveByopen();
    }

    @RequestMapping("/selectbumen")
    public Map<String,Object> selectbumen(){
        List<Bumen> bumens = bumenService.getbumen();
        List<Map<String,Object>> list = new ArrayList<>();
        if (bumens!=null)
            for(Bumen bumen:bumens){
                int id = bumen.getId();
                String bname = bumen.getBname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("bname",bname);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectcansai")
    public Map<String,Object> selectcansai(){
        List<Cansai> cansais = cansaiService.getcansai();
        List<Map<String,Object>> list = new ArrayList<>();
        if (cansais!=null)
            for(Cansai cansai:cansais){
                int id = cansai.getId();
                String matchname = cansai.getMatchname();
                String sid = cansai.getSid();
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(sid)).getSname();
                String time = cansai.getTime();
                Map map = new HashMap();
                map.put("id",id);
                map.put("matchname",matchname);
                map.put("sname",sname);
                map.put("time",time);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectchengguo")
    public Map<String,Object> selectchengguo(){
        List<Chengguo> chengguos = chengguoService.getchengguo();
        List<Map<String,Object>> list = new ArrayList<>();
        if (chengguos!=null)
            for(Chengguo chengguo:chengguos){
                int id = chengguo.getId();
                String sid = chengguo.getSid();
                String text = chengguo.getText();
                String time = chengguo.getTime();
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(sid)).getSname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("text",text);
                map.put("sname",sname);
                map.put("time",time);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectchengguophoto")
    public Map<String,Object> selectchengguophoto(){
        List<Chengguophoto> chengguophotos = chengguophotoService.getchengguophoto();
        List<Map<String,Object>> list = new ArrayList<>();
        if (chengguophotos!=null)
            for(Chengguophoto chengguophoto:chengguophotos){
                int id = chengguophoto.getId();
                String chengguoid = chengguophoto.getChengguoid();
                String path = chengguophoto.getPhotopath();
                String chengguotext = chengguoService.getchengguoByid(Integer.parseInt(chengguoid)).getText();
                Map map = new HashMap();
                map.put("id",id);
                map.put("chengguoid",chengguoid);
                map.put("chengguotext",chengguotext);
                map.put("path",path);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectchengyuan")
    public Map<String,Object> selectchengyuan(){
        List<Chengyuan> chengyuans = chengyuanService.getchengyuan();
        List<Map<String,Object>> list = new ArrayList<>();
        if (chengyuans!=null)
            for(Chengyuan chengyuan:chengyuans){
                int id = chengyuan.getId();
                String danwei = chengyuan.getDanwei();
                String guanxi = chengyuan.getGuanxi();
                String name = chengyuan.getName();
                String sid = chengyuan.getSid();
                String tel = chengyuan.getTel();
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(sid)).getSname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("danwei",danwei);
                map.put("guanxi",guanxi);
                map.put("name",name);
                map.put("tel",tel);
                map.put("sname",sname);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectfankui")
    public Map<String,Object> selectfankui(){
        List<Fankui> fankuis = fankuiService.getfankui();
        List<Map<String,Object>> list = new ArrayList<>();
        if (fankuis!=null)
            for(Fankui fankui:fankuis){
                int id = fankui.getId();
                String classes = fankui.getClasses();
                String sid = fankui.getSid();
                String teacher = fankui.getTeacher();
                String text = fankui.getText();
                String time = fankui.getTime();
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(sid)).getSname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("classes",classes);
                map.put("teacher",teacher);
                map.put("text",text);
                map.put("time",time);
                map.put("sname",sname);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selecthuifang")
    public Map<String,Object> selecthuifang(){
        List<Huifang> huifangs = huifangService.gethuifang();
        List<Map<String,Object>> list = new ArrayList<>();
        if (huifangs!=null)
            for(Huifang huifang:huifangs){
                int id = huifang.getId();
                String info = huifang.getHuifanginfo();
                String teacher = huifang.getHuifangteacher();
                String time = huifang.getHuifangtime();
                String yid  = huifang.getYid();
                String sname = yaoyueService.getyaoyueByid(Integer.parseInt(yid)).getSname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("info",info);
                map.put("teacher",teacher);
                map.put("yid",yid);
                map.put("time",time);
                map.put("sname",sname);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selecthuodong")
    public Map<String,Object> selecthuodong(){
        List<Huodong> huodongs = huodongService.gethuodong();
        List<Map<String,Object>> list = new ArrayList<>();
        if (huodongs!=null)
            for(Huodong huodong:huodongs){
                int id = huodong.getId();
                String chengguo = huodong.getChengguo();
                int cid = Integer.parseInt(huodong.getCid());
                String pingjia = huodong.getPingjia();
                String shixiang = huodong.getShixiang();
                String sid = huodong.getSid();
                String teacher = huodong.getTeacher();
                String time = huodong.getTime();
                String zid = huodong.getZid();
                String cname = "出错了！";
                if (cid==1)
                    cname = "口才主持";
                if (cid==2)
                    cname = "少儿编程";
                if (cid==3)
                    cname = "机器人编程";
                if (cid==4)
                    cname = "潜能开发";
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(sid)).getSname();
                String tname = teacherService.getteacherByid(Integer.parseInt(teacher)).getTname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("chengguo",chengguo);
                map.put("cname",cname);
                map.put("pingjia",pingjia);
                map.put("shixiang",shixiang);
                map.put("sname",sname);
                map.put("time",time);
                map.put("zid",zid);
                map.put("tname",tname);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selecthuojiang")
    public Map<String,Object> selecthuojiang(){
        List<Huojiang> huojiangs = huojiangService.gethuojiang();
        List<Map<String,Object>> list = new ArrayList<>();
        if (huojiangs!=null)
            for(Huojiang huojiang:huojiangs){
                int id = huojiang.getId();
                int cid = Integer.parseInt(huojiang.getClasses());
                String jiangxiang = huojiang.getJiangxiang();
                String matchname = huojiang.getMatchname();
                String sid = huojiang.getSid();
                String time = huojiang.getTime();
                String cname = "出错了！";
                if (cid==1)
                    cname = "口才主持";
                if (cid==2)
                    cname = "少儿编程";
                if (cid==3)
                    cname = "机器人编程";
                if (cid==4)
                    cname = "潜能开发";
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(sid)).getSname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("jiangxiang",jiangxiang);
                map.put("sname",sname);
                map.put("cname",cname);
                map.put("matchname",matchname);
                map.put("time",time);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectketangbiaoxian")
    public Map<String,Object> selectketangbiaoxian(){
        List<Ketangbiaoxian> ketangbiaoxians = ketangbiaoxianService.getketangbiaoxian();
        List<Map<String,Object>> list = new ArrayList<>();
        if (ketangbiaoxians!=null)
            for(Ketangbiaoxian ketangbiaoxian:ketangbiaoxians){
                int id = ketangbiaoxian.getId();
                String biaoxian = ketangbiaoxian.getBiaoxian();
                int cid = Integer.parseInt(ketangbiaoxian.getCid());
                String jihua = ketangbiaoxian.getJihua();
                String jilv = ketangbiaoxian.getJilv();
                String sid = ketangbiaoxian.getSid();
                String teacher = ketangbiaoxian.getTeacher();
                String text1 = ketangbiaoxian.getText1();
                String text2 = ketangbiaoxian.getText2();
                String text3 = ketangbiaoxian.getText3();
                String time = ketangbiaoxian.getTime();
                String zid = ketangbiaoxian.getZid();
                String zhanxiannum = ketangbiaoxian.getZhanxiannum();
                String cname = "出错了！";
                if (cid==1)
                    cname = "口才主持";
                if (cid==2)
                    cname = "少儿编程";
                if (cid==3)
                    cname = "机器人编程";
                if (cid==4)
                    cname = "潜能开发";
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(sid)).getSname();
                String tname = teacherService.getteacherByid(Integer.parseInt(teacher)).getNickname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("biaoxian",biaoxian);
                map.put("jihua",jihua);
                map.put("jilv",jilv);
                map.put("cname",cname);
                map.put("sname",sname);
                map.put("tname",tname);
                map.put("text1",text1);
                map.put("text2",text2);
                map.put("text3",text3);
                map.put("zid",zid);
                map.put("zhanxiannum",zhanxiannum);
                map.put("time",time);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectnews")
    public Map<String,Object> selectnews(){
        List<News> newss = newsService.getnews();
        List<Map<String,Object>> list = new ArrayList<>();
        if (newss!=null)
            for(News news:newss){
                int id = news.getId();
                String mintext = news.getMintext();
                String people = news.getPeople();
                String picpath = news.getPicpath();
                String text = news.getText();
                String time = news.getTime();
                String title = news.getTitle();

                Map map = new HashMap();
                map.put("id",id);
                map.put("mintext",mintext);
                map.put("people",people);
                map.put("picpath",picpath);
                map.put("text",text);
                map.put("title",title);
                map.put("time",time);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectparent")
    public Map<String,Object> selectparent(){
        List<Parent> parents = parentService.getparent();
        List<Map<String,Object>> list = new ArrayList<>();
        if (parents!=null)
            for(Parent parent:parents){
                String id = parent.getId();
                int active = parent.getActive();
                String pass = parent.getPass();

                Map map = new HashMap();
                map.put("id",id);
                map.put("active",active);
                map.put("pass",pass);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectparentfankui")
    public Map<String,Object> selectparentfankui(){
        List<Parentfankui> parentfankuis = parentfankuiService.getparentfankui();
        List<Map<String,Object>> list = new ArrayList<>();
        if (parentfankuis!=null)
            for(Parentfankui parentfankui:parentfankuis){
                int id = parentfankui.getId();
                String text = parentfankui.getText();
                String time = parentfankui.getTime();
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(parentfankui.getSid())).getSname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("sname",sname);
                map.put("text",text);
                map.put("time",time);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectpicture")
    public Map<String,Object> selectpicture(){
        List<Picture> pictures = pictureService.getpicture();
        List<Map<String,Object>> list = new ArrayList<>();
        if (pictures!=null)
            for(Picture picture:pictures){
                int id = picture.getPicid();
                String path = picture.getPicpath();
                String text = picture.getPictext();
                Map map = new HashMap();
                map.put("id",id);
                map.put("path",path);
                map.put("text",text);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectqiandan")
    public Map<String,Object> selectqiandan(){
        List<Qiandan> qiandans = qiandanService.getqiandan();
        List<Map<String,Object>> list = new ArrayList<>();
        if (qiandans!=null)
            for(Qiandan qiandan:qiandans){
                int id = qiandan.getId();
                int classes = Integer.parseInt(qiandan.getClasses());
                String cname = "出错了！";
                if (classes==1)
                    cname = "口才主持";
                if (classes==2)
                    cname = "少儿编程";
                if (classes==3)
                    cname = "机器人编程";
                if (classes==4)
                    cname = "潜能开发";
                String classteacher = teacherService.getteacherByid(Integer.parseInt(qiandan.getClassteacher())).getNickname();
                String info = qiandan.getInfo();
                String price = qiandan.getPrice();
                String teacher = teacherService.getteacherByid(Integer.parseInt(qiandan.getTeacher())).getNickname();
                String time = qiandan.getTime();
                int yid = Integer.parseInt(qiandan.getYid());
                Map map = new HashMap();
                map.put("id",id);
                map.put("cname",cname);
                map.put("classteacher",classteacher);
                map.put("info",info);
                map.put("price",price);
                map.put("teacher",teacher);
                map.put("time",time);
                map.put("yid",yid);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectreturn")
    public Map<String,Object> selectreturn(){
        List<Return> returns = returnService.getreturn();
        List<Map<String,Object>> list = new ArrayList<>();
        if (returns!=null)
            for(Return returnn:returns){
                int id = returnn.getId();
                String text =  returnn.getText();
                int classes = Integer.parseInt(returnn.getClasses());
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(returnn.getPeople())).getSname();
                String cname = "出错了！";
                if (classes==1)
                    cname = "口才主持";
                if (classes==2)
                    cname = "少儿编程";
                if (classes==3)
                    cname = "机器人编程";
                if (classes==4)
                    cname = "潜能开发";
                Map map = new HashMap();
                map.put("id",id);
                map.put("cname",cname);
                map.put("text",text);
                map.put("sname",sname);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectruxuetest")
    public Map<String,Object> selectruxuetest(){
        List<Ruxuetest> ruxuetests = ruxuetestService.getruxuetest();
        List<Map<String,Object>> list = new ArrayList<>();
        if (ruxuetests!=null)
            for(Ruxuetest ruxuetest:ruxuetests){
                int id = ruxuetest.getId();
                String age = ruxuetest.getAge();
                String beizhu = ruxuetest.getBeizhu();
                String guihua = ruxuetest.getGuihua();
                String score = ruxuetest.getScore();
                String teacher = teacherService.getteacherByid(Integer.parseInt(ruxuetest.getTeacher())).getNickname();
                String text1 = ruxuetest.getText1();
                String text2 = ruxuetest.getText2();
                String text3 = ruxuetest.getText3();
                String text4 = ruxuetest.getText4();
                String text5 = ruxuetest.getText5();
                String time = ruxuetest.getTime();
                int classes = Integer.parseInt(ruxuetest.getCid());
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(ruxuetest.getSid())).getSname();
                String cname = "出错了！";
                if (classes==1)
                    cname = "口才主持";
                if (classes==2)
                    cname = "少儿编程";
                if (classes==3)
                    cname = "机器人编程";
                if (classes==4)
                    cname = "潜能开发";
                Map map = new HashMap();
                map.put("id",id);
                map.put("age",age);
                map.put("beizhu",beizhu);
                map.put("guihua",guihua);
                map.put("score",score);
                map.put("teacher",teacher);
                map.put("text1",text1);
                map.put("text2",text2);
                map.put("text3",text3);
                map.put("text4",text4);
                map.put("text5",text5);
                map.put("time",time);
                map.put("sname",sname);
                map.put("cname",cname);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectshangke")
    public Map<String,Object> selectshangke(){
        List<Shangke> shangkes = shangkeService.getshangke();
        List<Map<String,Object>> list = new ArrayList<>();
        if (shangkes!=null)
            for(Shangke shangke:shangkes){
                int id = shangke.getId();
                String tname = teacherService.getteacherByid(Integer.parseInt(shangke.getTeacher())).getNickname();
                String time = shangke.getTime();
                int classes = Integer.parseInt(shangke.getClasses());
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(shangke.getSid())).getSname();
                String cname = "出错了！";
                if (classes==1)
                    cname = "口才主持";
                if (classes==2)
                    cname = "少儿编程";
                if (classes==3)
                    cname = "机器人编程";
                if (classes==4)
                    cname = "潜能开发";
                Map map = new HashMap();
                map.put("id",id);
                map.put("tname",tname);
                map.put("time",time);
                map.put("sname",sname);
                map.put("cname",cname);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectsmininfo")
    public Map<String,Object> selectsmininfo(){
        List<Smininfo> smininfos = smininfoService.getsmininfo();
        List<Map<String,Object>> list = new ArrayList<>();
        if (smininfos!=null)
            for(Smininfo smininfo:smininfos){
                String id = smininfo.getId();
                String address = smininfo.getSaddress();
                String aihao = smininfo.getSaihao();
                String birth = smininfo.getSbirth();
                String info = smininfo.getSinfo();
                String jiguan = smininfo.getSjiguan();
                String lixiang = smininfo.getSlixiang();
                String minzu = smininfo.getSminzu();
                String name = smininfo.getSname();
                String nianji = smininfo.getSnianji();
                String photopath = smininfo.getSphotopath();
                String rongyu = smininfo.getSrongyu();
                String sex = smininfo.getSsex();
                String techang = smininfo.getStechang();
                Map map = new HashMap();
                map.put("id",id);
                map.put("address",address);
                map.put("aihao",aihao);
                map.put("birth",birth);
                map.put("info",info);
                map.put("jiguan",jiguan);
                map.put("lixiang",lixiang);
                map.put("minzu",minzu);
                map.put("name",name);
                map.put("nianji",nianji);
                map.put("photopath",photopath);
                map.put("rongyu",rongyu);
                map.put("sex",sex);
                map.put("techang",techang);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectsystongzhi")
    public Map<String,Object> selectsystongzhi(){
        List<Systongzhi> systongzhis = systongzhiService.getsystongzhi();
        List<Map<String,Object>> list = new ArrayList<>();
        if (systongzhis!=null)
            for(Systongzhi systongzhi:systongzhis){
                int id = systongzhi.getId();
                String text = systongzhi.getText();
                String time = systongzhi.getTime();
                int active = systongzhi.getActive();
                Map map = new HashMap();
                map.put("id",id);
                map.put("text",text);
                map.put("time",time);
                map.put("active",active);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectteacher")
    public Map<String,Object> selectteacher(){
        List<Teacher> teachers = teacherService.getteacher();
        List<Map<String,Object>> list = new ArrayList<>();
        if (teachers!=null)
            for(Teacher teacher:teachers){
                int id = teacher.getId();
                String birth = teacher.getBirth();
                int bumen = teacher.getBumenid();
                String bname = bumenService.getbumenByid(bumen).getBname();
                String nickname = teacher.getNickname();
                String password = teacher.getPassword();
                int quanxian = teacher.getQuanxian();
                String ruzhitime = teacher.getRuzhitime();
                String tname = teacher.getTname();
                Map map = new HashMap();
                map.put("id",id);
                map.put("birth",birth);
                map.put("bname",bname);
                map.put("nickname",nickname);
                map.put("password",password);
                map.put("quanxian",quanxian);
                map.put("ruzhitime",ruzhitime);
                map.put("tname",tname);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectyaoyue")
    public Map<String,Object> selectyaoyue(){
        List<Yaoyue> yaoyues = yaoyueService.getyaoyue();
        List<Map<String,Object>> list = new ArrayList<>();
        if (yaoyues!=null)
            for(Yaoyue yaoyue:yaoyues){
                int id = yaoyue.getId();
                int cid = Integer.parseInt(yaoyue.getClasses());
                String cname = "出错了！";
                if (cid==1)
                    cname = "口才主持";
                if (cid==2)
                    cname = "少儿编程";
                if (cid==3)
                    cname = "机器人编程";
                if (cid==4)
                    cname = "潜能开发";
                String daofang = yaoyue.getDaofang();
                String info = yaoyue.getInfo();
                String iswx = yaoyue.getIswx();
                String othername = yaoyue.getOthername();
                String age = yaoyue.getSage();
                String name = yaoyue.getSname();
                String sex = yaoyue.getSsex();
                String tel = yaoyue.getTel();
                String time = yaoyue.getTime();
                String tname = teacherService.getteacherByid(Integer.parseInt(yaoyue.getTname())).getNickname();

                Map map = new HashMap();
                map.put("id",id);
                map.put("cname",cname);
                map.put("daofang",daofang);
                map.put("info",info);
                map.put("iswx",iswx);
                map.put("time",time);
                map.put("age",age);
                map.put("tname",tname);
                map.put("name",name);
                map.put("sex",sex);
                map.put("tel",tel);
                map.put("othername",othername);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    @RequestMapping("/selectzuoye")
    public Map<String,Object> selectzuoye(){
        List<Zuoye> zuoyes = zuoyeService.getzuoye();
        List<Map<String,Object>> list = new ArrayList<>();
        if (zuoyes!=null)
            for(Zuoye zuoye:zuoyes){
                int id = zuoye.getId();
                String sname = smininfoService.getsmininfoByid(Integer.parseInt(zuoye.getSid())).getSname();
                String text = zuoye.getText();
                String time = zuoye.getTime();
                int cid = Integer.parseInt(zuoye.getClasses());
                String cname = "出错了！";
                if (cid==1)
                    cname = "口才主持";
                if (cid==2)
                    cname = "少儿编程";
                if (cid==3)
                    cname = "机器人编程";
                if (cid==4)
                    cname = "潜能开发";
                Map map = new HashMap();
                map.put("id",id);
                map.put("cname",cname);
                map.put("sname",sname);
                map.put("text",text);
                map.put("time",time);
                list.add(map);
            }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("code",0);
        map1.put("msg","ok");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }
}

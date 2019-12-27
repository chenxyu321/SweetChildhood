package com.xiaofangtang.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaofangtang.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelController {
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

    @RequestMapping("/delactive")
    public Boolean delactive(int id){
        int i = 0;
        i = activeService.delactive(id);
        if (i!=0)
            return true;
        return false;
    }
    @RequestMapping("/delbumen")
    public Boolean delbumen(int id){
        int i = 0;
        i = bumenService.delbumen(id);
        if (i!=0)
            return true;
        return false;
    }
    @RequestMapping("/delcansai")
    public Boolean delcansai(int id){
        int i = 0;
        i = cansaiService.delcansai(id);
        if (i!=0)
            return true;
        return false;
    }
    @RequestMapping("/delchengguophoto")
    public Boolean delchengguophoto(int id){
        int i = 0;
        i = chengguophotoService.delchengguophoto(id);
        if (i!=0)
            return true;
        return false;
    }
    @RequestMapping("/delchengguo")
    public Boolean delchengguo(int id){
        int i = 0;
        i = chengguoService.delchengguo(id);
        if (i!=0)
            return true;
        return false;
    }
    @RequestMapping("/delchengyuan")
    public Boolean delchengyuan(int id){
        int i = 0;
        i = chengyuanService.delchengyuan(id);
        if (i!=0)
            return true;
        return false;
    }
    @RequestMapping("/delfankui")
    public Boolean delfankui(int id){
        int i = 0;
        i = fankuiService.delfankui(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delhuifang")
    public Boolean delhuifang(int id){
        int i = 0;
        i = huifangService.delhuifang(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delhuodong")
    public Boolean delhuodong(int id){
        int i = 0;
        i = huodongService.delhuodong(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delhuojiang")
    public Boolean delhuojiang(int id){
        int i = 0;
        i = huojiangService.delhuojiang(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delketangbiaoxian")
    public Boolean delketangbiaoxian(int id){
        int i = 0;
        i = ketangbiaoxianService.delketangbiaoxian(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delnews")
    public Boolean delnews(int id){
        int i = 0;
        i = newsService.delnews(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delparentfankui")
    public Boolean delparentfankui(int id){
        int i = 0;
        i = parentfankuiService.delparentfankui(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delparent")
    public Boolean delparent(int id){
        int i = 0;
        i = parentService.delparent(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delpicture")
    public Boolean delpicture(int id){
        int i = 0;
        i = pictureService.delpicture(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delqiandan")
    public Boolean delqiandan(int id){
        int i = 0;
        i = qiandanService.delqiandan(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delreturn")
    public Boolean delreturn(int id){
        int i = 0;
        i = returnService.delreturn(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delruxuetest")
    public Boolean delruxuetest(int id){
        int i = 0;
        i = ruxuetestService.delruxuetest(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delshangke")
    public Boolean delshangke(int id){
        int i = 0;
        i = shangkeService.delshangke(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delsmininfo")
    public Boolean delsmininfo(int id){
        int i = 0;
        i = smininfoService.delsmininfo(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delsystongzhi")
    public Boolean delsystongzhi(int id){
        int i = 0;
        i = systongzhiService.delsystongzhi(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delteacher")
    public Boolean delteacher(int id){
        int i = 0;
        i = teacherService.delteacher(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delyaoyue")
    public Boolean delyaoyue(int id){
        int i = 0;
        i = yaoyueService.delyaoyue(id);
        if (i!=0)
            return true;
        return false;
    }

    @RequestMapping("/delzuoye")
    public Boolean delzuoye(int id){
        int i = 0;
        i = zuoyeService.delzuoye(id);
        if (i!=0)
            return true;
        return false;
    }
}

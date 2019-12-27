package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface HomedataService {
    List<Integer> getyaoyuenumGroupBytime();//获取每天邀约数量
    List<String> getyaoyuedateGroupBytime();//获取邀约数量对应的日期
    List<Integer> getdaofangGroupBytime();//获取每天到访数量
    List<String> getdaofangdateGroupBytime();//获取到访数量对应日期
    List<Double> getsumpriceGroupBytime();//获取每天销售额
    List<String> gettimeGroupBytime();//获取销售额对应的日期
    List<Integer> getyaoyuenumGroupByteacher();//获取每天邀约数量
    List<String> getteacherGroupByteacher();//获取邀约数量对应日期
    List<Integer> getstudentnumGoupByclass();//获取每科学生数
    List<String> getclassname();//获取课程名
}

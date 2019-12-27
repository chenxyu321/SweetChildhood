package com.xiaofangtang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface HomedataMapper {
    List<Integer> getyaoyuenumGroupBytime();

    List<String> getyaoyuedateGroupBytime();

    List<Integer> getdaofangGroupBytime();

    List<String> getdaofangdateGroupBytime();

    List<Double> getsumpriceGroupBytime();

    List<String> gettimeGroupBytime();

    List<Integer> getyaoyuenumGroupByteacher();

    List<String> getteacherGroupByteacher();

    List<Integer> getstudentnumGoupByclass();

}
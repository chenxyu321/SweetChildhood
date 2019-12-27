package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.HomedataMapper;
import com.xiaofangtang.service.HomedataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class HomedataServiceImpl implements HomedataService {
    @Autowired
    private HomedataMapper homedataMapper;
    @Override
    public List<Integer> getyaoyuenumGroupBytime() {
        return homedataMapper.getyaoyuenumGroupBytime();
    }

    @Override
    public List<String> getyaoyuedateGroupBytime() {
        return homedataMapper.getyaoyuedateGroupBytime();
    }

    @Override
    public List<Integer> getdaofangGroupBytime() {
        return homedataMapper.getdaofangGroupBytime();
    }

    @Override
    public List<String> getdaofangdateGroupBytime() {
        return homedataMapper.getdaofangdateGroupBytime();
    }

    @Override
    public List<Double> getsumpriceGroupBytime() {
        return homedataMapper.getsumpriceGroupBytime();
    }

    @Override
    public List<String> gettimeGroupBytime() {
        return homedataMapper.gettimeGroupBytime();
    }

    @Override
    public List<Integer> getyaoyuenumGroupByteacher() {
        return homedataMapper.getyaoyuenumGroupByteacher();
    }

    @Override
    public List<String> getteacherGroupByteacher() {
        return homedataMapper.getteacherGroupByteacher();
    }

    @Override
    public List<Integer> getstudentnumGoupByclass() {
        return homedataMapper.getstudentnumGoupByclass();
    }

    @Override
    public List<String> getclassname() {
        List <String> list = new ArrayList<>();
        list.add("口才主持");
        list.add("少儿编程");
        list.add("机器人编程");
        list.add("潜能开发");
        return list;
    }
}

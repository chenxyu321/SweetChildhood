package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Parent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ParentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Parent record);

    int insertSelective(Parent record);

    Parent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Parent record);

    int updateByPrimaryKey(Parent record);

    List<Parent> getparent();

    List<Parent> getparentBystudent(int id);
}
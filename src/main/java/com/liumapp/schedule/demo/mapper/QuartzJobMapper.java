package com.liumapp.schedule.demo.mapper;

import com.liumapp.schedule.demo.domain.QuartzJob;
import com.liumapp.schedule.demo.domain.QuartzJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartzJobMapper {
    long countByExample(QuartzJobExample example);

    int deleteByExample(QuartzJobExample example);

    int deleteByPrimaryKey(String id);

    int insert(QuartzJob record);

    int insertSelective(QuartzJob record);

    List<QuartzJob> selectByExample(QuartzJobExample example);

    QuartzJob selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") QuartzJob record, @Param("example") QuartzJobExample example);

    int updateByExample(@Param("record") QuartzJob record, @Param("example") QuartzJobExample example);

    int updateByPrimaryKeySelective(QuartzJob record);

    int updateByPrimaryKey(QuartzJob record);
}
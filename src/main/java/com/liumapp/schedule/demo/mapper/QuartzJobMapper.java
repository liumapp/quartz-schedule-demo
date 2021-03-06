package com.liumapp.schedule.demo.mapper;

import com.liumapp.schedule.demo.model.QuartzJob;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * file QuartzJobMapper.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/5
 */
@org.apache.ibatis.annotations.Mapper
public interface QuartzJobMapper extends Mapper<QuartzJob>{

    @Select("select * from quartz_job where is_delete = 0")
    List<QuartzJob> selectAll();

    @Select("select * from quartz_job where job_class = #{jobClass} and status = 0")
    List<QuartzJob> selectActiveDetailJobs(@Param("jobClass") String jobClass);

}
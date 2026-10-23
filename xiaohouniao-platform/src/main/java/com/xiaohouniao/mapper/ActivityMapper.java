package com.xiaohouniao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohouniao.model.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

    @Select("SELECT category, COUNT(*) as count FROM activity WHERE deleted = 0 AND is_published = 1 GROUP BY category")
    List<Map<String, Object>> countByCategory();

    @Select("SELECT DATE_FORMAT(create_time, '%Y-%m') as month, COUNT(*) as count FROM activity WHERE deleted = 0 AND is_published = 1 GROUP BY month ORDER BY month DESC LIMIT 12")
    List<Map<String, Object>> monthlyTrend();
}

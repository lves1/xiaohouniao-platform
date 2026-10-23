package com.xiaohouniao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohouniao.model.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper extends BaseMapper<Topic> {
}

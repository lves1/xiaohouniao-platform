package com.xiaohouniao.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohouniao.model.dto.PageQuery;
import com.xiaohouniao.model.dto.VolunteerDTO;
import com.xiaohouniao.model.entity.Volunteer;

public interface VolunteerService extends IService<Volunteer> {
    Page<Volunteer> pageList(PageQuery query);
    Page<Volunteer> pagePublic(PageQuery query);
    Volunteer create(VolunteerDTO dto);
    Volunteer update(Long id, VolunteerDTO dto);
}

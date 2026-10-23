package com.xiaohouniao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohouniao.model.dto.LoginDTO;
import com.xiaohouniao.model.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
    String login(LoginDTO dto);
    SysUser getByUsername(String username);
    void changePassword(Long userId, String oldPwd, String newPwd);
}

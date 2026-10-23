package com.xiaohouniao.controller.admin;

import com.xiaohouniao.common.Result;
import com.xiaohouniao.model.dto.LoginDTO;
import com.xiaohouniao.service.SysUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SysUserService sysUserService;

    @PostMapping("/login")
    public Result<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = sysUserService.login(dto);
        return Result.ok(Map.of("token", token));
    }
}

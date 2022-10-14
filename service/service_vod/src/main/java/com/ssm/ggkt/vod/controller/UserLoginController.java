package com.ssm.ggkt.vod.controller;

import com.ssm.ggkt.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/12 18:34
 */
@RestController
@RequestMapping("/admin/vod/user")
@CrossOrigin
public class UserLoginController {
    @PostMapping("login")
    public Result login() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map);
    }

    @GetMapping("info")
    public Result info() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles","admin");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        return Result.ok(map);
    }
}

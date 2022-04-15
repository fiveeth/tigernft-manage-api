package com.tiger.nft.api;

import com.alibaba.fastjson.JSONObject;
import com.tiger.nft.common.RestResult;
import com.tiger.nft.domain.user.NftUser;
import com.tiger.nft.domain.user.NftUserQuery;
import com.tiger.nft.service.NftUserService;
import com.tiger.nft.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 登录
 * @author: xxx
 * @date: 2022/04/07
 */
@RestController
@RequestMapping("/user/")
public class NftUserApi {

    @Autowired
    private NftUserService userService;

    @PostMapping("/login")
    public RestResult Login(@RequestBody NftUserQuery userQuery) {
        NftUser nftUser = userService.getUserInfo(userQuery);
        if(nftUser == null) {
            return RestResult.error("账号不存在！");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", nftUser.getUserId());
        // 30天过期，括号中的是分钟的毫秒数
        String token = JwtUtils.createToken(nftUser.getUserId(), map, 60 * 24 * 30 * (60 * 1000L));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", token);
        jsonObject.put("username", nftUser.getUsername());
        return RestResult.success(jsonObject);
    }

    @PostMapping("/list")
    public RestResult getUserList() {
        List<NftUser> userList = userService.getUserList();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userList", userList);
        return RestResult.success(jsonObject);
    }
}

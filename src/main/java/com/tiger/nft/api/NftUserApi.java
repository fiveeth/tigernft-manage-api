package com.tiger.nft.api;

import com.tiger.nft.domain.user.NftUserQuery;
import com.tiger.nft.service.NftUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String Login(@RequestBody NftUserQuery userQuery) {
        return userService.getUserInfo(userQuery);
    }
}

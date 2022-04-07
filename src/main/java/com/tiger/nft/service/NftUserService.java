package com.tiger.nft.service;

import com.alibaba.fastjson.JSONObject;
import com.tiger.nft.excetion.BusinessException;
import com.tiger.nft.domain.user.NftUser;
import com.tiger.nft.domain.user.NftUserQuery;
import com.tiger.nft.mapper.NftUserMapper;
import com.tiger.nft.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 登录
 * @author: xxx
 * @date: 2022/04/07
 */
@Service
public class NftUserService {

    @Autowired
    private NftUserMapper userMapper;

    public String getUserInfo(NftUserQuery userQuery) {
        NftUser nftUser = userMapper.getUserInfo(userQuery.getUsername(), userQuery.getPassword());
        if(nftUser == null) {
            throw new BusinessException("账号不存在！");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", nftUser.getUserId());
        // 30天过期，括号中的是分钟的毫秒数
        String token = JwtUtils.createToken(nftUser.getUserId(), map, 60 * 24 * 30 * (60 * 1000L));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", token);
        jsonObject.put("username", nftUser.getUsername());

        return jsonObject.toJSONString();
    }
}

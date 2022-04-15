package com.tiger.nft.service;

import com.tiger.nft.domain.user.NftUser;
import com.tiger.nft.domain.user.NftUserQuery;
import com.tiger.nft.dao.NftUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 登录
 * @author: xxx
 * @date: 2022/04/07
 */
@Service
public class NftUserService {

    @Autowired
    private NftUserMapper userMapper;

    public NftUser getUserInfo(NftUserQuery userQuery) {
        NftUser nftUser = userMapper.getUserInfo(userQuery.getUsername(), userQuery.getPassword());

        return nftUser;
    }

    public List<NftUser> getUserList() {
        List<NftUser> userList = userMapper.getUserList();

        return userList;
    }
}

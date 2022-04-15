package com.tiger.nft.dao;

import com.tiger.nft.domain.user.NftUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 登录
 * @author: xxx
 * @date: 2022/04/07
 */
@Mapper
public interface NftUserMapper {

    /**
     * 获取用户信息
     *
     * @param username
     * @param password
     * @return
     */
    NftUser getUserInfo(@Param(value = "username") String username, @Param(value = "password") String password);

    /**
     * 获取用户列表
     *
     * @return
     */
    List<NftUser> getUserList();
}

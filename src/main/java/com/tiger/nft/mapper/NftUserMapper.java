package com.tiger.nft.mapper;

import com.tiger.nft.domain.user.NftUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}

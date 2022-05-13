package com.yepinxi.blog.strategy;

import com.yepinxi.blog.dto.UserInfoDTO;

/**
 * 第三方登录策略
 *
 * @author yepinxi
 * 
 */
public interface SocialLoginStrategy {

    /**
     * 登录
     *
     * @param data 数据
     * @return {@link UserInfoDTO} 用户信息
     */
    UserInfoDTO login(String data);

}

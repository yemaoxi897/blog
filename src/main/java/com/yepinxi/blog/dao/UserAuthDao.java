package com.yepinxi.blog.dao;

import com.yepinxi.blog.dto.UserBackDTO;
import com.yepinxi.blog.entity.UserAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yepinxi.blog.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 用户账号
 *
 * @author yepinxi
 * @date 2021/08/10
 */
@Repository
public interface UserAuthDao extends BaseMapper<UserAuth> {

    /**
     * 查询后台用户列表
     *
     * @param current   页码
     * @param size      大小
     * @param condition 条件
     * @return {@link List< UserBackDTO >} 用户列表
     */
    List<UserBackDTO> listUsers(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);

    /**
     * 查询后台用户数量
     *
     * @param condition 条件
     * @return 用户数量
     */
    Integer countUser(@Param("condition") ConditionVO condition);

}

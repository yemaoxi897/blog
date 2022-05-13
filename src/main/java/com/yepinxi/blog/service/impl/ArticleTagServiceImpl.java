package com.yepinxi.blog.service.impl;

import com.yepinxi.blog.entity.ArticleTag;
import com.yepinxi.blog.dao.ArticleTagDao;
import com.yepinxi.blog.service.ArticleTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文章标签服务
 *
 * @author yepinxi
 * @date 2021/08/10
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTag> implements ArticleTagService {

}

package com.yepinxi.blog.consumer;

import com.alibaba.fastjson.JSON;
import com.yepinxi.blog.dao.ElasticsearchDao;
import com.yepinxi.blog.dto.ArticleSearchDTO;
import com.yepinxi.blog.dto.MaxwellDataDTO;
import com.yepinxi.blog.entity.Article;
import com.yepinxi.blog.util.BeanCopyUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import static com.yepinxi.blog.constant.MQPrefixConst.MAXWELL_QUEUE;

/**
 * maxwell监听数据
 *
 * @author yepinxi
 * @date 2021/08/02
 */
@Component
@RabbitListener(queues = MAXWELL_QUEUE)
public class MaxWellConsumer {
    @Autowired
    private ElasticsearchDao elasticsearchDao;

    @RabbitHandler
    public void process(byte[] data) {
        // 获取监听信息
        MaxwellDataDTO maxwellDataDTO = JSON.parseObject(new String(data), MaxwellDataDTO.class);
        // 获取文章数据
        Article article = JSON.parseObject(JSON.toJSONString(maxwellDataDTO.getData()), Article.class);
        // 判断操作类型
        switch (maxwellDataDTO.getType()) {
            case "insert":
            case "update":
                // 更新es文章
                elasticsearchDao.save(BeanCopyUtils.copyObject(article, ArticleSearchDTO.class));
                break;
            case "delete":
                // 删除文章
                elasticsearchDao.deleteById(article.getId());
                break;
            default:
                break;
        }
    }

}
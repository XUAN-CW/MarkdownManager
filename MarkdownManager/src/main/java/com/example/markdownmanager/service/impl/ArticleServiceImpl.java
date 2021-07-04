package com.example.markdownmanager.service.impl;

import com.example.markdownmanager.entity.Article;
import com.example.markdownmanager.mapper.ArticleMapper;
import com.example.markdownmanager.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XUAN-CW
 * @since 2021-07-04
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}

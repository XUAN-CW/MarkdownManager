package com.example.markdownmanager.service.impl;

import com.example.markdownmanager.entity.Category;
import com.example.markdownmanager.mapper.CategoryMapper;
import com.example.markdownmanager.service.CategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

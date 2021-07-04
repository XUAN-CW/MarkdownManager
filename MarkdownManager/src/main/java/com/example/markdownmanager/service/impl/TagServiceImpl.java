package com.example.markdownmanager.service.impl;

import com.example.markdownmanager.entity.Tag;
import com.example.markdownmanager.mapper.TagMapper;
import com.example.markdownmanager.service.TagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}

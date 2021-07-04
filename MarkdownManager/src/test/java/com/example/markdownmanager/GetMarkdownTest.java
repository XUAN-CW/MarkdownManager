package com.example.markdownmanager;

import com.example.markdownmanager.utils.GetMarkdown;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author XUAN
 * @date 2021/7/4 - 14:09
 */
@SpringBootTest
class GetMarkdownTest {


    @Autowired
    GetMarkdown getMarkdown;

    @Test
    void contextLoads() {
        getMarkdown.getFileBySuffix("C:\\core\\blog").forEach(k-> System.out.println(k.getAbsolutePath()));

    }

}

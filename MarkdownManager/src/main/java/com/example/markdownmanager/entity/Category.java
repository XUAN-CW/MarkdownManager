package com.example.markdownmanager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author XUAN
 * @date 2021/7/4 - 14:37
 */
@Data
@Entity
public class Category {

    @Id
    BigInteger id;
    Date gmt_create;
    Date gmt_modified;

    String name;

    Long search_count;
    Date search_last_time;

}

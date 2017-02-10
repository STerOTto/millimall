package com.millinch.mall.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
public class Goods {

    @TableId
    private Long id;

    private String name;

    private Integer categoryId;

    private Long storeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}

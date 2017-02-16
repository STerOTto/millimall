package com.millinch.mall.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.millinch.mall.goods.entity.Category;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
public interface CategoryService extends IService<Category> {

    List<Category> getCategoryTree();
}

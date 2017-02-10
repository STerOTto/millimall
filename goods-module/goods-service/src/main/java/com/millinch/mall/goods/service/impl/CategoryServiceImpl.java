package com.millinch.mall.goods.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.millinch.mall.goods.entity.Category;
import com.millinch.mall.goods.mapper.CategoryMapper;
import com.millinch.mall.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getCategoryTree() {
        Category example = new Category();
        example.setParentId(-1);
        List<Category> categories = categoryMapper.selectList(new EntityWrapper<Category>(example));
        if (categories == null) {
            categories = Collections.emptyList();
        } else {
            for (Category category : categories) {
                loadChildren(category);
            }
        }
        return categories;
    }

    private void loadChildren(Category category) {
        Category example = new Category();
        example.setParentId(category.getId());
        List<Category> categories = categoryMapper.selectList(new EntityWrapper<Category>(example));
        if (categories != null && categories.size() > 0) {
            category.setChildren(categories);
            for (Category cate : categories) {
                loadChildren(cate);
            }
        }
    }
}

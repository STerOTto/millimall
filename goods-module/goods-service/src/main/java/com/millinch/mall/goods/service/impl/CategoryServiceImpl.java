package com.millinch.mall.goods.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getCategoryTree() {
        List<Category> categories = categoryMapper.selectOrderedListByParent(-1);
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
        List<Category> categories = categoryMapper.selectOrderedListByParent(category.getId());
        if (categories != null && categories.size() > 0) {
            category.setChildren(categories);
            for (Category cate : categories) {
                loadChildren(cate);
            }
        }
    }
}

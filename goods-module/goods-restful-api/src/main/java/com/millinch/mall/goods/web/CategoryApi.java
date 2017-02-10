package com.millinch.mall.goods.web;

import com.millinch.mall.goods.entity.Category;
import com.millinch.mall.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@RestController
@RequestMapping("/categories")
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategoryTree() {
        return categoryService.getCategoryTree();
    }
}

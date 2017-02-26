package com.millinch.mall.goods.web;

import com.millinch.core.domain.ResponseModel;
import com.millinch.mall.goods.entity.Category;
import com.millinch.mall.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity createCategory(@RequestBody Category category) {
        boolean insert = categoryService.insert(category);
        ResponseModel.Builder builder = ResponseModel.builder().ok(insert);
        if (insert) {
            builder.body(category).message("创建成功");
        } else {
            builder.message("创建失败");
        }
        return ResponseEntity.ok(insert);
    }
}

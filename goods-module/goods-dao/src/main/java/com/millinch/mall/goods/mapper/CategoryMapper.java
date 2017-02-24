package com.millinch.mall.goods.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.millinch.mall.goods.entity.Category;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author John Zhang
 * @since 2017-02-22
 */
public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> selectOrderedListByParent(Integer parentId);
}
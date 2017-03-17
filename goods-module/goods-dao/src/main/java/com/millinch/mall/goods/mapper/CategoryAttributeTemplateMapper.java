package com.millinch.mall.goods.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.millinch.mall.goods.entity.CategoryAttributeTemplate;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author John Zhang
 * @since 2017-02-22
 */
public interface CategoryAttributeTemplateMapper extends BaseMapper<CategoryAttributeTemplate> {

    List<CategoryAttributeTemplate> selectByCategoryIds(Long... categoryIds);
}
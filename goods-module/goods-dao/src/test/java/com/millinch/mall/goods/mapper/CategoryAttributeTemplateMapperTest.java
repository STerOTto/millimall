package com.millinch.mall.goods.mapper;

import com.millinch.mall.goods.entity.CategoryAttributeTemplate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
public class CategoryAttributeTemplateMapperTest extends BaseMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryAttributeTemplateMapperTest.class);

    @Autowired CategoryAttributeTemplateMapper templateMapper;

    @Test
    public void testSelectByCategoryIds() throws Exception {
        List<CategoryAttributeTemplate> templateList = templateMapper.selectByCategoryIds(1L, 2L, 3L);
        System.out.println("templateList = " + templateList);
    }
}
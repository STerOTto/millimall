package com.millinch.mall.goods.mapper;

import com.millinch.mall.goods.entity.Goods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
public class GoodsMapperTest extends BaseMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsMapperTest.class);

    @Autowired
    GoodsMapper goodsMapper;

    @Before
    public void setUp() throws Exception {
        LOGGER.info("Start testing GoodsMapper");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSelectAll() throws Exception {
        List<Goods> goodsList = goodsMapper.selectList(null);
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }
}
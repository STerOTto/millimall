package com.millinch.mall.goods.mapper;

import com.millinch.mall.goods.DataSourceConfig;
import com.millinch.mall.goods.GoodsDaoConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Mybatis Mapper Junit base class.
 *
 * @author John Zhang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
                DataSourceConfig.class,
                GoodsDaoConfig.class
        }
)
public class BaseMapperTest {
}

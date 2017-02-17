package com.millinch.mall.goods;

import com.baomidou.mybatisplus.enums.DBType;
import com.millinch.core.config.DaoConfig;
import org.springframework.context.annotation.Configuration;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@Configuration
public class GoodsDaoConfig extends DaoConfig {

    @Override
    public String getDialectType() {
        return DBType.MYSQL.getDb();
    }

    @Override
    public String getMapperBasePackage() {
        return "com.millinch.mall.goods.mapper";
    }

    @Override
    public String getMapperLocations() {
        return "classpath*:mapper/*-mapper.xml";
    }

    @Override
    public String getTypeAliasesPackage() {
        return "com.millinch.mall.goods.entity";
    }
}

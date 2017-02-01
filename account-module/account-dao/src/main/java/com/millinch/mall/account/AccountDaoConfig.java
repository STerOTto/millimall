package com.millinch.mall.account;

import com.millinch.core.config.DaoConfig;
import org.springframework.context.annotation.Configuration;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@Configuration
public class AccountDaoConfig extends DaoConfig {

    @Override
    public String getDialectType() {
        return "mysql";
    }

    @Override
    public String getMapperBasePackage() {
        return "com.millinch.mall.account.mapper";
    }

    @Override
    public String getMapperLocations() {
        return "classpath*:mapper/*-mapper.xml";
    }

    @Override
    public String getTypeAliasesPackage() {
        return "com.millinch.mall.account.entity";
    }
}

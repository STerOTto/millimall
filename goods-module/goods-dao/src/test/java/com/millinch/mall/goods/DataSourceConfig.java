package com.millinch.mall.goods;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(
                "jdbc:mysql://localhost:13306/millinch_product?verifyServerCertificate=false&useSSL=false&characterEncoding=UTF-8",
                "root", "14yhl9t"
        );
    }
}

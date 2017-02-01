package com.millinch.core.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
public abstract class DaoConfig {

    @Bean
    @DependsOn("dataSource")
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        bean.setTypeAliasesPackage(getTypeAliasesPackage());
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourcePatternResolver.getResources("classpath*:mapper/*-mapper.xml");
        bean.setMapperLocations(resources);
        bean.setPlugins(new Interceptor[]{ paginationInterceptor() });
        bean.setDbColumnUnderline(true);
        return bean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage(getMapperBasePackage());
        return configurer;
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor interceptor = new PaginationInterceptor();
        interceptor.setDialectType( getDialectType() );
        return interceptor;
    }

    public abstract String getDialectType();

    public abstract String getMapperBasePackage();

    public abstract String getMapperLocations();

    public abstract String getTypeAliasesPackage();
}

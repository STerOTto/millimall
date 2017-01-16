package com.millinch.springboot.autoconfigure.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import javax.sql.XADataSource;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for {@link com.alibaba.druid.pool.DruidDataSource}.
 *
 * @author John Zhang
 */
@Configuration
@ConditionalOnClass({ DataSource.class })
@EnableConfigurationProperties({ DruidDatasourceProperties.class })
public class DruidDatasourceAutoConfiguration {

    @Autowired DruidDatasourceProperties datasourceProperties;

    @Bean
    @ConditionalOnMissingBean({ DataSource.class, XADataSource.class })
    public DataSource dataSource(DruidDatasourceProperties datasourceProperties) throws Exception {
        return DruidDataSourceFactory.createDataSource(datasourceProperties.getProperties());
    }

    @Bean
    @ConditionalOnWebApplication
    @ConditionalOnProperty(prefix = "spring.datasource.druid.stat-servlet", name = "url-mapping")
    public ServletRegistrationBean druidServlet() {
        DruidDatasourceProperties.StatServlet stat = datasourceProperties.getStatServlet();
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings(stat.getUrlMapping());
        if (StringUtils.hasText(stat.getAllow())) {
            reg.addInitParameter("allow", stat.getAllow());
        }
        if (StringUtils.hasText(stat.getDeny())) {
            reg.addInitParameter("deny", stat.getDeny());
        }
        if (StringUtils.hasText(stat.getLoginUsername())) {
            reg.addInitParameter("loginUsername", stat.getLoginUsername());
        }
        if (StringUtils.hasText(stat.getLoginPassword())) {
            reg.addInitParameter("loginPassword", stat.getLoginPassword());
        }
        if (StringUtils.hasText(stat.getLoginPassword())) {
            reg.addInitParameter("resetEnable", stat.getResetEnable());
        }
        return reg;
    }

    @Bean
    @ConditionalOnWebApplication
    @ConditionalOnProperty(prefix = "spring.datasource.druid.stat-filter", name = "url-pattern")
    public FilterRegistrationBean filterRegistrationBean() {
        DruidDatasourceProperties.StatFilter stat = datasourceProperties.getStatFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        if (StringUtils.hasText(stat.getUrlPattern())) {
            filterRegistrationBean.addUrlPatterns(stat.getUrlPattern());
        }
        if (StringUtils.hasText(stat.getSessionStatMaxCount())) {
            filterRegistrationBean.addInitParameter("sessionStatMaxCount", stat.getSessionStatMaxCount());
        }
        if (StringUtils.hasText(stat.getSessionStatEnable())) {
            filterRegistrationBean.addInitParameter("sessionStatEnable", stat.getSessionStatEnable());
        }
        if (StringUtils.hasText(stat.getPrincipalSessionName())) {
            filterRegistrationBean.addInitParameter("principalSessionName", stat.getPrincipalSessionName());
        }
        if (StringUtils.hasText(stat.getPrincipalCookieName())) {
            filterRegistrationBean.addInitParameter("principalCookieName", stat.getPrincipalCookieName());
        }
        if (StringUtils.hasText(stat.getProfileEnable())) {
            filterRegistrationBean.addInitParameter("profileEnable", stat.getProfileEnable());
        }
        return filterRegistrationBean;
    }
}

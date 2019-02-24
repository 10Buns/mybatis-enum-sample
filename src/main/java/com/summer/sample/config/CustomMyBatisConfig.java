package com.summer.sample.config;

import com.summer.sample.handler.AutoEnumTypeHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;


/**
 * All rights Reserved, Designed By mapletowngames.com
 *
 * @Version V1.0
 * @Title: CustomMyBatisConfig
 * @Package com.summer.sample.config
 * @Author: summer
 * @Date: 2019-02-24 22:28
 * @Description: 注意：
 */
@Configuration
@ConfigurationProperties(prefix = "mybatis")
public class CustomMyBatisConfig {

    private String configLocation;
    private String mapperLocations;

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        // 设置MyBatis的配置文件及mapper文件路径
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setConfigLocation(resolver.getResource(configLocation));
        factory.setMapperLocations(resolver.getResources(mapperLocations));
        SqlSessionFactory sqlSessionFactory = factory.getObject();
        // 获取类型转换注册器
        TypeHandlerRegistry typeHandlerRegistry =
                sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
        // 替换默认的枚举转换器
        typeHandlerRegistry.setDefaultEnumTypeHandler(AutoEnumTypeHandler.class);
        return sqlSessionFactory;
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }
}

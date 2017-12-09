package com.yunxie.config.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.yunxie.config.bean.DruidBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 * Created by WXH on 2017/11/20.
 * http://localhost:9002/xie/druid/index.html admin 123456
 */
@Configuration
@EnableConfigurationProperties(DruidBean.class)
public class DruidConfig {

    @Autowired
    private DruidBean druidBean;

    @Bean
    @ConfigurationProperties("spring.druid.datasource")
    public DruidDataSource dataSource(
            DataSourceProperties properties)
            throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidBean.getDriverClassName());
        dataSource.setUrl(druidBean.getUrl());
        dataSource.setUsername(druidBean.getUsername());
        dataSource.setPassword(druidBean.getPassword());
        dataSource.setInitialSize(druidBean.getInitialSize());
        dataSource.setMinIdle(druidBean.getMinIdle());
        dataSource.setMaxActive(druidBean.getMaxActive());
        dataSource.setMaxWait(druidBean.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druidBean.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidBean.getMinEvictableIdleTimeMillis());
        String validationQuery = druidBean.getValidationQuery();
        if (validationQuery != null && !"".equals(validationQuery)) {
            dataSource.setValidationQuery(validationQuery);
        }
        dataSource.setTestWhileIdle(druidBean.isTestWhileIdle());
        dataSource.setTestOnBorrow(druidBean.isTestOnBorrow());
        dataSource.setTestOnReturn(druidBean.isTestOnReturn());
        if(druidBean.isPoolPreparedStatements()){
            dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidBean.getMaxPoolPreparedStatementPerConnectionSize());
        }
        dataSource.setFilters(druidBean.getFilters());//这是最关键的,否则SQL监控无法生效
        String connectionPropertiesStr = druidBean.getConnectionProperties();
        if(connectionPropertiesStr != null && !"".equals(connectionPropertiesStr)){
            Properties connectProperties = new Properties();
            String[] propertiesList = connectionPropertiesStr.split(";");
            for(String propertiesTmp:propertiesList){
                String[] obj = propertiesTmp.split("=");
                String key = obj[0];
                String value = obj[1];
                connectProperties.put(key,value);
            }
            dataSource.setConnectProperties(connectProperties);
        }
        dataSource.setUseGlobalDataSourceStat(druidBean.isUseGlobalDataSourceStat());

        return dataSource;
    }
}
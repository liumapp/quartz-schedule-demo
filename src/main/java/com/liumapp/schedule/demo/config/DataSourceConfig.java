package com.liumapp.schedule.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.mapper.autoconfigure.SpringBootVFS;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * file DataSourceConfig.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/5
 */
@Configuration
@ConditionalOnProperty(name = "com.liumapp.schedule.datasource")
@MapperScan(value = "com.liumapp.schedule.demo.mapper", sqlSessionTemplateRef = "scheduleSqlSessionTemplate" )
public class DataSourceConfig {

    @Value("${com.liumapp.schedule.datasource.driver-class-name}")
    private String dbDriverClassName;

    @Value("${com.liumapp.schedule.datasource.url}")
    private String dbUrl;

    @Value("${com.liumapp.schedule.datasource.username}")
    private String dbUserName;

    @Value("${com.liumapp.schedule.datasource.password}")
    private String dbPassword;

    @Value("${com.liumapp.schedule.datasource.validationQuery}")
    private String validationQuery;

    @Value("${com.liumapp.schedule.datasource.validationQueryTimeout}")
    private Integer validationQueryTimeout;

    @Value("${mybatis.config-location:mybatis-config.xml}")
    private String configLocation;

    @Value("${com.liumapp.schedule.datasource.max-active}")
    private Integer maxActive;

    @Value("${com.liumapp.schedule.datasource.min-idle}")
    private Integer minIdle;

    @Bean("scheduleSqlSessionTemplate")
    public SqlSessionTemplate commmonSessionTemplate() {
        DataSource dataSource = this.deviceDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("authManager", transactionFactory, dataSource);
        tk.mybatis.mapper.session.Configuration configuration = new tk.mybatis.mapper.session.Configuration();
        configuration.setEnvironment(environment);
        configuration.setLazyLoadingEnabled(true);
        configuration.setMapUnderscoreToCamelCase(true);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "scheduleDataSource")
    public DataSource deviceDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(this.dbUrl);
        dataSource.setUsername(this.dbUserName);
        dataSource.setPassword(this.dbPassword);
        dataSource.setDriverClassName(this.dbDriverClassName);
        dataSource.setValidationQuery(this.validationQuery);
        dataSource.setValidationQueryTimeout(this.validationQueryTimeout);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        return dataSource;
    }

    @Bean(name = "scheduleTransactionManager")
    @Autowired
    public DataSourceTransactionManager statisticTransactionManager(@Qualifier("scheduleDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "deviceSessionFactory")
    @Autowired
    public SqlSessionFactory getStatisticSqlSessionFactoryBean(@Qualifier("scheduleDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.liumapp.schedule.demo.model");
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }

}

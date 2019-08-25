package com.skylar.webflux.starter.config;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * Durid 配置
 * @author SkyEgine
 */
@Configuration
@Data
public class DuridConfig {
	@Value("${spring.datasource.druid.filters}")
	private String filters ;
	@Value("${spring.datasource.druid.exceptionSorter}")
	private String exceptionSorter;
	/**
	 * @return DruidDataSource
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DruidDataSource dataSource() {

		DruidDataSource dataSource = new DruidDataSource();
		try {
			System.out.println(filters);
			dataSource.setFilters(filters);
			dataSource.setExceptionSorter(exceptionSorter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSource;
	}


}

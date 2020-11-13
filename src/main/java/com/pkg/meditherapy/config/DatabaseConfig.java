package com.pkg.meditherapy.config;

import java.io.InputStream;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DatabaseConfig {
//	@Bean
//	ConfigurationCustomizer coreMybatisConfigurationCustomizer() {
//		return new ConfigurationCustomizer() {
//			@Override
//			public void customize(org.apache.ibatis.session.Configuration configuration) {
//				try {
//					configuration.getTypeAliasRegistry().registerAliases("com.pkg.meditherapy.coupon.model");
//					String[] mapperResources = { "sql/coupon-mapper.xml" };
//					for (String resource : mapperResources) {
//						InputStream inputStream = Resources.getResourceAsStream(resource);
//						XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
//						ErrorContext.instance().resource(resource);
//						mapperParser.parse();
//					}
//				} catch (Exception e) {
//					System.out.println("### Mybatis Loading Error ### : " + e);
//				}
//			}
//		};
//	}
}

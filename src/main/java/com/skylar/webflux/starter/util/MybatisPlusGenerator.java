package com.skylar.webflux.starter.util;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * @author SkyEgine
 */
public class MybatisPlusGenerator {
	/**
	 * <p>
	 * MySQL 生成演示
	 * </p>
	 */
	public static void main(String[] args) {
		AutoGenerator autoGenerator = new AutoGenerator();
		System.out.println("开始执行==");
		//全局配置
		GlobalConfig globalConfig = new GlobalConfig();
		//自己的项目路径
		globalConfig.setOutputDir("/Users/qianjiaxiang/IdeaWorkSpace/webflux-starter/src/main/java");
		globalConfig.setFileOverride(true);
		globalConfig.setActiveRecord(true);
		// XML 二级缓存
		globalConfig.setEnableCache(false);
		// XML ResultMap
		globalConfig.setBaseResultMap(true);
		// XML columList
		globalConfig.setBaseColumnList(false);
		globalConfig.setAuthor("skylar");
		//生成文件名:
		globalConfig.setXmlName("%sMapper");
		globalConfig.setMapperName("%sMapper");
		globalConfig.setServiceName("%sService");
		globalConfig.setServiceImplName("%sImpl");
		globalConfig.setControllerName("%sController");
		autoGenerator.setGlobalConfig(globalConfig);

		// 数据源配置
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL);
		dataSourceConfig.setTypeConvert(new MySqlTypeConvert() {

			// 自定义数据库表字段类型转换【可选】
			@Override
			public IColumnType processTypeConvert(GlobalConfig gc, String fieldType) {
				System.out.println("转换类型：" + fieldType);
				if (fieldType.toLowerCase().contains("date")) {
					return DbColumnType.DATE;
				}
				if (fieldType.toLowerCase().contains("time")) {
					return DbColumnType.DATE;
				}
				return super.processTypeConvert(gc, fieldType);
			}
		});

		dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
		dataSourceConfig.setUsername("root");
		dataSourceConfig.setPassword("qjx12345");
		dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/testdb?useUnicode=true&characterEncoding=utf8&useSSL=false");
		autoGenerator.setDataSource(dataSourceConfig);

		// 策略配置
		StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setCapitalMode(true);    // 全局大写命名 ORACLE 注意
		// 此处可以修改为您的表前缀
		strategyConfig.setTablePrefix(new String[] { "sys"});
		strategyConfig.setNaming(NamingStrategy.underline_to_camel);
		// 需要生成的表
		strategyConfig.setInclude(new String[] { "sys_user" });
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表
		// 自定义实体父类
		// strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
		// 自定义实体，公共字段
		// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
		// 自定义 mapper 父类
		// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
		// 自定义 service 父类
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// 自定义 service 实现类父类
//		strategyConfig.setSuperServiceImplClass("com.skylar.webflux.starter.service.BaseService");
		// 自定义 controller 父类
		strategyConfig.setSuperControllerClass("com.skylar.webflux.starter.web.BaseController");
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuliderModel(true);
		autoGenerator.setStrategy(strategyConfig);

		// 包配置
		PackageConfig packageConfig = new PackageConfig();
		packageConfig.setParent("com.skylar.webflux.starter");
		packageConfig.setController("web");
		packageConfig.setXml("/mapper");
		autoGenerator.setPackageInfo(packageConfig);
		// 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
		InjectionConfig injectionConfig = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};


		autoGenerator.setCfg(injectionConfig);




		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
		// 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
		// TemplateConfig tc = new TemplateConfig();
		// tc.setController("...");
		// tc.setEntity("...");
		// tc.setMapper("...");
		// tc.setXml("...");
		// tc.setService("...");
		// tc.setServiceImpl("...");
		// 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
		// mpg.setTemplate(tc);

		// 执行生成
		autoGenerator.execute();

		// 打印注入设置【可无】
		System.err.println(autoGenerator.getCfg().getMap().get("abc"));
	}

}

package com.egrid.generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

import com.egrid.generator.dto.GeneratorConfig;
import com.egrid.generator.service.GeneratorService;
import com.egrid.generator.service.impl.GeneratorServiceImpl;

public class TestGenerator {
    
//    @Test
    public void oracle() {
        Properties props =new Properties();
        try {
            String url = "jdbc:oracle:thin:@106.14.174.30:1521:svwuc";
            props.setProperty("user", "vms");
            props.setProperty("password", "vms");
            props.setProperty("remarks", "true"); //设置可以获取remarks信息 
            props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
            Connection conn = DriverManager.getConnection(url, props);
            GeneratorService generatorService = new GeneratorServiceImpl();
            GeneratorConfig config = new GeneratorConfig();
            config.setServiceName("system");//微服务名，用与BasePackagePath组成包名
//          config.setModuleName("transaction");//模块名，无用
            config.setBasePackagePath("com.svw.vms");//包名
            config.setTableName("TT_WHOLESALE_INVOICE");//以;分隔多张表,可使用能配符%做表匹配
//          config.setSchema("vms"); //对应表空间
            config.setTablePrefixOverrides("");//前缀过滤，生成的Java对象名将不包含指定前缀
            generatorService.generate(conn, config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void mysql() {
        Properties props =new Properties();
        try {
            String url = "jdbc:mysql://rm-uf63rll9pbk6hgdm62o.mysql.rds.aliyuncs.com:3306/systemdevdb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            props.setProperty("user", "hryt");
            props.setProperty("password", "Chumi_123");
            props.setProperty("remarks", "true"); //设置可以获取remarks信息 
            props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
            Connection conn = DriverManager.getConnection(url, props);
            GeneratorService generatorService = new GeneratorServiceImpl();
            GeneratorConfig config = new GeneratorConfig();
            config.setServiceName("system");//微服务名，用与BasePackagePath组成包名
//          config.setModuleName("transaction");//模块名，无用
            config.setBasePackagePath("com.exp.ucmp");//包名
            config.setTableName("t_sys_jpush_record;t_sys_jpush_template_config");//以;分隔多张表,可使用能配符%做表匹配
//          config.setSchema("vms"); //对应表空间
            config.setTablePrefixOverrides("t");//前缀过滤，生成的Java对象名将不包含指定前缀
            generatorService.generate(conn, config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

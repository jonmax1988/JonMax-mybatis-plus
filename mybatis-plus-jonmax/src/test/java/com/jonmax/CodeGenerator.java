package com.jonmax;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;


@SpringBootTest
public class CodeGenerator {

    @Test
    public void testDir(){
        String projectRoot = new File("").getAbsoluteFile().getParent();
        System.out.println(projectRoot);
    }

    String projectRoot = new File("E:\\JavaWeb\\JonMax-mybatis-plus\\").getAbsolutePath();
    @Test
    public void codeG() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/jonmax_mybatis_plus?useSSL=false&serverTimezone=UTC",
                        "jonmax",
                        "Kfcs@1234") // 替换为您的密码
                .globalConfig(builder -> {
//                    builder.outputDir(System.getProperty("user.dir") + "/src/main/java") // 设置输出目录
                    builder.outputDir(projectRoot + "\\generated-code") // 设置输出目录
                            .author("Jon Max") // 设置作者
                            .enableSwagger()
                            .disableOpenDir() // 禁用自动打开目录
                            .fileOverride(); // 文件覆盖
                })
                .packageConfig(builder -> {
                    builder.parent("com.jonmax") // 设置父包名
                            .entity("entity")
                            .mapper("mapper")
                            .service("service")
                            .controller("controller");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("tb_user", "tb_orders") // 设置需要生成的表名
                            .addTablePrefix("tb_")
                            .entityBuilder()
                            .enableLombok()
                            .idType(IdType.AUTO)
                            .controllerBuilder()
                                .enableRestStyle() // REST风格
                                .enableHyphenStyle() // 驼峰转连字符
                                .enableHyphenStyle(); // 启用@Slf4j日志;
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
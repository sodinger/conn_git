package com.itwins;

//import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.annotation.PropertySource;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
// 默认加载application.properties配置文件，此处也可以修改成其他配置文件
//@PropertySource(/*encoding="UTF-8", name="application.properties", */
//	value = { "application.properties" })
@ServletComponentScan
@Slf4j
public class Chapter2Application {

	public static void main(String[] args) {
		// 启动springboot方式一
		SpringApplication.run(Chapter2Application.class, args);
		log.info("Chapter2Application服务启动啦...");
		// 启动springboot方式二
		/*SpringApplicationBuilder builder = new SpringApplicationBuilder(Chapter2Application.class);
        //修改Banner的模式为OFF，不加载banner.txt文件内容
        builder.bannerMode(Banner.Mode.OFF).run(args);*/
	}
}

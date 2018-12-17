package com.itwins.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 常用注解介绍
1@Getter/@Setter：可以作用在类上和属性上，
放在类上，会对所有的非静态(non-static)属性生成Getter/Setter方法，
放在属性上，会对该属性生成Getter/Setter方法。并可以指定Getter/Setter方法的访问级别。
2@EqualsAndHashCode ：默认情况下，会使用所有非瞬态(non-transient)和非静态(non-static)字段来生成equals和hascode方法，
也可以指定具体使用哪些属性。 
3@ToString 生成toString方法，默认情况下，会输出类名、所有属性，属性会按照顺序输出，以逗号分割。
4@NoArgsConstructor 无参构造器
5@RequiredArgsConstructor 部分参数构造器
6@AllArgsConstructor 全参构造器
7@Data：包含@ToString\@EqualsAndHashCode\所有属性的@Getter\所有non-final属性的@Setter\@RequiredArgsConstructor的组合，
通常情况下，基本上使用这个注解就足够了。
8@Budilder：可以进行Builder方式初始化。
9@Slf4j：等同于：private final Logger log = LoggerFactory.getLogger(XXX.class);
简直不能更爽了！一般上用在其他java类上
 * @author Administrator
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class LombokDemo {

	String code;
	
	String name;
	
	public static void main(String[] args) {
		LombokDemo demo = new LombokDemo();
		demo.setCode("123");
		demo.setName("zhangsan");
		log.info(demo.toString());
		log.info(demo.getCode());
		log.info(demo.getName());
		demo = new LombokDemo("2000", "jack");
		log.debug(demo.toString());
		
		LombokDemoBuilder builder = builder();
		builder.code("110");
		builder.name("jerry");
		demo = builder.build();
		System.out.println(demo);
	}
	
	// @Builder相当于这个内部类
	/*public static class LombokDemoBuilder {
		
		private String code;
		private String name;
		
		public LombokDemoBuilder code(String code) {
			this.code = code;
			return this;
		}
		public LombokDemoBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public LombokDemo build() {
			return new LombokDemo(code, name);
		}
		
		public String toString() {
			return "LombokDemo.LombokDemoBuilder(code=" + this.code +",name=" + this.name +")";
		}
		
	}*/
	
}


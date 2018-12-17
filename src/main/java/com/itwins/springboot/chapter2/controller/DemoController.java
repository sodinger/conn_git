package com.itwins.springboot.chapter2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Value("${sboot.desc}")
	private String desc;
	
	@Value("${sboot.name}")
	private String name;
	// 访问地址：http://127.0.0.1:8888/chapter-2/sayHello
	@RequestMapping(value="/sayHello", method = {RequestMethod.POST, RequestMethod.GET}, 
//			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
			produces="text/plain;charset=UTF-8")
	public String demo(@RequestParam Map<String, Object> params) throws Exception {
		System.out.println("==========>>>>" + params);
		String demo = "哈哈Hello, SpringBoot!\n";
		demo = "{\"store\":{\"name\":\"京东超市\",\"book\":[{\"category\":\"小说\",\"author\":\"罗贯中\",\"title\":\"三国演义\",\"price\":25.30},{\"category\":\"小说\",\"author\":\"曹雪芹、高鹗\",\"title\":\"红楼梦\",\"price\":66.40,\"isbn\":\"0-666-88888-9\"}],\"bike\":{\"name\":\"哈哈哈\",\"brand\":\"凤凰\",\"color\":\"red\",\"price\":199.95}}}";
		
		demo = "{\"deviceNo\":\"1920078\",\"snapNbr\":\"20180926151321978\",\"roadCode\":\"\",\"driveDirection\":\"铜仁至大兴\",\"lane\":2,\"plateNbr\":\"贵DBQ022\",\"plateType\":\"02\",\"captureTime\":\"2018-09-26 15:13:21.978\",\"vehicleSpeed\":41.0,\"driveMode\":9,\"vehicleLength\":0.0,\"plateColor\":\"2\",\"vehicleType\":\"02\",\"violationBehaviors\":[],\"inspectedVehicles\":[],\"gpsLocationInfo\":\"\",\"imageDescriptions\":[{\"imageIdentity\":{\"deviceNo\":\"1920078\",\"snapNbr\":\"20180926151321978\",\"guid\":\"B79781B2-7879-45AE-A660-703D53916B9A\"},\"snapShotMode\":0,\"frameIndex\":0,\"imageWidth\":2048,\"imageHeight\":1536,\"imageWidthStep\":0,\"format\":10,\"timeStamp\":\"2018-09-26 15:13:21.978\",\"imageDataLength\":379767,\"imageDataCRC\":211567827,\"watermark\":\"\",\"location\":{\"imageServer\":\"192.168.60.13\",\"position\":\"d:\\\\MyPassingVehicleImage.rep:7763529728\"},\"properies\":{\"DAHUA_PicNo\":\"1\"}}],\"extendedProperties\":{\"DataTrack\":\"DHGateWay@2018-09-26 15:13:25\",\"PlateStoreFlag\":\"1\",\"Proxy_Receive\":\"2018-09-26 15:13:25\",\"copilot_safebelt\":\"1\",\"department\":\"铜仁市碧江区交警大队\",\"deviceID\":\"192.168.64.233_37777\",\"imageIndex\":\"0\",\"pilot_safebelt\":\"2\",\"plate_position\":\"848,572,932,593\",\"roadName\":\"铜兴大道灯塔路口北750M  2车道\",\"vehicle_body_color\":\"4\",\"vehicle_body_type\":\"X99\",\"vehicle_logo\":\"DF\",\"ICE2MQ_Receive\":\"2018-09-26 15:13:25\",\"MQ2File_Receive\":\"2018-09-26 15:13:20\",\"image_URLs\":\"F:10.162.170.169,1920078,20180926151321978\",\"File2MQ_Receive\":\"2018-09-26 15:13:16\"}}\r\n" + 
				"";
		
		// 模拟控制层抛出异常
//		throw new CustomException("101", "Sam 错误");
//		throw new Exception("抛出了异常！！！");
		
		return demo;
	}
	
	// 访问地址：http://127.0.0.1:8888/chapter-2/demo
	@RequestMapping(value="/demo", method = {RequestMethod.POST, RequestMethod.GET}, 
//			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
			produces="text/plain;charset=UTF-8")
	public String demo2(@RequestParam Map<String, Object> params) throws Exception {
		System.out.println("==========>>>>" + params);
		String demo = "哈哈Hello, SpringBoot!\n";
		// 模拟控制层抛出异常
//		throw new CustomException("101", "Sam 错误");
//		throw new Exception("抛出了异常！！！");
		
//		return demo;
		return "/views/demo1.jsp";
	}
	
}

/**  
 * All rights Reserved, Designed By www.htdadao.net
 * <p>Title: CreateAgreementDoc.java</p>
 * <p>PackageName: com.example</p>  
 * <p>Description: </p> 
 * @author: 大道科技     
 * @date:   2018年1月25日 下午4:56:18   
 * @version V1.0 
 * @Copyright: 2018 www.htdadao.net Inc. All rights reserved. 
 */ 
package com.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.dadao.vms.datacollector.corejar.utils.GeneralConfigEntity;

/**
 * @author liujian
 * @date 2018年1月25日 下午4:56:18
 */
public class CreateAgreementDoc {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String jsonStr = "[{\"byteMap\":{0:{\"chnName\":\"档位\",\"dictionary\":\"gear\",\"enName\":\"pedal\"}},\"doubleMap\":{},\"floatMap\":{0:{\"accuracy\":2,\"chnName\":\"加速度\",\"deviation\":50,\"enName\":\"acc\",\"rate\":100}},\"gbId\":128,\"intMap\":{},\"longMap\":{},\"mesId\":1,\"mesNameChn\":\"新长征扩展消息\",\"shortMap\":{},\"topic\":\"XVZ4520_128_1\",\"vehicleModel\":\"XVZ4520\"},{\"byteMap\":{0:{\"chnName\":\"档位\",\"dictionary\":\"gear\",\"enName\":\"pedal\"}},\"doubleMap\":{},\"floatMap\":{0:{\"accuracy\":2,\"chnName\":\"加速度\",\"deviation\":50,\"enName\":\"acc\",\"rate\":100}},\"gbId\":128,\"intMap\":{0:{\"chnName\":\"温度\",\"dictionary\":\"temp\",\"enName\":\"temperature\"}},\"longMap\":{},\"mesId\":1,\"mesNameChn\":\"新长征冷链车扩展消息\",\"shortMap\":{},\"topic\":\"XVZ4520_128_1\",\"vehicleModel\":\"XVZ4520\"}]";
		List<GeneralConfigEntity> gceListOut = JSONArray.parseArray(jsonStr, GeneralConfigEntity.class);
		Map<String, List<GeneralConfigEntity>> root = new HashMap<String, List<GeneralConfigEntity>>();
		root.put("extends", gceListOut);
		System.out.println(gceListOut.get(0).getMesId());
		File file= WordGenerator.createDoc(root, "gb");
		
	}
	
	public static void create(List<GeneralConfigEntity> gceListOut) throws IOException{
		// 调用工具类WordGenerator的createDoc方法生成Word文档  
		Map<String, List<GeneralConfigEntity>> root = new HashMap<String, List<GeneralConfigEntity>>();
		root.put("extends", gceListOut);
		System.out.println(gceListOut.get(0).getMesId());
		File file= WordGenerator.createDoc(root, "gb");
	}

}

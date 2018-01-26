/**  
 * All rights Reserved, Designed By www.htdadao.net
 * <p>Title: CreateWord.java</p>
 * <p>PackageName: com.example</p>  
 * <p>Description: </p> 
 * @author: 大道科技     
 * @date:   2018年1月24日 下午7:24:24   
 * @version V1.0 
 * @Copyright: 2018 www.htdadao.net Inc. All rights reserved. 
 */ 
package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dadao.vms.datacollector.corejar.utils.GeneralConfigEntity;

/**
 * @author liujian
 * @date 2018年1月24日 下午7:24:24
 */
public class CreateWord {

	/**
	 * @param args
	 * @throws IOException 
	 */
	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String jsonStr = "{\"exam\": [{\"ecnt\": 4,\"eid\": \"25\",\"options\": [{\"choice\": \"3\",\"option\": \"男\",\"rowratio\": \"75.00%\"}, {\"choice\": \"1\",\"option\": \"女\",\"rowratio\": \"25.00%\"}],\"qno\": \"3\",\"title\": \"你的性别是\",\"types\": \"单选题\"}]}";
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		Map<String, Object> map = null;
		List exams = jsonObject.getJSONArray("exam");
		List<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < exams.size(); i++) {
			map = new HashMap<String, Object>();
			JSONObject exam = (JSONObject) exams.get(i);
			map.put("ecnt", exam.get("ecnt"));
			map.put("eid", exam.get("eid"));
			map.put("qno", exam.get("qno"));
			map.put("title", exam.get("title"));
			map.put("types", exam.get("types"));
			List<Map<String, String>> options = (List) exam.getJSONArray("options");
			List<Map<String, Object>> optionList = new ArrayList<Map<String, Object>>();
			for (Map tempMap : options) {
				Map optionMap = new HashMap<String, Object>();
				optionMap.put("choice", tempMap.get("choice"));
				optionMap.put("option", tempMap.get("option"));
				optionMap.put("rowratio", tempMap.get("rowratio"));
				optionList.add(optionMap);
			}
			map.put("options", optionList);
			arrayList.add(map);
		}

		// 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整  
		// 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了  
		File file = null;
		InputStream fin = null;
		OutputStream out = null;
		try {
			// 调用工具类WordGenerator的createDoc方法生成Word文档  
			Map root = new HashMap<String, Object>();
			root.put("questTitle", "测试word导出");
			root.put("exams", arrayList);
			file = WordGenerator.createDoc(root, "resume");
			
		} finally {
			if (fin != null) {
				fin.close();
			}
			if (out != null) {
				out.close();
			}
			if (file != null) {
				file.delete(); // 删除临时文件  
			}
		}
		
	}*/
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String jsonStr = "[{\"byteMap\":{0:{\"chnName\":\"档位\",\"dictionary\":\"gear\",\"enName\":\"pedal\"}},\"doubleMap\":{},\"floatMap\":{0:{\"accuracy\":2,\"chnName\":\"加速度\",\"deviation\":50,\"enName\":\"acc\",\"rate\":100}},\"gbId\":128,\"intMap\":{},\"longMap\":{},\"mesId\":1,\"mesNameChn\":\"新长征扩展消息\",\"shortMap\":{},\"topic\":\"XVZ4520_128_1\",\"vehicleModel\":\"XVZ4520\"},{\"byteMap\":{0:{\"chnName\":\"档位\",\"dictionary\":\"gear\",\"enName\":\"pedal\"}},\"doubleMap\":{},\"floatMap\":{0:{\"accuracy\":2,\"chnName\":\"加速度\",\"deviation\":50,\"enName\":\"acc\",\"rate\":100}},\"gbId\":128,\"intMap\":{0:{\"chnName\":\"温度\",\"dictionary\":\"temp\",\"enName\":\"temperature\"}},\"longMap\":{},\"mesId\":1,\"mesNameChn\":\"新长征冷链车扩展消息\",\"shortMap\":{},\"topic\":\"XVZ4520_128_1\",\"vehicleModel\":\"XVZ4520\"}]";
		List<GeneralConfigEntity> gceListOut = JSONArray.parseArray(jsonStr, GeneralConfigEntity.class);
		/*Map<String, Object> map = null;
		List exams = jsonObject.getJSONArray("exam");
		List<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < exams.size(); i++) {
			map = new HashMap<String, Object>();
			JSONObject exam = (JSONObject) exams.get(i);
			map.put("ecnt", exam.get("ecnt"));
			map.put("eid", exam.get("eid"));
			map.put("qno", exam.get("qno"));
			map.put("title", exam.get("title"));
			map.put("types", exam.get("types"));
			List<Map<String, String>> options = (List) exam.getJSONArray("options");
			List<Map<String, Object>> optionList = new ArrayList<Map<String, Object>>();
			for (Map tempMap : options) {
				Map optionMap = new HashMap<String, Object>();
				optionMap.put("choice", tempMap.get("choice"));
				optionMap.put("option", tempMap.get("option"));
				optionMap.put("rowratio", tempMap.get("rowratio"));
				optionList.add(optionMap);
			}
			map.put("options", optionList);
			arrayList.add(map);
		}*/

		// 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整  
		// 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了  
		File file = null;
		InputStream fin = null;
		OutputStream out = null;
		try {
			// 调用工具类WordGenerator的createDoc方法生成Word文档  
			Map root = new HashMap<String, Object>();
			root.put("extends", gceListOut);
			System.out.println(gceListOut.get(0).getMesId());
			file = WordGenerator.createDoc(root, "resume");
			
		} finally {
			if (fin != null) {
				fin.close();
			}
			if (out != null) {
				out.close();
			}
			/*if (file != null) {
				file.delete(); // 删除临时文件  
			}*/
		}
		
	}

}

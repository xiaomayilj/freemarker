package com.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.akcome.commons.io.file.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private Configuration configuration; //freeMarker configuration

	@Test
	public void testWord() throws IOException, TemplateException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("date", "2017年03月15日");

		List<Map<String, Object>> userLanages = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Map<String, Object> userLanage = new HashMap<>();
			userLanage.put("userName", "userName"+i);
			userLanage.put("lanage", "lanage"+i);
			userLanage.put("aaaa", "aaaa"+i);
			userLanage.put("bbbb", "bbbb"+i);
			userLanages.add(userLanage);
		}
		model.put("userLanages", userLanages);

		Template t = configuration.getTemplate("22.xml"); // freeMarker template
		String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		System.out.println(content);
		FileUtil.save(content.getBytes(), new File("/Users/dongdongshi/22.doc"));
	}

	@Test
	public void testExcel() throws IOException, TemplateException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectId", "11234");
		model.put("loanName", "借款人");
		model.put("projectName", "爱康票票010101");
		model.put("repayMod", "等额本息");
		model.put("loanAmount", 1000000.00);
		model.put("projectTerm", "10个月");
		List<Map<String, Object>> invests = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Map<String, Object> userLanage = new HashMap<>();
			userLanage.put("id", "id"+i);
			userLanage.put("name", "name"+i);
			userLanage.put("amount", 100+i);
			invests.add(userLanage);
		}
		model.put("invests", invests);

		Template t = configuration.getTemplate("44.xml"); // freeMarker template
		String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		System.out.println(content);
		FileUtil.save(content.getBytes(), new File("/Users/dongdongshi/44.xls"));
	}
}

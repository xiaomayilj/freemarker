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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private Configuration configuration; //freeMarker configuration

	@Test
	public void testWord() throws IOException, TemplateException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("date", "2017年03月15日");
		model.put("companyName", "王鹏企业管理");

		model.put("userName", "userName");
		model.put("lanage", "lanage");
		model.put("aaaa", "aaaa");
		model.put("bbbb", "bbbb");

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
		Template t = configuration.getTemplate("docx/zjdgxy/document.xml"); // freeMarker template
		String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		FileUtil.save(content.getBytes(), new File("D:/file/zjdgxy_document.xml"));

		// ZipUtils 是一个工具类，主要用来替换具体可以看github工程
		ZipInputStream zipInputStream = ZipUtils.wrapZipInputStream(new FileInputStream(new File("D:/file/zjdgxy.zip")));
		ZipOutputStream zipOutputStream = ZipUtils.wrapZipOutputStream(new FileOutputStream(new File("D:/file/zjdgxy.docx")));
		String itemname = "word/document.xml";
		ZipUtils.replaceItem(zipInputStream, zipOutputStream, itemname, new FileInputStream(new File("D:/file/zjdgxy_document.xml")));
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

		Template t = configuration.getTemplate("66.xml"); // freeMarker template
		String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		System.out.println(content);
		FileUtil.save(content.getBytes(), new File("d:/66.xls"));
	}
}

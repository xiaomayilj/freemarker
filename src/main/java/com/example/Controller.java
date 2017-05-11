package com.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.akcome.commons.io.file.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by dongdongshi on 2017/3/15.
 */
@RestController
public class Controller {

    @Autowired
    private Configuration configuration; //freeMarker configuration

    @RequestMapping("/test")
    public String test() throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("date", new Date());

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
        return content;
    }

    @RequestMapping("/test2")
    public String test2() throws Exception {
        // 转换模板
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("loanContractNo", "AKJF-LSJY-17030017d");

        List<Map<String, Object>> userLanages = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Map<String, Object> userLanage = new HashMap<>();
            userLanage.put("term", i);
            userLanage.put("date", "2017-05-1"+i);
            userLanage.put("amount", "3000.00"+i);
            userLanages.add(userLanage);
        }
        model.put("repays", userLanages);

        Template template = configuration.getTemplate("docx/repay_detail/document.xml"); // freeMarker template
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        InputStream itemInputStream = new ByteArrayInputStream(content.getBytes());


        // 将模板放入zip,转成docx
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();

            ZipInputStream zipInputStream = ZipUtils.wrapZipInputStream(new FileInputStream(path + "templates/docx/repay_detail/repay_detail.zip"));
            ZipOutputStream zipOutputStream = ZipUtils.wrapZipOutputStream(new FileOutputStream(path + "templates/docx/repay_detail/repay_detail_" + System.currentTimeMillis()+".docx"));
            String itemName = "word/document.xml";

            ZipUtils.replaceItem(zipInputStream, zipOutputStream, itemName, itemInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //

        return content;
    }
}

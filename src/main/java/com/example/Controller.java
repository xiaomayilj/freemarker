package com.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.akcome.commons.io.file.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by dongdongshi on 2017/3/15.
 */
@RestController
public class Controller {

    @Autowired
    private Configuration configuration; //freeMarker configuration

    @RequestMapping("/test")
    public String test() throws IOException, TemplateException {

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

}

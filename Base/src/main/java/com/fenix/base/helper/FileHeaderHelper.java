package com.fenix.base.helper;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FileHeaderHelper {

    private static FileHeaderHelper me;
    private List<String> allowFileHeaders;

    private FileHeaderHelper() {
    }

    public static FileHeaderHelper getInstance() {
        if (me == null) {
            me = new FileHeaderHelper();
        }
        return me;
    }

    public List<String> getAllowFileHeaders() {
        if (allowFileHeaders == null) {
            allowFileHeaders = new ArrayList<String>();
            // 读取资源文件，加入允许的文件头集合
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            String classpathResource = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/allowFileHeader.properties";
            Properties properties = new Properties();
            try {
                Resource[] resources = resolver.getResources(classpathResource);
                for (Resource resource : resources) {
                    properties.load(resource.getInputStream());
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Map.Entry<Object, Object> item : properties.entrySet()) {
                allowFileHeaders.add(item.getValue().toString());
            }
        }
        return allowFileHeaders;
    }
}

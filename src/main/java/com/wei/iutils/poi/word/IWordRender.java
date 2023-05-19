package com.wei.iutils.poi.word;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.wei.iutils.exception.vo.IException;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class IWordRender {

    private String template;

    private Object params;

    private Configure config;

    public IWordRender() {
    }

    public IWordRender template(String template){
        this.template = template;
        return this;
    }

    public IWordRender param(Object params){
        this.params = params;
        return this;
    }

    public IWordRender config(Configure config){
        this.config = config;
        return this;
    }

    public Configure getConfig() {
        return config == null ? Configure.createDefault(): config;
    }

    public void renderAsStream(OutputStream os){
        InputStream is = null;
        try {
            isReady();
            is = new FileInputStream(template);
            if (null == is){
                throw new IException("找不到文件模板");
            }
            XWPFTemplate compile = XWPFTemplate.compile(is, getConfig());
            compile.render(params);
            compile.write(os);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IException("渲染异常");
        }finally {
            IOUtils.closeQuietly(is);
        }
    }

    public void renderAsFile(String outputPath){
        OutputStream os = null;
        try {
            File file = new File(outputPath);
            if (!file.exists()){
                File parentFile = file.getParentFile();
                if (!parentFile.exists()){
                    parentFile.mkdirs();
                }
            }
            os = new FileOutputStream(file);
            renderAsStream(os);
        } catch (Exception e) {
            throw new RuntimeException("渲染失败");
        }finally {
            IOUtils.closeQuietly(os);
        }
    }

    private void isReady(){
        if (null == params){
            throw new IException("参数未准备就绪");
        }
        if (null == template){
            throw new IException("模板未准备就绪");
        }
    }

}

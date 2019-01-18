package org.order.server.common.util;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.MessageFormat;

/**
 * Created by fx on 2019/1/17.
 */
@Component
public class XmlBuilder {

    private final static Logger log= Logger.getLogger(XmlBuilder.class);
    /**
     * 将pojo转换为XML字符串
     * @param object
     * @return
     */
    public String convertToXml(Object object) {
        Writer sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(object.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(object, sw);
            log.debug("XML字符串生成成功！");
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            if(sw != null) {
                try {
                    sw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sw.toString();
    }

    /**
     * 将pojo转换为XML文件
     * @param obj
     * @param savePath
     */
    public  File convertToXmlFile(Object obj,String savePath) {
        File file = null;
        String xmlStr = convertToXml(obj);
        if(xmlStr != null && !"".equals(xmlStr)) {

            file = new File(savePath);
            if(!file.exists() && file.isFile()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(file.isDirectory()) {
                System.out.println(MessageFormat.format("{0}不是有效的文件路径.", savePath));
                return null;
            }

            Writer writer = null;

            try {
                writer = new FileWriter(file);
                writer.write(xmlStr);
                writer.flush();
                log.debug("XML文件生成成功！");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return file;
    }


    /**
     * 将XML文件转换为指定类型的pojo
     * @param clazz
     * @param xmlPath
     * @return
     */
    public  Object xmlFileToObject(Class<?> clazz, String xmlPath) {
        Object xmlObject = null;
        Reader fr = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            fr = new FileReader(xmlPath);
            xmlObject = unmarshaller.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != fr) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return xmlObject;
    }

    /**
     * 将xml解析成对象
     * @param xml
     * @param clazz
     * @param <T>
     * @return
     */
    public  <T> T convertToObject(String xml, Class<T> clazz) {
        T _clazz = null;
        StringReader reader = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new StringReader(xml);
            _clazz = (T) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return _clazz;
    }
}

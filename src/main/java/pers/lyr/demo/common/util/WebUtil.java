package pers.lyr.demo.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author lyr
 * @create 2020/7/30 10:37
 */

public class WebUtil {
    private static Logger log = LoggerFactory.getLogger(WebUtil.class);

    enum RenderType {
        /**
         * JSON类型
         */
        JSON,
        /**
         * 文本类型
         */
        TEXT
    }

    /**
     * 渲染JSON
     *
     * @param resp
     * @param jsonObject
     */
    public static void renderJson(HttpServletResponse resp, Object jsonObject) {

        setResponseType(RenderType.JSON, resp);
        try {
            PrintWriter writer = resp.getWriter();

            writer.println(JSONObject.toJSONString(jsonObject));
        } catch (IOException e) {
            log.warn("出现写入异常@webUtil");
        }
    }

    /**
     * 渲染文本
     *
     * @param response
     * @param text
     */
    public static void renderText(HttpServletResponse response, String text) {
        setResponseType(RenderType.TEXT, response);
        try {
            PrintWriter p = response.getWriter();
            p.println(text);
        } catch (IOException e) {
            log.warn("出现写入异常@webUtil");
        }
    }

    public static void render(HttpServletResponse resp, String outValue, RenderType renderType) {
        setResponseType(renderType, resp);
        try {
            PrintWriter p = resp.getWriter();
            p.println(outValue);
        } catch (IOException e) {
            log.warn("出现写入异常@webUtil");
        }
    }

    private static void setResponseType(RenderType type, HttpServletResponse response) {
        switch (type) {
            case JSON: {
                response.setContentType("application/json; charset=UTF-8");
                break;
            }
            case TEXT: {
                response.setContentType("text/html; charset=UTF-8");
                break;
            }
            default: {

            }
        }
        response.setStatus(200);
    }


    public static <T> T getJson(HttpServletRequest request, Class<T> clazz) {


        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            // if(responseStrBuilder.length()<=0) {
            //     return null;
            // }
            return JSON.parseObject(responseStrBuilder.toString(), clazz);
        } catch (Exception e) {
            log.error("解析json 失败");
        }

        return null;
    }

    public static JSONObject getJson(HttpServletRequest req) {
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(req.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }

            return JSONObject.parseObject(responseStrBuilder.toString());
        } catch (Exception e) {
            log.error("解析json 失败");
        }
        return null;

    }


    public static <T> T getForm(HttpServletRequest request,Class<T> clazz)   {
       try{

           JSONObject map = new JSONObject();
           for (Field field : clazz.getDeclaredFields()) {
               String key = field.getName();
               map.put(key,request.getParameter(key));
           }

           return map.toJavaObject(clazz);
       }catch (Exception ex) {
           log.error("解析 formData 失败 {}",ex.getMessage());
       }
       return null;
    }


}

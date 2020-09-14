package pers.lyr.demo.common.dto;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @create 2020/7/16 18:07
 */

public class ViewObject {
    private Map<Object,Object> model = new HashMap<>();
    private Integer code;
    public ViewObject put(String key,Object value) {
        model.put(key, value);
        return this;
    }
    public static ViewObject of(Object... modelValues) {
        // System.out.println(modelValues);
        ViewObject vo = new ViewObject();
        for(int i=0;i<modelValues.length;i+=2) {
            vo.model.put(modelValues[i],modelValues[i+1]);
        }
        return vo;
    }

    public Map<Object, Object> getModel() {
        return model;
    }

    public void setModel(Map<Object, Object> model) {
        this.model = model;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

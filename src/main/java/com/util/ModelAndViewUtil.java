package com.util;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author CrazyBunQnQ
 */
public class ModelAndViewUtil {
    /**
     * 返回JSP
     */
    public static ModelAndView jsp(String jspPath) {
        return new ModelAndView(jspPath);
    }

    /**
     * result = 1 为正确结果
     * result = 0 错误结果
     */
    public static ModelAndView Json_ok() {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "1");
        return mav;
    }

    public static ModelAndView Json_ok(String message) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "1");
        mav.addObject("mess", message);
        return mav;
    }

    public static ModelAndView Json_ok(String key, Object obj) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "1");
        mav.addObject(key, obj);
        return mav;
    }

    public static ModelAndView Json_ok(List<?> list) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "1");
        mav.addObject("list", list);
        return mav;
    }

    public static ModelAndView Json_ok(Map<String, Object> map) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "1");
        Iterator<Map.Entry<String, Object>> entrySet = map.entrySet().iterator();
        while (entrySet.hasNext()) {
            Map.Entry<String, Object> entry = entrySet.next();
            mav.addObject(entry.getKey(), entry.getValue());
        }
        return mav;
    }

//	public static ModelAndView Json_ok( GridDataModel<?> gdm ){
//		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
//		mav.addObject("result", "1");
//		mav.addObject("total", gdm.getTotal());
//		mav.addObject("rows", gdm.getRows());
//		return mav ;
//	}
//	
//	public static ModelAndView Json_ok( GridDataModel<?> gdm ,String form ){
//		ModelAndView mav = new ModelAndView( new MappingJackson2JsonView());
//		mav.addObject("result", "1");
//		mav.addObject("total", gdm.getTotal());
//		mav.addObject("rows", gdm.getRows());
//		mav.addObject( form , null);
//		return mav ;
//	}

    public static ModelAndView Json_error() {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "0");
        return mav;
    }

    public static ModelAndView Json_error(String message) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "0");
        mav.addObject("mess", message);
        return mav;
    }

    public static ModelAndView Json_error(String message, Integer result) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", result);
        mav.addObject("mess", message);
        return mav;
    }

    public static ModelAndView Json_error2(String message) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "2");
        mav.addObject("mess", message);
        return mav;
    }

    // 返回错误状态2
    public static ModelAndView Json_error2() {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "2");
        return mav;
    }

    public static ModelAndView Json_error(String key, Object obj) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("result", "0");
        mav.addObject(key, obj);
        return mav;
    }

    public static ModelAndView Json_Array(List<?> list) {
        ModelAndView mav = new ModelAndView(new ArrayJsonView());
        mav.addObject("list", list);
        return mav;
    }

}

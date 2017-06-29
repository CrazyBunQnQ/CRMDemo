package com.util;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author CrazyBunQnQ
 * @version 2017/6/29.
 */
public class ArrayJsonView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(
            Map<String, Object> map,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        Collection<?> collect = map.values();
        //只要一个LIST
        if (collect.size() != 1) return;
        List<?> list = (List<?>) collect.toArray()[0];
        PrintWriter out = response.getWriter();
        out.append(RayJsonSpread.toJSONString(list.toArray()));
    }
}

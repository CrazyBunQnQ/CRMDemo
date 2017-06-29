package com.servlet;

import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Log4j
public class VerifyCodeServlet extends HttpServlet {
    /**
     * 验证码宽度
     */
    private int width = 60;
    /**
     * 验证码高度
     */
    private int height = 20;
    /**
     * 验证码个数
     */
    private int codeCount = 4;
    private int x = 0;
    /**
     * 字体高度
     */
    private int fontHeight;
    private int codeY;
    private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        String imgWidth = this.getInitParameter("imgWidth");
        String imgHeight = this.getInitParameter("imgHeight");
        String codeCount = this.getInitParameter("codeCount");

        try {
            if (imgWidth != null && imgWidth.length() != 0) {
                width = Integer.parseInt(imgWidth);
            }

            if (imgWidth != null && imgWidth.length() != 0) {
                height = Integer.parseInt(imgHeight);
            }

            if (imgWidth != null && imgWidth.length() != 0) {
                this.codeCount = Integer.parseInt(codeCount);
            }
        } catch (NumberFormatException e) {
            log.warn("字符串转整数出错，将设置为默认值。");
            width = 60;
            height = 20;
            this.codeCount = 4;
        }

        x = width / (this.codeCount + 1);
        fontHeight = height - 2;
        codeY = height - 4;
    }
}

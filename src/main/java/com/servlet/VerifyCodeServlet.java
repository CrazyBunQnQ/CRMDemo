package com.servlet;

import com.util.Constant;
import lombok.extern.log4j.Log4j;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

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

    public VerifyCodeServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        定义图像对象
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = buffImg.createGraphics();

//        随机数生成器
        Random random = new Random();
//        将图像绘制成白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

//        根据图片大小创建字体
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
//        设置字体
        g.setFont(font);

//        边框
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);

//        干扰线
        g.setColor(Color.BLACK);
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

//        保存验证码
        StringBuffer randomCode = new StringBuffer();
        int red = 0;
        int green = 0;
        int blue = 0;

//        生成验证码
        for (int i = 0; i < codeCount; i++) {
//            随机字符
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
//            随机颜色
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

//            绘制图像
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i + 1) * x, codeY);

//            组合
            randomCode.append(strRand);
        }

//        将验证码存入 session
        HttpSession session = req.getSession();
        session.setAttribute(Constant.CHECK_CODE, randomCode.toString());
        log.info("验证码：" + randomCode.toString());

//        禁止图像缓存
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-cControl", "no-cache");
        resp.setDateHeader("Expires", 0);

        resp.setContentType("image/jpeg");
//        输出图像
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
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

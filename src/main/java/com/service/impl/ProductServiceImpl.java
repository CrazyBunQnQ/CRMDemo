package com.service.impl;

import com.bean.Product;
import com.dao.ProductDao;
import com.service.ProductService;
import com.util.Constant;
import com.util.DataModel;
import com.util.Pager;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @version 2017/7/3.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public DataModel<Product> listProduct(Pager pager, Product product) {
        DataModel<Product> dataModel = new DataModel<Product>();

        int total = productDao.countProduct(product);
        pager.fixPage(total);
        List<Product> rows = productDao.listProductByPage(pager.getFrom(), pager.getPageSize(), product);

        pager.setTotalRecord(total);
        dataModel.setRows(rows);
        dataModel.setPager(pager);
        return dataModel;
    }

    @Override
    public boolean removeProductByIds(Integer[] product_id) {
        return productDao.removeByPrimaryKeys(product_id) > 0;
    }

    @Override
    public boolean saveProduct(Product product) {
        return productDao.insertSelective(product) > 0;
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateByPrimaryKey(product) > 0;
    }

    @Override
    public Product getProductById(Integer edit_id) {
        return productDao.selectByPrimaryKey(edit_id);
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] product_id, Product product, HttpServletResponse response) {
        boolean exportSuccess = false;
        List<Product> list = null;

        switch (exportType) {
            case Constant.EXPORT_ALL:
                list = productDao.listAllProduct();
                break;
            case Constant.EXPORT_PAGE:
                list = productDao.listProductByPage(pager.getFrom(), pager.getPageSize(), product);
                break;
            case Constant.EXPORT_SELECTED:
                if (product_id != null && product_id.length > 0) {
                    list = productDao.listSelectedProduct(product_id);
                }
                break;
            default:
        }

        if (list == null) {
            return exportSuccess;
        }

        //使用 JXL API 导出报表
        WritableWorkbook workbook;
        OutputStream outputStream = null;

        response.setCharacterEncoding("UTF-8");
        //添加请求消息头
        response.setContentType("application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename" + new String("商品列表.xls".getBytes("utf-8"), "iso-8859-1"));
            outputStream = response.getOutputStream();
            workbook = Workbook.createWorkbook(outputStream);
            WritableSheet sheet = workbook.createSheet("商品列表", 0);
            //设置表头（第 0 行）
            sheet.addCell(new Label(0, 0, "商品名称"));
            sheet.addCell(new Label(1, 0, "商品编号"));
            sheet.addCell(new Label(2, 0, "商品类别"));
            sheet.addCell(new Label(3, 0, "型号"));
            sheet.addCell(new Label(4, 0, "规格"));
            sheet.addCell(new Label(5, 0, "尺寸"));
            sheet.addCell(new Label(6, 0, "库存数量"));
            sheet.addCell(new Label(7, 0, "单价"));
            //从第一行开始填充 excele 数据
            int rowIndex = 1;
            for (Product p : list) {
                int colIndex = 0;
                sheet.addCell(new Label(colIndex++, rowIndex, p.getName()));
                sheet.addCell(new Label(colIndex++, rowIndex, p.getCode()));
                sheet.addCell(new Label(colIndex++, rowIndex, p.getProductTypeName()));
                sheet.addCell(new Label(colIndex++, rowIndex, p.getModel()));
                sheet.addCell(new Label(colIndex++, rowIndex, p.getSpec()));
                sheet.addCell(new Label(colIndex++, rowIndex, p.getProductSize()));
                sheet.addCell(new Label(colIndex++, rowIndex, p.getStock() == null ? "-" : String.valueOf(p.getStock())));
                sheet.addCell(new Label(colIndex++, rowIndex, p.getPrice() == null ? "-" : String.valueOf(p.getPrice())));
                rowIndex++;
            }

            workbook.write();
            workbook.close();
            exportSuccess = true;
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码异常");
            e.printStackTrace();
        } catch (IOException e) {
            log.error("输入输出异常");
            e.printStackTrace();
        } catch (RowsExceededException e) {
            log.error("行溢出异常");
            e.printStackTrace();
        } catch (WriteException e) {
            log.error("输入异常");
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                log.error("输出流关闭失败");
                e.printStackTrace();
            }
        }
        return exportSuccess;
    }
}

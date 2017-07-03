package com.service.impl;

import com.bean.ProductType;
import com.dao.ProductTypeDao;
import com.service.ProductTypeService;
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

@Log4j
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public DataModel<ProductType> findList(Pager pager, ProductType productType) {
        DataModel<ProductType> dataModel = new DataModel<>();
        List<ProductType> rows = productTypeDao.findProductTypeByPage(pager.getFrom(), pager.getPageSize(), productType);
        /**
         * 总条数
         */
        int total = productTypeDao.countProductType(productType);
        pager.setTotalRecord(total);
        dataModel.setRows(rows);
        dataModel.setPager(pager);
        return dataModel;
    }

    @Override
    public String findProductTypeStr() {
        List<ProductType> rootProductTypeList = productTypeDao.findRootProductType();
        String str = "";
        for (ProductType root : rootProductTypeList) {
            str += "<option value='" + root.getId() + "'>" + root.getName() + "</option>" + findSubProductTypeStr(root.getId(), "");
        }
        return str;
    }

    /**
     * @param pid  类型的 父id
     * @param nbsp 空格距离
     *
     * @return
     */
    private String findSubProductTypeStr(Integer pid, String nbsp) {
        List<ProductType> subProductTypeList = productTypeDao.findSubProductType(pid);
        String str = "";
        if (subProductTypeList != null && subProductTypeList.size() > 0) {
            nbsp += "&nbsp;&nbsp;";
            for (ProductType sub : subProductTypeList) {
                str += "<option value='" + sub.getId() + "'>" + nbsp + sub.getName() + "<option>";
                str += findSubProductTypeStr(sub.getId(), nbsp);
            }
            return str;
        } else {
            return "";
        }
    }

    @Override
    public boolean saveProductType(ProductType productType) {
        return productTypeDao.insertSelective(productType) > 0;
    }

    @Override
    public ProductType getProductTypeById(Integer productTypeId) {
        return productTypeDao.selectByPrimaryKey(productTypeId);
    }

    @Override
    public boolean updateProductType(ProductType productType) {
        return productTypeDao.updateByPrimaryKey(productType) > 0;
    }

    @Override
    public String removeProductType(Integer[] productType_id) {
        int num = 0;//记录成功删除的数量
        //TODO 超过 2 级会报错？
        if (productType_id != null && productType_id.length > 0) {
            for (Integer id : productType_id) {
                int subProductTypeNum = productTypeDao.getSubProductTypeNum(id);
                if (subProductTypeNum == 0) {// no sub product type
                    int productNum = productTypeDao.getProductNum(id);
                    if (productNum == 0) {// no product in this type
                        num += productTypeDao.deleteByPrimaryKey(id) > 0 ? 1 : 0;
                    }
                }
            }
        }
        if (num == productType_id.length) {
            return Constant.REMOVE_SUCCESS;
        } else if (num == 0) {
            return Constant.REMOVE_FAILURE;
        } else {
            return Constant.REMOVE_SUCCESS_PART;
        }
    }

    @Override
    public String findTree() {
        List<ProductType> rootList = productTypeDao.findRootProductType();
        StringBuffer selectOptionStr = new StringBuffer("<ul class='simpleTree'><li class='root'><span>根节点</span><ul>");
        if (rootList != null && rootList.size() > 0) {
            for (ProductType productType : rootList) {
                selectOptionStr.append("<li id='" + productType.getId() + "'>" + "<span>" + productType.getName() + "</span>");
                selectOptionStr.append(getTreeStr(productType.getId()));
                selectOptionStr.append("</li>");
            }
        }
        return selectOptionStr.append("</ul></li></ul>").toString();
    }

    private String getTreeStr(int pid) {
        List<ProductType> list = productTypeDao.findSubProductType(pid);
        if (list == null && list.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer("<ul>");
        for (ProductType p : list) {
            sb.append("<li id='" + p.getId() + "'><span>" + p.getName() + "</span>");
            sb.append(getTreeStr(p.getId()));
            sb.append("</li>");
        }
        return sb.append("</ul>").toString();
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] productType_id, ProductType productType, HttpServletResponse response) {
        boolean exportSuccess = false;
        List<ProductType> list = null;
        switch (exportType) {
            case Constant.EXPORT_ALL:
                list = productTypeDao.listAllProductType();
                break;
            case Constant.EXPORT_PAGE:
                list = productTypeDao.findProductTypeByPage(pager.getFrom(), pager.getPageSize(), productType);
                break;
            case Constant.EXPORT_SELECTED:
                if (productType_id != null && productType_id.length > 0) {
                    list = productTypeDao.listSelectedProductType(productType_id);
                }
                break;
            default:
        }
        if (list == null) {
            return exportSuccess;
        }

        //使用 JXL API 导出报表
        WritableWorkbook workbook = null;
        OutputStream outputStream = null;

        response.setCharacterEncoding("UTF-8");
        //添加请求消息头
        response.setContentType("application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment; filename" + new String("商品类别.xls".getBytes("utf-8"), "iso-8859-1"));
            outputStream = response.getOutputStream();
            workbook = Workbook.createWorkbook(outputStream);
            WritableSheet sheet = workbook.createSheet("商品类别", 0);
            //设置表头
            sheet.addCell(new Label(0, 0, "名称"));
            sheet.addCell(new Label(1, 0, "编码"));
            sheet.addCell(new Label(2, 0, "备注"));
            //在第一行第一列添加文字
            int rowIndex = 1;
            //填充 excel 数据
            for (ProductType pt : list) {
                int colIndex = 0;
                sheet.addCell(new Label(colIndex++, rowIndex, pt.getName()));
                sheet.addCell(new Label(colIndex++, rowIndex, pt.getCode()));
                sheet.addCell(new Label(colIndex++, rowIndex, pt.getRemark()));
                rowIndex++;
            }
            workbook.write();
            workbook.close();
            return exportSuccess = true;
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码异常");
            e.printStackTrace();
        } catch (RowsExceededException e) {
            log.error("行溢出异常");
            e.printStackTrace();
        } catch (WriteException e) {
            log.error("输入异常");
            e.printStackTrace();
        } catch (IOException e) {
            log.error("输入输出流异常");
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                log.error("输出流关闭失败");
                e.printStackTrace();
            }
            return exportSuccess;
        }
    }

    public void setProductTypeDao(ProductTypeDao productTypeDao) {
        this.productTypeDao = productTypeDao;
    }
}

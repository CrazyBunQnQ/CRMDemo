package com.service.impl;

import com.bean.GatherWithBLOBs;
import com.dao.GatherDao;
import com.service.GatherService;
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
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class GatherServiceImpl extends BaseServiceImpl<GatherWithBLOBs> implements GatherService {
    @Autowired
    private GatherDao gatherDao;

    @Override
    public GatherWithBLOBs getById(Integer edit_id) {
        return super.baseGetById(gatherDao, edit_id);
    }

    @Override
    public DataModel<GatherWithBLOBs> list(Pager pager, GatherWithBLOBs gather) {
        return super.baseList(gatherDao, pager, gather);
    }

    @Override
    public boolean save(GatherWithBLOBs gather) {
        return super.baseSave(gatherDao, gather);
    }

    @Override
    public boolean update(GatherWithBLOBs gather) {
        return super.baseUpdate(gatherDao, gather);
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, GatherWithBLOBs gather, HttpServletResponse response) {
        boolean exportSuccess = false;
        List<GatherWithBLOBs> list = super.export(gatherDao, exportType, pager, selectedId, gather);
        if (list == null) {
            return exportSuccess;
        }

        WritableWorkbook workbook;
        OutputStream outputStream = null;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");

        try {
            response.setHeader("Content-Disposition", "attachment; filename" + new String("销售单.xls".getBytes("utf-8"), "iso-8859-1"));
            outputStream = response.getOutputStream();
            workbook = Workbook.createWorkbook(outputStream);
            WritableSheet sheet = workbook.createSheet("销售单", 0);

            sheet.addCell(new Label(0, 0, "销售单号"));
            sheet.addCell(new Label(1, 0, "收款日期"));
            sheet.addCell(new Label(2, 0, "客户名称"));
            sheet.addCell(new Label(3, 0, "总金额"));
            sheet.addCell(new Label(4, 0, "经手人"));
            sheet.addCell(new Label(5, 0, "单据状态"));

            int rowIndex = 1;
            for (GatherWithBLOBs bean : list) {
                int colIndex = 0;
                sheet.addCell(new Label(colIndex++, rowIndex, bean.getCode()));
                sheet.addCell(new Label(colIndex++, rowIndex, bean.getPayDateStr()));
                sheet.addCell(new Label(colIndex++, rowIndex, bean.getCusName()));
                sheet.addCell(new Label(colIndex++, rowIndex, bean.getTotal() == null ? "-" : String.valueOf(bean.getTotal())));
                sheet.addCell(new Label(colIndex++, rowIndex, bean.getHandler()));
                sheet.addCell(new Label(colIndex++, rowIndex, bean.getStatus()));
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
                e.printStackTrace();
            }
        }

        return exportSuccess;
    }

    @Override
    public boolean removeByIds(Integer[] selectedId) {
        return super.baseRemoveByIds(gatherDao, selectedId);
    }
}

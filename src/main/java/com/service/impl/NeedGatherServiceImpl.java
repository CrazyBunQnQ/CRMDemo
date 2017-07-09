package com.service.impl;

import com.bean.NeedGather;
import com.dao.NeedGatherDao;
import com.service.NeedGatherService;
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
 * @version 2017/7/9.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class NeedGatherServiceImpl extends BaseServiceImpl<NeedGather> implements NeedGatherService {
    @Autowired
    private NeedGatherDao needGatherDao;

    @Override
    public NeedGather getById(Integer edit_id) {
        return super.baseGetById(needGatherDao, edit_id);
    }

    @Override
    public DataModel<NeedGather> list(Pager pager, NeedGather needGather) {
        return super.baseList(needGatherDao, pager, needGather);
    }

    @Override
    public boolean save(NeedGather needGather) {
        return super.baseSave(needGatherDao, needGather);
    }

    @Override
    public boolean update(NeedGather needGather) {
        return super.baseUpdate(needGatherDao, needGather);
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, NeedGather needGather, HttpServletResponse response) {
        boolean exportSuccess = false;
        List<NeedGather> list = export(needGatherDao, exportType, pager, selectedId, needGather);
        if (list == null) {
            return exportSuccess;
        }

        WritableWorkbook workbook;
        OutputStream outputStream = null;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");

        try {

            response.setHeader("Content-Disposition", "attachment; filename" + new String("应收款项列表.xls".getBytes("utf-8"), "iso-8859-1"));
            outputStream = response.getOutputStream();
            workbook = Workbook.createWorkbook(outputStream);
            WritableSheet sheet = workbook.createSheet("应收款项", 0);

            int colIndex = 0;
            sheet.addCell(new Label(colIndex++, 0, "销售单号"));
            sheet.addCell(new Label(colIndex++, 0, "客户名称"));
            sheet.addCell(new Label(colIndex++, 0, "产生日期"));
            sheet.addCell(new Label(colIndex++, 0, "应收金额"));
            sheet.addCell(new Label(colIndex++, 0, "已收金额"));
            sheet.addCell(new Label(colIndex++, 0, "应收余额"));
            sheet.addCell(new Label(colIndex++, 0, "是否完成"));
            sheet.addCell(new Label(colIndex++, 0, "状态"));

            int rowIndex = 1;
            for (NeedGather g : list) {
                colIndex = 0;
                sheet.addCell(new Label(colIndex++, rowIndex, g.getSaleCode()));
                sheet.addCell(new Label(colIndex++, rowIndex, g.getCusName()));
                sheet.addCell(new Label(colIndex++, rowIndex, g.getCreatetimeStr()));
                sheet.addCell(new Label(colIndex++, rowIndex, g.getTotal() == null ? "-" : String.valueOf(g.getTotal())));
                sheet.addCell(new Label(colIndex++, rowIndex, g.getPayed() == null ? "-" : String.valueOf(g.getPayed())));
                sheet.addCell(new Label(colIndex++, rowIndex, g.getBalance() == null ? "-" : String.valueOf(g.getBalance())));
                sheet.addCell(new Label(colIndex++, rowIndex, g.getOverFlag()));
                sheet.addCell(new Label(colIndex++, rowIndex, g.getOwnerUsrName()));
                sheet.addCell(new Label(colIndex++, rowIndex, g.getStatus()));
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

    @Override
    public boolean removeByIds(Integer[] selectedId) {
        return super.baseRemoveByIds(needGatherDao, selectedId);
    }
}

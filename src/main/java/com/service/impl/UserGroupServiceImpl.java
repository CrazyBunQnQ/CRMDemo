package com.service.impl;

import com.bean.UserGroup;
import com.dao.UserGroupDao;
import com.service.UserGroupService;
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
public class UserGroupServiceImpl extends BaseServiceImpl<UserGroup> implements UserGroupService {
    @Autowired
    private UserGroupDao userGroupDao;

    @Override
    public UserGroup getById(Integer edit_id) {
        return super.baseGetById(userGroupDao, edit_id);
    }

    @Override
    public DataModel<UserGroup> list(Pager pager, UserGroup userGroup) {
        return super.baseList(userGroupDao, pager, userGroup);
    }

    @Override
    public boolean save(UserGroup userGroup) {
        return super.baseSave(userGroupDao, userGroup);
    }

    @Override
    public boolean update(UserGroup userGroup) {
        return super.baseUpdate(userGroupDao, userGroup);
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, UserGroup userGroup, HttpServletResponse response) {
        boolean exportSuccess = false;
        List<UserGroup> list = super.export(userGroupDao, exportType, pager, selectedId, userGroup);
        if (list == null) {
            return exportSuccess;
        }

        WritableWorkbook workbook;
        OutputStream outputStream = null;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");

        try {
            response.setHeader("Content-Disposition", "attachment; filename" + new String("部门列表.xls".getBytes("utf-8"), "iso-8859-1"));
            outputStream = response.getOutputStream();
            workbook = Workbook.createWorkbook(outputStream);
            WritableSheet sheet = workbook.createSheet("部门列表", 0);

            int colIndex = 0;
            sheet.addCell(new Label(colIndex++, 0, "部门名称"));
            sheet.addCell(new Label(colIndex++, 0, "部门负责人"));
            sheet.addCell(new Label(colIndex++, 0, "部门职能"));

            int rowIndex = 1;
            for (UserGroup u : list) {
                colIndex = 0;
                sheet.addCell(new Label(colIndex++, rowIndex, u.getName()));
                sheet.addCell(new Label(colIndex++, rowIndex, u.getPrincipal()));
                sheet.addCell(new Label(colIndex++, rowIndex, u.getIncumbent()));
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
        return super.baseRemoveByIds(userGroupDao, selectedId);
    }
}

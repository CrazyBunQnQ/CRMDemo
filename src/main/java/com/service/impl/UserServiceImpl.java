package com.service.impl;

import com.bean.AccessGroupWithBLOBs;
import com.bean.RoleWithBLOBs;
import com.bean.User;
import com.dao.UserDao;
import com.service.AccessGroupService;
import com.service.RoleService;
import com.service.UserService;
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
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccessGroupService accessGroupService;

    @Override
    public List<AccessGroupWithBLOBs> listAccessGroup() {
        return accessGroupService.listAll();
    }

    @Override
    public User getById(Integer edit_id) {
        return super.baseGetById(userDao, edit_id);
    }

    @Override
    public DataModel<User> list(Pager pager, User user) {
        return super.baseList(userDao, pager, user);
    }

    @Override
    public boolean save(User user) {
        return super.baseSave(userDao, user);
    }

    @Override
    public boolean update(User user) {
        return super.baseUpdate(userDao, user);
    }

    @Override
    public List<RoleWithBLOBs> listRole() {
        return roleService.listAll();
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, User user, HttpServletResponse response) {
        boolean exportSuccess = false;
        List<User> list = export(userDao, exportType, pager, selectedId, user);
        if (list == null) {
            return exportSuccess;
        }

        WritableWorkbook workbook;
        OutputStream outputStream = null;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");

        try {
            response.setHeader("Content-Disposition", "attachment; filename" + new String("人员列表.xls".getBytes("utf-8"), "iso-8859-1"));
            outputStream = response.getOutputStream();
            workbook = Workbook.createWorkbook(outputStream);
            WritableSheet sheet = workbook.createSheet("人员列表", 0);

            int colIndex = 0;
            sheet.addCell(new Label(colIndex++, 0, "用户名"));
            sheet.addCell(new Label(colIndex++, 0, "中文名"));
            sheet.addCell(new Label(colIndex++, 0, "操作权限组"));
            sheet.addCell(new Label(colIndex++, 0, "查询权限组"));
            sheet.addCell(new Label(colIndex++, 0, "所属部门"));
            sheet.addCell(new Label(colIndex++, 0, "起始有效期"));
            sheet.addCell(new Label(colIndex++, 0, "终止有效期"));
            sheet.addCell(new Label(colIndex++, 0, "状态"));

            int rowIndex = 1;
            for (User u : list) {
                colIndex = 0;
                sheet.addCell(new Label(colIndex++, rowIndex, u.getName()));
                sheet.addCell(new Label(colIndex++, rowIndex, u.getCnname()));
                sheet.addCell(new Label(colIndex++, rowIndex, u.getRoleName()));
                sheet.addCell(new Label(colIndex++, rowIndex, u.getAccessGroupName()));
                sheet.addCell(new Label(colIndex++, rowIndex, u.getGroupName()));
                sheet.addCell(new Label(colIndex++, rowIndex, u.getBegindateStr()));
                sheet.addCell(new Label(colIndex++, rowIndex, u.getEnddateStr()));
                sheet.addCell(new Label(colIndex++, rowIndex, u.getStatus()));
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
        return super.baseRemoveByIds(userDao, selectedId);
    }

    public User findUser(String name, String password) {
        User user = userDao.findUser(name, password);
        return user;
    }

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(3);
    }

    @Override
    public boolean enableByIds(Integer[] selectedId) {
        return userDao.enableOrDisableByIds(selectedId, true) > 0;
    }

    @Override
    public boolean disableByIds(Integer[] selectedId) {
        return userDao.enableOrDisableByIds(selectedId, false) > 0;
    }
}

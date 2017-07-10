package com.service.impl;

import com.bean.User;
import com.bean.UserGroup;
import com.dao.UserDao;
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

    @Autowired
    private UserDao userDao;

    @Override
    public String getTree() {
        List<UserGroup> rootList = userGroupDao.findRootProductType();
        StringBuffer selectOptionStr = new StringBuffer("<ul class='simpleTree'><li class='root'><span>根节点</span><ul>");
        if (rootList != null && rootList.size() > 0) {
            for (UserGroup userGroup : rootList) {
                selectOptionStr.append("<li id='" + userGroup.getId() + "'>" + "<span>" + userGroup.getName() + "</span>");
                selectOptionStr.append(getTreeStr(userGroup.getId()));
                selectOptionStr.append("</li>");
            }
        }
        return selectOptionStr.append("</ul></li></ul>").toString();
    }

    private String getTreeStr(int pid) {
        List<UserGroup> list = userGroupDao.findSubProductType(pid);
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer("<ul>");
        for (UserGroup userGroup : list) {
            sb.append("<li id='" + userGroup.getId() + "'><span>" + userGroup.getName() + "</span>");
            sb.append(getTreeStr(userGroup.getId()));
            sb.append("</li>");
        }
        return sb.append("</ul>").toString();
    }

    @Override
    public List<User> listUserNotByGroupId(Integer id) {
        return userDao.listUserByGroup(id, false);
    }

    @Override
    public List<User> listUserByGroupId(Integer id) {
        return userDao.listUserByGroup(id, true);
    }

    @Override
    public boolean setUser(Integer groupId, String userIds) {
        String[] idsArr = userIds.split(",");
        Integer[] ids = new Integer[idsArr.length];
        int i = 0;
        for (String s : idsArr) {
            ids[i] = Integer.valueOf(s);
            i++;
        }
        return userDao.updateUsersGroup(groupId, ids) > 0;
    }

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
    public List<UserGroup> listAll() {
        return userGroupDao.listAll();
    }

    @Override
    public boolean removeByIds(Integer[] selectedId) {
        return super.baseRemoveByIds(userGroupDao, selectedId);
    }
}

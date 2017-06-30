package com.service.impl;

import com.bean.ProductType;
import com.dao.ProductTypeDao;
import com.service.ProductTypeService;
import com.util.DataModel;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    public DataModel<ProductType> findList(Pager pager) {
        DataModel<ProductType> dm = new DataModel<ProductType>();
        List<ProductType> rows = productTypeDao.findProductTypeByPage(pager.getFrom(), pager.getPageSize());
        dm.setRows(rows);
        //总条数
        int total = productTypeDao.countProductType();
        pager.setTotalRecord(total);
        dm.setPager(pager);
        return dm;
    }

    /**
     * 拼接类似:
     * <option value='id'>名称
     */
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

    public void setProductTypeDao(ProductTypeDao productTypeDao) {
        this.productTypeDao = productTypeDao;
    }
}

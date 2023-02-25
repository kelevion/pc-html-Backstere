package com.project.demo.controller;

import com.project.demo.entity.IWantToCustomize;
import com.project.demo.service.IWantToCustomizeService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 我要定制：(IWantToCustomize)表控制层
 *
 */
@RestController
@RequestMapping("/i_want_to_customize")
public class IWantToCustomizeController extends BaseController<IWantToCustomize, IWantToCustomizeService> {

    /**
     * 我要定制对象
     */
    @Autowired
    public IWantToCustomizeController(IWantToCustomizeService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(i_want_to_customize_id) AS max FROM "+"`i_want_to_customize`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `customized_goods` INNER JOIN `i_want_to_customize` ON customized_goods.trade_name=i_want_to_customize.trade_name WHERE customized_goods.stock < i_want_to_customize.purchase_quantity AND i_want_to_customize.i_want_to_customize_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"i_want_to_customize"+" WHERE "+"i_want_to_customize_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"库存不足！");
        }
        return success(1);
    }

}

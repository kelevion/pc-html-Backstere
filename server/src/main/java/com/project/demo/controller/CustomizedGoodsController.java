package com.project.demo.controller;

import com.project.demo.entity.CustomizedGoods;
import com.project.demo.service.CustomizedGoodsService;
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
 * 定制商品：(CustomizedGoods)表控制层
 *
 */
@RestController
@RequestMapping("/customized_goods")
public class CustomizedGoodsController extends BaseController<CustomizedGoods, CustomizedGoodsService> {

    /**
     * 定制商品对象
     */
    @Autowired
    public CustomizedGoodsController(CustomizedGoodsService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}

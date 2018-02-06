package com.jftshop.controller.admin;


import com.jftshop.bean.Message;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.ProductCategoryService;
import com.jftshop.util.JFTStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("productCategoryController")
@RequestMapping({"/admin/product_category"})
public class ProductCategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCategoryController.class);

    @GetMapping("/listall")
    @ResponseBody
    public List<Object[]> listAll(ModelMap model)
    {
        List<Object[]> list = this.productCategoryService.listAll();
        return list;
    }

    @PostMapping({"/save"})
    @ResponseBody
    public Message submit( String name, String parentid,
                          HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {

        if ( name == null || name.equals("") )
            return Message.error("shop.common.invalid", new Object[0]);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setId( JFTStringUtils.get32UUID() );
        productCategory.setName( name );



        if ( parentid!=null ){

            ProductCategory parent = productCategoryService.getOne( parentid );

            productCategory.setParent( parent );

        }

        productCategoryService.save( productCategory );

        return   Message.success("shop.SaveProductCategory.success", new Object[0]);

    }

    @Autowired
    ProductCategoryService productCategoryService;

}

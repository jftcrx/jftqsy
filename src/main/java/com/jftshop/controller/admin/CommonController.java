package com.jftshop.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ThinkPad on 2018/1/29.
 */

@Controller("adminCommonController")
@RequestMapping({"/admin"})
public class CommonController {

    private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);

/*
    @RequestMapping(value={"/main"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String main()
    {
        LOG.debug(" ------> /admin/main" );
        return "admin/main";
    }
*/


}

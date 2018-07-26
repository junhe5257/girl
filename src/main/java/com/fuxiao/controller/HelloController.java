package com.fuxiao.controller;

import com.fuxiao.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {

        return "id:" + myId;
        /*return girlProperties.getCupSize() + girlProperties.getAge();*/
    }
}

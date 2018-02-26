package com.example.web;

import com.example.aop.WebLogAspect;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example
{
	
    protected static org.slf4j.Logger logger= LoggerFactory.getLogger(WebLogAspect.class);
    @GetMapping("/first")
    public String home(){
        logger.info("home()--------------->");
        return "zl  happies";
    }
}

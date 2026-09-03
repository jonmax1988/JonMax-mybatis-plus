package com.jonmax.controller;

import com.jonmax.IHiDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiDubboController {
    @DubboReference // 引用dubbo远程服务
    private IHiDubboService hiDubboService;

    @GetMapping("/v1/hi")
    public String sayHi(@RequestParam String msg){
        return hiDubboService.sayHello(msg);
    }
}

package com.jonmax.server;

import com.jonmax.IHiDubboService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HiDubboServiceImpl implements IHiDubboService {
    @Override
    public String sayHello(String msg) {
        return "Hi ~~~ Jon Max success " + msg;
    }
}

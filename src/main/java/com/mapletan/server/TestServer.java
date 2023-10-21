package com.mapletan.server;

import com.mapletan.server.impl.NettyRPCServer;
import com.mapletan.server.impl.SimpleRPCServer;
import com.mapletan.service.BlogService;
import com.mapletan.service.UserService;
import com.mapletan.service.impl.BlogServiceImpl;
import com.mapletan.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mapleTan
 * @Description
 * @date 2022/08/31
 **/
public class TestServer {

    private static String host;
    private static int port;

    static {
        host = "127.0.0.1";
        port = 8899;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
//        Map<String, Object> serviceProvide = new HashMap<>();
//        serviceProvide.put("com.mapletan.service.UserService",userService);
//        serviceProvide.put("com.mapletan.service.BlogService",blogService);

//        ServiceProvider serviceProvider = new ServiceProvider();
        // 这里重用了服务暴露类，顺便在注册中心注册，实际上应分开，每个类做各自独立的事
        ServiceProvider serviceProvider = new ServiceProvider(host, port);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

//        RPCServer RPCServer = new SimpleRPCServer(serviceProvider.getInterfaceProvider());
        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(port);
    }
}

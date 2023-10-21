package com.mapletan.server.impl;

import com.mapletan.server.RPCServer;
import com.mapletan.server.WorkThread;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * @author mapleTan
 * @Description
 *  * 这个实现类代表着java原始的BIO监听模式，来一个任务，就new一个线程去处理
 *  * 处理任务的工作见WorkThread中
 * @date 2022/08/31
 **/

@Slf4j
public class SimpleRPCServer implements RPCServer {
    // 存着服务接口名-> service对象的map
    private Map<String, Object> serviceProvide;

    public SimpleRPCServer(Map<String,Object> serviceProvide) {
        this.serviceProvide = serviceProvide;
    }

    @Override
    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            log.info("服务端启动了");

            while(true){
                Socket socket = serverSocket.accept();
                // 开启一个新线程去处理
                new Thread(new WorkThread(socket,serviceProvide)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("服务器启动失败");
        }
    }

    @Override
    public void stop() {

    }
}

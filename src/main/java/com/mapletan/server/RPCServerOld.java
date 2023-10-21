package com.mapletan.server;

import com.mapletan.common.RPCRequest;
import com.mapletan.common.RPCResponse;
import com.mapletan.service.UserService;
import com.mapletan.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mapleTan
 * @Description
 * @date 2022/08/29
 **/
public class RPCServerOld {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // BIO的方式监听Socket
        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务端启动了");
            // BIO的方式监听Socket
            while(true){
                Socket socket = serverSocket.accept();
                // 开启一个线程去处理
                new Thread(()->{
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                        // 读取客户端传过来的request
                        RPCRequest request = (RPCRequest)ois.readObject();


                        Method method = userService.getClass().getMethod(request.getMethodName(),request.getParamsTypes());
                        // 反射调用对应方法
                        Object invoke = method.invoke(userService, request.getParams());
                        // 封装，写入response对象
                        oos.writeObject(RPCResponse.success(invoke));
                        oos.flush();
                    } catch (IOException | ClassNotFoundException | NoSuchMethodException |
                            InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                        System.out.println("从IO中读取数据错误");
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }
}

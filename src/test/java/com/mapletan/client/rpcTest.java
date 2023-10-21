package com.mapletan.client;

import com.mapletan.client.impl.NettyRPCClient;
import com.mapletan.client.impl.SimpleRPCClient;
import com.mapletan.common.Blog;
import com.mapletan.common.User;
import com.mapletan.service.BlogService;
import com.mapletan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


/**
 * @author mapleTan
 * @Description
 * @date 2022/08/29
 **/

@Slf4j
public class rpcTest {
    @Test
    public void clientTest() {
        // 构建一个使用java Socket/ netty/....传输的客户端
//        RPCClient rpcClient = new NettyRPCClient("127.0.0.1", 8899);
//        RPCClient  simpleRPCClient  = new SimpleRPCClient("127.0.0.1", 8899);

        // 不需传host，port
        RPCClient rpcClient = new NettyRPCClient();
        // 把这个客户端传入代理客户端
        RPCClientProxy rpcClientProxy = new RPCClientProxy(rpcClient);

        while (true){
            try {
                Thread.sleep(10);
                // 代理客户端根据不同的服务，获得一个代理类， 并且这个代理类的方法以或者增强（封装数据，发送请求）
                UserService userService = rpcClientProxy.getProxy(UserService.class);
                // 调用方法
                User userByUserId = userService.getUserByUserId(10);
                log.info("从服务端得到的user为：" + userByUserId);

                User user = User.builder().userName("张三").id(100).sex(true).build();
                Integer integer = userService.insertUserId(user);
                log.info("向服务端插入数据："+integer);

                BlogService blogService = rpcClientProxy.getProxy(BlogService.class);

                Blog blogById = blogService.getBlogById(10000);
                log.info("从服务端得到的blog为：" + blogById);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

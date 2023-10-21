//package com.mapletan.client;
//
//import com.mapletan.common.Blog;
//import com.mapletan.common.User;
//import com.mapletan.service.BlogService;
//import com.mapletan.service.UserService;
//
///**
// * @author mapleTan
// * @Description
// * @date 2022/08/29
// **/
//
//@Deprecated
//public class RPCClientDeprecated {
//    public static void main(String[] args){
//
//        RPCClientProxy RPCClientProxy = new RPCClientProxy("127.0.0.1", 8899);
//        UserService proxy = RPCClientProxy.getProxy(UserService.class);
//
//        // 服务的方法1
//        User userByUserId = proxy.getUserByUserId(10);
//        System.out.println("从服务端得到的user为：" + userByUserId);
//        // 服务的方法2
//        User user = User.builder().userName("张三").id(100).sex(true).build();
//        Integer integer = proxy.insertUserId(user);
//        System.out.println("向服务端插入数据："+integer);
//
//        BlogService blogService = RPCClientProxy.getProxy(BlogService.class);
//        Blog blogById = blogService.getBlogById(10000);
//        System.out.println("从服务端得到的blog为：" + blogById);
//
//    }
//}

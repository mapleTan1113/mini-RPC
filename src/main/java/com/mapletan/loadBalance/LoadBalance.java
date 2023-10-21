package com.mapletan.loadBalance;

/**
 * @author mapleTan
 * @Description
 * @date 2023/03/13
 **/

import java.util.List;

/**
 * 给服务器地址列表，根据不同的负载均衡策略选择一个
 */
public interface LoadBalance {
    String balance(List<String> addressList);
}

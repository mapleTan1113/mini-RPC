package com.mapletan.loadBalance.impl;

/**
 * @author mapleTan
 * @Description
 * @date 2023/03/13
 **/

import com.mapletan.loadBalance.LoadBalance;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

/**
 * 随机负载均衡
 */
@Slf4j
public class RandomLoadBalance implements LoadBalance {
    @Override
    public String balance(List<String> addressList) {

        Random random = new Random();
        int choose = random.nextInt(addressList.size());
        log.info("负载均衡选择了" + choose + "服务器");
        return addressList.get(choose);
    }
}

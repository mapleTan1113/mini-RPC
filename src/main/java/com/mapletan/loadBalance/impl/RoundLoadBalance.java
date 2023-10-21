package com.mapletan.loadBalance.impl;

/**
 * @author mapleTan
 * @Description
 * @date 2023/03/13
 **/

import com.mapletan.loadBalance.LoadBalance;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 轮询负载均衡
 */

@Slf4j
public class RoundLoadBalance implements LoadBalance {
    private int choose = -1;
    @Override
    public String balance(List<String> addressList) {
        choose++;
        choose = choose%addressList.size();
        log.info("负载均衡选择了" + choose + "服务器");
        return addressList.get(choose);
    }
}

package com.mapletan.client;

import com.mapletan.common.RPCRequest;
import com.mapletan.common.RPCResponse;

/**
 * @author mapleTan
 * @Description
 * @date 2023/03/11
 **/
public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}

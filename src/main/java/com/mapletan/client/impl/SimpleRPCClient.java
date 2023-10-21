package com.mapletan.client.impl;

import com.mapletan.client.RPCClient;
import com.mapletan.common.RPCRequest;
import com.mapletan.common.RPCResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author mapleTan
 * @Description
 * @date 2023/03/11
 **/

@Slf4j
@AllArgsConstructor
public class SimpleRPCClient implements RPCClient {

    private String host;
    private int port;

    @Override
    public RPCResponse sendRequest(RPCRequest request) {

        try {
            Socket socket = new Socket(host, port);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            log.info(request.toString());
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            RPCResponse response = (RPCResponse) objectInputStream.readObject();
            log.info(response.toString());

            return response;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}

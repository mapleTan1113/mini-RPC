package com.mapletan.codec;

import lombok.AllArgsConstructor;

/**
 * @author mapleTan
 * @Description
 * @date 2023/03/12
 **/
@AllArgsConstructor
public enum MessageType {

    REQUEST(0),
    RESPONSE(1);

    private int code;

    public int getCode() {
        return code;
    }
}

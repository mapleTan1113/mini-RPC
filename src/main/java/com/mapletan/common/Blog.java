package com.mapletan.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mapleTan
 * @Description
 * @date 2022/08/31
 **/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog implements Serializable {
    private Integer id;
    private Integer useId;
    private String title;

}

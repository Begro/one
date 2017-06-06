package com.liu.dai.entity.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Data
@Setter
@Getter
@AllArgsConstructor
public abstract class BaseInMsg {
    private String toUserName;
    private String fromUserName;
    private Integer createTime;
    private String msgType;
}

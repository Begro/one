package com.liu.dai.entity.menu;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Data
@Getter
@Setter
public final class ClickButton extends Button {
    private String key;
}

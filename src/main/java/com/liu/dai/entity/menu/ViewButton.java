package com.liu.dai.entity.menu;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Data
@Setter
@Getter
public final class ViewButton extends Button {
    private String url;

    public ViewButton() {
        this.type = "view";
    }
}

package com.liu.dai.entity.menu;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Data
@Getter
@Setter
public class ComButton extends Button {
    private List<Button> sub_button = new ArrayList<>();
}

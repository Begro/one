package com.liu.dai.entity.menu;

import com.google.common.collect.Lists;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by liuyan9 on 2017/6/5.
 */
@Data
@Getter
@Setter
public class Menu {

    private List<Button> button = Lists.newArrayList();
}

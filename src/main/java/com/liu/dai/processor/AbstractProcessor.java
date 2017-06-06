package com.liu.dai.processor;

import com.google.common.base.Preconditions;
import com.liu.dai.entity.out.BaseOutMsg;
import com.liu.dai.exception.BussinessException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by liuyan9 on 2017/6/6.
 */
public abstract class AbstractProcessor {
    public void processText(BaseOutMsg outMsg, HttpServletResponse response) {
        Preconditions.checkNotNull(outMsg);
        Preconditions.checkNotNull(response);
        PrintWriter writer = null;
        try {
            response.setHeader("Pragma", "no-cache");    // HTTP/1.0 caches might not implement Cache-Control and might only implement Pragma: no-cache
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");    // 与 contentType 分开设置
            writer = response.getWriter();
            writer.write(outMsg.toXml());
            writer.flush();
        } catch (IOException e) {
            throw new BussinessException.DefaultException(e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}

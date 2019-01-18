package org.order.server.common;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author fx
 * @description
 * @date 2019/1/16
 **/
public class MD5Utils {

    public static String MD5(String source){
        return DigestUtils.md5Hex(source).toUpperCase();
    }

}

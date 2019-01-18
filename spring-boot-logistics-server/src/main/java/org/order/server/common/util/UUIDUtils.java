package org.order.server.common.util;

import java.util.UUID;

/**
 * @author yichen
 * @description
 * @date 2018/5/25
 **/
public class UUIDUtils {

    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}

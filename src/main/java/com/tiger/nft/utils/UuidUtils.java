package com.tiger.nft.utils;

import java.util.UUID;

/**
 * Utility class that handles the uuid stuff.
 * @author xxx
 * @version 1.0
 */
public final class UuidUtils {

    /**
     * 返回一个随机的带有分隔符"-"的36位UUID字符串
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 返回一个随机的没有分隔符"-"的32位UUID字符串
     * @return
     */
    public static String uuidNoDash() {
        return uuid().replaceAll("-", "");
    }
}

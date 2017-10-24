package com.suny.association.utils;

import java.util.UUID;

/**
 * 生成一个随机数的工具
 *
 * @author 孙建荣
 *         2016/12/17 14:02
 */
public class RandomID {
    /**
     * 集群机器数量,值影响生成的额随机数
     */
    private static final Integer CLUSTER_COUNT = 1;
    /**
     * 生成的随机数长度
     */
    private static final Integer RANDOM_NUMBER_LENGTH = 11;

    private static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};


    /**
     * 生成随机的11位数
     *
     * @return 随机数
     */
    public static String generateShortUuid() {
        StringBuilder shortBuilder = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < RANDOM_NUMBER_LENGTH; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuilder.append(chars[x % 0x3E]);
        }
        return shortBuilder.toString();

    }


    public static String getOrderIdByUUId() {
        //最大支持1-9个集群机器部署
        int machineId = CLUSTER_COUNT;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        //有可能是负数
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }

}

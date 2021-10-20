package com.sinc.sepos.internal.common.utils;

import java.io.UnsupportedEncodingException;

public class PosUtil {

    /**
     * DB 조회한 Data를 euc-kr로 변환한다.
     * @param targetString
     * @return String
     * @Author Dana Ryu
     */
    public static String EncodingToKR(String targetString) throws UnsupportedEncodingException {
        if (targetString.isEmpty()) throw new NullPointerException("[PosUtil.EncodingToKR] targetString의 값이 존재하지 않습니다.");
        String returnString = new String(targetString.getBytes("iso-8859-1"), "euc-kr").trim();

        return returnString;
    }

    /**
     * DB insert시 변환하여 값을 저장한다.
     * @param targetString
     * @return String
     * @Author Dana Ryu
     */

    public static String EncodingToEN(String targetString) throws UnsupportedEncodingException {
        if (targetString.isEmpty()) throw new NullPointerException("[PosUtil.EncodingToEN] targetString의 값이 존재하지 않습니다.");
        String returnString = new String(targetString.getBytes("euc-kr"), "iso-8859-1").trim();

        return returnString;
    }

}

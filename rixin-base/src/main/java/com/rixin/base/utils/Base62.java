package com.rixin.base.utils;

/**
 * User: dairan
 * Date: 2015-12-29 13:37
 */
public class Base62 {
    private static final int radix = 62;

    /**
     * 62进制字符
     */
    private static final char[] BASE62_DIGITS = {
            '0','1','2','3','4','5','6','7','8','9',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
    };

    /**
     * 10进制转62进制
     */
    public static String encode(long num) {
        if (num < 1) {
            throw new IllegalArgumentException("num must be greater than 0.");
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(BASE62_DIGITS[(int)(num % radix)]);
            num /= 62;
        }
        return sb.reverse().toString();
    }

    /**
     * 62进制转10进制
     */
    public static long decode(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("str must not be empty.");
        }
        char[] base62Number = str.trim().toCharArray();
        long result = 0;
        int digit;
        int exponent = base62Number.length-1;
        for (int i = 0; i < base62Number.length; i++, exponent--) {
            digit = base62Number[i];
            if(digit > 'Z'){
                result += (digit - 'a' + 36) * Math.pow(radix, exponent);
            } else if (digit > '9'){
                result += (digit - 'A' + 10) * Math.pow(radix, exponent);
            } else {
                result += (digit - '0') * Math.pow(radix, exponent);
            }
        }
        return result;
    }

    /**
     * 生成制定长度的Base62 的随机数
     */
    public static String random(int length){
        if (length < 1) {
            throw new IllegalArgumentException("length must be greater than 0.");
        }

        StringBuilder sb = new StringBuilder();
        while (length-- > 0) {
            sb.append(BASE62_DIGITS[(int)(Math.random()*62)]);
        }
        return sb.toString();
    }
}

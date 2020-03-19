package com.ehualu.data.common.util;

/**
 * @author created by guanchen on 2020/3/18 15:15
 */

import lombok.SneakyThrows;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class AESUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法
    private static final String KEY = "sde@5f988990ff%dfs$r344&df8543*er";

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content) throws Exception {
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
        byte[] byteContent = content.getBytes("utf-8");
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(KEY));// 初始化为加密模式的密码器
        byte[] result = cipher.doFinal(byteContent);// 加密
        return new String(Base64.getEncoder().encode(result));//通过Base64转码返回
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @return
     */
    public static String decrypt(String content) throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(KEY));
        //执行操作
        byte[] result = cipher.doFinal(Base64.getDecoder().decode(content));
        return new String(result, "utf-8");
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String key) throws NoSuchAlgorithmException {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        //AES 要求密钥长度为 128
        kg.init(128, new SecureRandom(key.getBytes()));
        //生成一个密钥
        SecretKey secretKey = kg.generateKey();
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
    }

    @SneakyThrows
    public static void main(String[] args) {

        System.out.println(AESUtil.decrypt("v4vHkJj7Cd0 Xkl9GoVuzQ=="));
        String content = "1564a6*/123";
        System.out.println("content:" + content);
        String s1 = AESUtil.encrypt(content);
        System.out.println("s1:" + s1);
        System.out.println("s2:" + AESUtil.decrypt(s1));

    }

}

package com.stormfives.ocpay.common.util;import com.stormfives.ocpay.common.exception.InvalidArgumentException;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.stereotype.Service;import javax.servlet.http.HttpServletRequest;import java.security.DigestException;/** * Created by luyangjian on 2017/9/26. */@Servicepublic class AESAPIService {    private static Logger logger = LoggerFactory.getLogger(AESAPIService.class);    public String getAESDecodeStr(AesReq aesReq, HttpServletRequest request) throws DigestException, InvalidArgumentException {//        String version = HttpRequestUtil.getVersion(request).toString();//        String platform = HttpRequestUtil.getPlatform(request);        //logger.error("加密的信息：version="+version+" platform="+platform);//        String versionAfterThree = version.substring(version.length() - 3, version.length());//        APIEncryptHelper apiEncryptHelper = new APIEncryptHelper(version, platform);//        String[] aesStr = apiEncryptHelper.decode(aesReq.getValue()).split("&");//AES解密//        if(aesStr==null || aesStr.length!=2){//            throw new InvalidArgumentException("===aes error======"+aesReq.getValue());//        }//        String aesReqStr = aesStr[0];//       String sign = aesStr[1];//       if (!sign.equalsIgnoreCase(Sha1.SHA1(aesReqStr, versionAfterThree, platform)))//判断签名合法//            throw new InvalidArgumentException("===aes sign error======");//        return aesReqStr;        return null;    }}
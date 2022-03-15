package com.core.bin.common.api;

/**
 * @author wang
 * @description: API返回对象接口
 * @date 2022-03-15 15:01
 */
public interface IError {
   /**
    * 返回码
    */
   long getCode();

   /**
    * 返回信息
    */
   String getMsg();
}

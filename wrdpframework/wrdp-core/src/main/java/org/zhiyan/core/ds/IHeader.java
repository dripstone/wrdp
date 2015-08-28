package org.zhiyan.core.ds;

/**
 * @Title: 数据头
 * @Description:
 * @Author:zzy
 * @Since:2015年8月25日
 * @Version:1.1.0
 */
public interface IHeader {
    /**
     * 获取Code码
     * 
     * @return code码
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public String getCode();

    /**
     * 获取消息体
     * 
     * @return IMessage消息体
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public IMessage getMessage();
}

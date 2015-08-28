package org.zhiyan.core.ds;

/**
 * @Title:消息体
 * @Description:
 * @Author:zzy
 * @Since:2015年8月25日
 * @Version:1.1.0
 */
public interface IMessage {
    /**
     * 设置标题
     * 
     * @param title
     *            标题
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setTitle(String title);

    /**
     * 设置内容
     * 
     * @param detail
     *            内容
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setDetail(String detail);

    /**
     * 获取标题
     * 
     * @return
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public String getTitle();

    /**
     * 获取内容
     * 
     * @return
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public String getDetail();
}

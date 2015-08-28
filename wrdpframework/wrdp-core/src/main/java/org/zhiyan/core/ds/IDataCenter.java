package org.zhiyan.core.ds;

/**
 * @Title: 数据中心
 * @Description: 数据结构
 *               {header:{code:0,message:{title:'',detail:''}},body:{parameters:
 *               {},dataStores:{store1:{...},store2:{...}}}}
 * @Author:zzy
 * @Since:2015年8月25日
 * @Version:1.1.0
 */
public interface IDataCenter {
    /**
     * 添加数据头信息
     * 
     * @param header
     *            IHeader数据头对象
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setHeader(IHeader header);

    /**
     * 添加数据体信息
     * 
     * @param body
     *            IBody数据体对象
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setBody(IBody body);

    /**
     * 获取数据头
     * 
     * @return IHeader数据头
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public IHeader getHeader();

    /**
     * 获取数据体
     * 
     * @return IBody数据体
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public IBody getBody();
}

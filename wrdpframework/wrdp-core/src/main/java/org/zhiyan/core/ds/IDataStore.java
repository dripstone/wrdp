package org.zhiyan.core.ds;

/**
 * @Title: 数据存储
 * @Description: 存放数据对象{metaData:{},pageSize:45,pageNumber:1,recordCount:45,
 *               name: 'store1',rowset:[{...},{...}]}
 * @Author:zzy
 * @Since:2015年8月25日
 * @Version:1.1.0
 */
public interface IDataStore {
    /**
     * 设置元数据
     * 
     * @param metaData
     *            元数据
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setMetaData(IMetaData metaData);

    /**
     * 设置分页大小
     * 
     * @param pageSize
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setPageSize(int pageSize);

    /**
     * 设置分页数
     * 
     * @param pageNumber
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setPageNumber(int pageNumber);

    /**
     * 设置总记录数
     * 
     * @param recordCount
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setRecordCount(int recordCount);

    /**
     * 设置数据存储名称
     * 
     * @param name
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setName(String name);

    /**
     * 设置数据集
     * 
     * @param rowSet
     * @Description:
     * @Author:zzy
     * @Since:2015年8月25日
     */
    public void setRowSet(IRowSet rowSet);
}

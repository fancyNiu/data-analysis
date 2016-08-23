package com.huisou.analysis.model.openline;

/**
 * Created by puhui on 2016/8/22.
 */
public class CreditAppCustomerClient {
    /**
     * 唯一标识
     */
    private long id;
    /**
     * 客户id
     */
    private long credit_app_customer_id;
    /**
     * 1安卓2苹果3网站4其他
     */
    private int client_type;
    /**
     * 1未登录2已登录
     */
    private int login_status;
    /**
     * 下载渠道
     */
    private String us;
    /**
     * 手机品牌
     */
    private String cell_phone_type;
    /**
     * 是否启用
     */
    private String is_enable;

    @Override
    public String toString() {
        return "CreditAppCustomerClient{" +
                "id=" + id +
                ", credit_app_customer_id=" + credit_app_customer_id +
                ", client_type=" + client_type +
                ", login_status=" + login_status +
                ", us=" + us +
                ", cell_phone_type=" + cell_phone_type +
                ", is_enable=" + is_enable +
                '}';
    }
}

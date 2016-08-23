package com.huisou.analysis.model.openline;

/**
 * Created by puhui on 2016/8/22.
 */
public class CreditAppCustomer {
    /**
     * 唯一标识
     */
    private long id;
    /**
     * 是否实名认证
     */
    private int Id5;
    /**
     * 是否新app注册
     */
    private int local_source;
    /**
     * 是否OCR认证-正面
     */
    private int is_ocr_obverse;
    /**
     * 是否OCR认证-反面
     */
    private int is_ocr_reverse;
    /**
     * 渠道类型(0：卡牛H5,1：普惠, 2：汽车之家, 3:51信用卡4:微信;5 ;6:钱站)
     */
    private int source;
    /**
     * 定位省
     */
    private String province;
    /**
     * 定位市
     */
    private String city;

    @Override
    public String toString() {
        return "CreditAppCustomer{" +
                "id=" + id +
                ", Id5=" + Id5 +
                ", local_source=" + local_source +
                ", is_ocr_obverse=" + is_ocr_obverse +
                ", is_ocr_reverse=" + is_ocr_reverse +
                ", source=" + source +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

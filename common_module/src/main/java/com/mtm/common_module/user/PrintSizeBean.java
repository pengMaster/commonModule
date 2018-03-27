package com.mtm.common_module.user;


import com.mtm.common_module.utils.ConstantUtils;

public class PrintSizeBean implements java.io.Serializable {

    private String id;
    private String orgCode;
    private String typeSize;
    private String printorcName;
    private String sendAddr;
    private String weishengting;
    private String fayuan;
    private String yinhangdizhi;
    private String yinhang;
    private String qisuqixian;
    private String zhengfu;
    private String printEditFlag;
    private String imgType;

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public String getSendAddr() {
        return sendAddr;
    }

    public void setSendAddr(String sendAddr) {
        this.sendAddr = sendAddr;
    }

    public String getPrintorcName() {
        return printorcName;
    }

    public void setPrintorcName(String printorcName) {
        this.printorcName = printorcName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getTypeSize() {
        return typeSize;
    }

    public void setTypeSize(String typeSize) {
        this.typeSize = typeSize;
    }

    public String getWeishengting() {
        return weishengting;
    }

    public void setWeishengting(String weishengting) {
        this.weishengting = weishengting;
    }

    public String getFayuan() {
        return fayuan;
    }

    public void setFayuan(String fayuan) {
        this.fayuan = fayuan;
    }

    public String getYinhangdizhi() {
        return yinhangdizhi;
    }

    public void setYinhangdizhi(String yinhangdizhi) {
        this.yinhangdizhi = yinhangdizhi;
    }

    public String getYinhang() {
        return yinhang;
    }

    public void setYinhang(String yinhang) {
        this.yinhang = yinhang;
    }

    public String getQisuqixian() {
        return qisuqixian;
    }

    public void setQisuqixian(String qisuqixian) {
        this.qisuqixian = qisuqixian;
    }

    public String getZhengfu() {
        return zhengfu;
    }

    public void setZhengfu(String zhengfu) {
        this.zhengfu = zhengfu;
    }

    public String getPrintEditFlag() {
        //暂时设置为打印文书后不能修改
        return ConstantUtils.PRINT_EDIT_YES;
    }

    public void setPrintEditFlag(String printEditFlag) {
        this.printEditFlag = printEditFlag;
    }

}
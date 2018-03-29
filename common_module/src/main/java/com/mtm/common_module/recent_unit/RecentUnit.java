package com.mtm.common_module.recent_unit;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * @author MtmWp
 * @date 2017-12-1 08:42.
 */
@Entity (nameInDb = "T_RECENT_UNIT")
public class RecentUnit {
    @Id
    private String id;
    //单位Id 不是compId
    private String compId;
    private String compName;
    private String compNo;
    private String compType;
    private String address;
    private String specCode;
    private String specName;
    private String isWzdw;
    private String orgCode;
    private String userId;
    private String licenseEnd;
    private String contact;

    @Generated(hash = 89958769)
    public RecentUnit(String id, String compId, String compName, String compNo,
                      String compType, String address, String specCode, String specName,
                      String isWzdw, String orgCode, String userId, String licenseEnd,
                      String contact) {
        this.id = id;
        this.compId = compId;
        this.compName = compName;
        this.compNo = compNo;
        this.compType = compType;
        this.address = address;
        this.specCode = specCode;
        this.specName = specName;
        this.isWzdw = isWzdw;
        this.orgCode = orgCode;
        this.userId = userId;
        this.licenseEnd = licenseEnd;
        this.contact = contact;
    }

    @Generated(hash = 274511956)
    public RecentUnit() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompNo() {
        return compNo;
    }

    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }

    public String getCompType() {
        return compType;
    }

    public void setCompType(String compType) {
        this.compType = compType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getIsWzdw() {
        return isWzdw;
    }

    public void setIsWzdw(String isWzdw) {
        this.isWzdw = isWzdw;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLicenseEnd() {
        return licenseEnd;
    }

    public void setLicenseEnd(String licenseEnd) {
        this.licenseEnd = licenseEnd;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

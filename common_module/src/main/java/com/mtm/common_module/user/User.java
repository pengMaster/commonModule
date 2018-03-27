package com.mtm.common_module.user;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

@Entity(nameInDb = "T_USER")
public class User implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7786164406492319092L;
    @Id
    private String id;
    @Property(nameInDb = "LOGINNAME")
    private String loginName;
    @Property(nameInDb = "KEYTYPE")
    private String keyType;
    @Property(nameInDb = "KEYID")
    private String keyID;
    @Property(nameInDb = "PASSWORD")
    private String passWord;
    @Property(nameInDb = "USERNAME")
    private String userName;
    @Property(nameInDb = "PHOTONAME")
    private String photoName;
    @Property(nameInDb = "IDCARD")
    private String idCard;
    private String sex;
    private String age;
    private String birthday;
    private String tel;
    private String email;
    @Property(nameInDb = "DEPTID")
    private String deptID;
    @Property(nameInDb = "ORGCODE")
    private String orgCode;
    private String sms;
    private String fastchancl;
    private String post;
    @Property(nameInDb = "POSTLEVEL")
    private String postLevel;
    private String title;
    @Property(nameInDb = "TITLELEVEL")
    private String titleLevel;
    @Property(nameInDb = "MOBILETEL")
    private String mobileTel;
    @Property(nameInDb = "POLITICALLANDSCAPE")
    private String politicalLandscape;
    private String degrees;
    private String education;
    private String graduated;
    private String professional;
    @Property(nameInDb = "COUNTRYCODE")
    private String countryCode;
    @Property(nameInDb = "PROVINCECODE")
    private String provinceCode;
    @Property(nameInDb = "CITYCODE")
    private String cityCode;
    @Property(nameInDb = "DISTRICTCODE")
    private String districtCode;
    @Property(nameInDb = "DEPTNAME")
    private String deptName;
    @Property(nameInDb = "ORGNAME")
    private String orgName;
    @Property(nameInDb = "ISSUPERVISORS")
    private String isSupervisors;
    @Property(nameInDb = "SUPERVISORSNUMBER")
    private String supervisorsNumber;
    @Property(nameInDb = "SUPERVISORSCARDNUMBER")
    private String supervisorsCardNumber;
    private String supervisionYear;
    @Property(nameInDb = "CREATETIME")
    private String createTime;
    @Property(nameInDb = "ISDELETED")
    private String isDeleted;
    @Property(nameInDb = "UPDATETIME")
    private String updateTime;
    @Property(nameInDb = "DELETETIME")
    private String deleteTime;
    @Property(nameInDb = "USERLEVEL")
    private String userLevel;
    private int sort;
    private String speccode;
    @Transient  //标注数据库无该字段
    private PrintSizeBean printSize;


    @Generated(hash = 1333404296)
    public User(String id, String loginName, String keyType, String keyID,
                String passWord, String userName, String photoName, String idCard,
                String sex, String age, String birthday, String tel, String email,
                String deptID, String orgCode, String sms, String fastchancl,
                String post, String postLevel, String title, String titleLevel,
                String mobileTel, String politicalLandscape, String degrees,
                String education, String graduated, String professional,
                String countryCode, String provinceCode, String cityCode,
                String districtCode, String deptName, String orgName,
                String isSupervisors, String supervisorsNumber,
                String supervisorsCardNumber, String supervisionYear, String createTime,
                String isDeleted, String updateTime, String deleteTime,
                String userLevel, int sort, String speccode) {
        this.id = id;
        this.loginName = loginName;
        this.keyType = keyType;
        this.keyID = keyID;
        this.passWord = passWord;
        this.userName = userName;
        this.photoName = photoName;
        this.idCard = idCard;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.tel = tel;
        this.email = email;
        this.deptID = deptID;
        this.orgCode = orgCode;
        this.sms = sms;
        this.fastchancl = fastchancl;
        this.post = post;
        this.postLevel = postLevel;
        this.title = title;
        this.titleLevel = titleLevel;
        this.mobileTel = mobileTel;
        this.politicalLandscape = politicalLandscape;
        this.degrees = degrees;
        this.education = education;
        this.graduated = graduated;
        this.professional = professional;
        this.countryCode = countryCode;
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.districtCode = districtCode;
        this.deptName = deptName;
        this.orgName = orgName;
        this.isSupervisors = isSupervisors;
        this.supervisorsNumber = supervisorsNumber;
        this.supervisorsCardNumber = supervisorsCardNumber;
        this.supervisionYear = supervisionYear;
        this.createTime = createTime;
        this.isDeleted = isDeleted;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.userLevel = userLevel;
        this.sort = sort;
        this.speccode = speccode;
    }

    @Generated(hash = 586692638)
    public User() {
    }


    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getKeyID() {
        return keyID;
    }

    public void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getFastchancl() {
        return fastchancl;
    }

    public void setFastchancl(String fastchancl) {
        this.fastchancl = fastchancl;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostLevel() {
        return postLevel;
    }

    public void setPostLevel(String postLevel) {
        this.postLevel = postLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    public String getPoliticalLandscape() {
        return politicalLandscape;
    }

    public void setPoliticalLandscape(String politicalLandscape) {
        this.politicalLandscape = politicalLandscape;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getIsSupervisors() {
        return isSupervisors;
    }

    public void setIsSupervisors(String isSupervisors) {
        this.isSupervisors = isSupervisors;
    }

    public String getSupervisorsNumber() {
        return supervisorsNumber;
    }

    public void setSupervisorsNumber(String supervisorsNumber) {
        this.supervisorsNumber = supervisorsNumber;
    }

    public String getSupervisorsCardNumber() {
        return supervisorsCardNumber;
    }

    public void setSupervisorsCardNumber(String supervisorsCardNumber) {
        this.supervisorsCardNumber = supervisorsCardNumber;
    }

    public String getSupervisionYear() {
        return supervisionYear;
    }

    public void setSupervisionYear(String supervisionYear) {
        this.supervisionYear = supervisionYear;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getSpeccode() {
        return speccode;
    }

    public void setSpeccode(String speccode) {
        this.speccode = speccode;
    }

    public PrintSizeBean getPrintSize() {
        return printSize;
    }

    public void setPrintSize(PrintSizeBean printSize) {
        this.printSize = printSize;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", keyType='" + keyType + '\'' +
                ", keyID='" + keyID + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userName='" + userName + '\'' +
                ", photoName='" + photoName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", birthday='" + birthday + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", deptID='" + deptID + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", sms='" + sms + '\'' +
                ", fastchancl='" + fastchancl + '\'' +
                ", post='" + post + '\'' +
                ", postLevel='" + postLevel + '\'' +
                ", title='" + title + '\'' +
                ", titleLevel='" + titleLevel + '\'' +
                ", mobileTel='" + mobileTel + '\'' +
                ", politicalLandscape='" + politicalLandscape + '\'' +
                ", degrees='" + degrees + '\'' +
                ", education='" + education + '\'' +
                ", graduated='" + graduated + '\'' +
                ", professional='" + professional + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", orgName='" + orgName + '\'' +
                ", isSupervisors='" + isSupervisors + '\'' +
                ", supervisorsNumber='" + supervisorsNumber + '\'' +
                ", supervisorsCardNumber='" + supervisorsCardNumber + '\'' +
                ", supervisionYear='" + supervisionYear + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleteTime='" + deleteTime + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", sort=" + sort +
                ", speccode='" + speccode + '\'' +
                ", printSize=" + printSize +
                '}';
    }
}
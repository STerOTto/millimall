package com.millinch.mall.account.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@TableName("mall_account")
public class Account implements Serializable {

    @TableId
    private Long id;

    /**
     * 手机号码
     */
    @TableField("mobile_phone")
    private String mobilePhone;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密混淆字符
     */
    private String salt;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * QQ号码
     */
    private Long qq;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 头像图片路径
     */
    private String avatar;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 注册时IP地址
     */
    @TableField("reg_ip")
    private String regIp;

    /**
     * 积分值
     */
    private Integer score;

    private Integer level;

    private Boolean enabled;

    /**
     * 状态：0禁用 1正常
     */
    private Integer status;

    @TableField("create_by")
    private Long createBy;

    @TableField("create_at")
    private Date createAt;

    @TableField("update_by")
    private Long updateBy;

    @TableField("update_at")
    private Date updateAt;

    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取手机号码
     *
     * @return mobile_phone - 手机号码
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置手机号码
     *
     * @param mobilePhone 手机号码
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取加密混淆字符
     *
     * @return salt - 加密混淆字符
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置加密混淆字符
     *
     * @param salt 加密混淆字符
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取个性签名
     *
     * @return signature - 个性签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置个性签名
     *
     * @param signature 个性签名
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * 获取QQ号码
     *
     * @return qq - QQ号码
     */
    public Long getQq() {
        return qq;
    }

    /**
     * 设置QQ号码
     *
     * @param qq QQ号码
     */
    public void setQq(Long qq) {
        this.qq = qq;
    }

    /**
     * 获取邮箱地址
     *
     * @return email - 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取头像图片路径
     *
     * @return avatar - 头像图片路径
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像图片路径
     *
     * @param avatar 头像图片路径
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取注册时IP地址
     *
     * @return reg_ip - 注册时IP地址
     */
    public String getRegIp() {
        return regIp;
    }

    /**
     * 设置注册时IP地址
     *
     * @param regIp 注册时IP地址
     */
    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    /**
     * 获取积分值
     *
     * @return score - 积分值
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置积分值
     *
     * @param score 积分值
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取状态：0禁用 1正常
     *
     * @return status - 状态：0禁用 1正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：0禁用 1正常
     *
     * @param status 状态：0禁用 1正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_by
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * @return create_at
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * @return update_by
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return update_at
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * @param updateAt
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("mobilePhone", mobilePhone).append("username", username).append("nickname", nickname).append("password", password).append("salt", salt).append("signature", signature).append("gender", gender).append("qq", qq).append("email", email).append("avatar", avatar).append("province", province).append("city", city).append("regIp", regIp).append("score", score).append("status", status).append("createBy", createBy).append("createAt", createAt).append("updateBy", updateBy).append("updateAt", updateAt).toString();
    }
}
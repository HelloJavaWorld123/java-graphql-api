package com.example.javagraphqlapi.model.mysql;

import java.util.Date;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
public class AqyProduct {
    private Long id;
    private Date createDate;
    private String delFlag;
    private String remarks;
    private Date updateDate;
    private Integer price;
    private String productName;
    private String productNo;
    private String remark;
    private String suppliers;
    private Long createBy;
    private Long updateBy;
    private Integer activeCodeNumberUsed;
    private Integer activeCodeNumberNotUsed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(String suppliers) {
        this.suppliers = suppliers;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getActiveCodeNumberUsed() {
        return activeCodeNumberUsed;
    }

    public void setActiveCodeNumberUsed(Integer activeCodeNumberUsed) {
        this.activeCodeNumberUsed = activeCodeNumberUsed;
    }

    public Integer getActiveCodeNumberNotUsed() {
        return activeCodeNumberNotUsed;
    }

    public void setActiveCodeNumberNotUsed(Integer activeCodeNumberNotUsed) {
        this.activeCodeNumberNotUsed = activeCodeNumberNotUsed;
    }
}

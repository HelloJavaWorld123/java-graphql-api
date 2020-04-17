package com.example.javagraphqlapi.model.mysql;

import java.util.Date;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
public class AqyCode {
    private long id;
    private String code;
    private String codeStatus;
    private Date createDate;
    private String orderNo;
    private String productNo;
    private String productName;
    private String remark;
    private String suppliers;
    private Date validEnd;
    private Date validStart;
    private Date importStart;
    private Date importEnd;
    private Date validityDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Date getValidEnd() {
        return validEnd;
    }

    public void setValidEnd(Date validEnd) {
        this.validEnd = validEnd;
    }

    public Date getValidStart() {
        return validStart;
    }

    public void setValidStart(Date validStart) {
        this.validStart = validStart;
    }

    public Date getImportStart() {
        return importStart;
    }

    public void setImportStart(Date importStart) {
        this.importStart = importStart;
    }

    public Date getImportEnd() {
        return importEnd;
    }

    public void setImportEnd(Date importEnd) {
        this.importEnd = importEnd;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }
}

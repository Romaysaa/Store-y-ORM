package model.dataAccessLayer.entity;
// Generated Mar 18, 2018 10:53:52 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * ItiStoreYProduct generated by hbm2java
 */
public class ItiStoreYProduct implements java.io.Serializable {

    private Long recid;
    private String name;
    private BigDecimal price;
    private String category;
    private BigDecimal amount;
    private String imgurl;
    private String description;
    private Set itiStoreYProductcarts = new HashSet(0);

    public ItiStoreYProduct() {
    }

    public ItiStoreYProduct(Long recid) {
        this.recid = recid;
    }

    public ItiStoreYProduct(Long recid, String name, BigDecimal price, String category, BigDecimal amount, String imgurl, String description, Set itiStoreYProductcarts) {
        this.recid = recid;
        this.name = name;
        this.price = price;
        this.category = category;
        this.amount = amount;
        this.imgurl = imgurl;
        this.description = description;
        this.itiStoreYProductcarts = itiStoreYProductcarts;
    }

    public Long getRecid() {
        return this.recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getImgurl() {
        return this.imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set getItiStoreYProductcarts() {
        return this.itiStoreYProductcarts;
    }

    public void setItiStoreYProductcarts(Set itiStoreYProductcarts) {
        this.itiStoreYProductcarts = itiStoreYProductcarts;
    }

}

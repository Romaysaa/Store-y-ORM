package model.dataAccessLayer.entity;
// Generated Mar 18, 2018 10:53:52 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * ItiStoreYInterest generated by hbm2java
 */
public class ItiStoreYInterest implements java.io.Serializable {

    private BigDecimal recid;
    private ItiStoreYUser itiStoreYUser;
    private String name;

    public ItiStoreYInterest() {
    }

    public ItiStoreYInterest(BigDecimal recid) {
        this.recid = recid;
    }

    public ItiStoreYInterest(BigDecimal recid, ItiStoreYUser itiStoreYUser, String name) {
        this.recid = recid;
        this.itiStoreYUser = itiStoreYUser;
        this.name = name;
    }

    public BigDecimal getRecid() {
        return this.recid;
    }

    public void setRecid(BigDecimal recid) {
        this.recid = recid;
    }

    public ItiStoreYUser getItiStoreYUser() {
        return this.itiStoreYUser;
    }

    public void setItiStoreYUser(ItiStoreYUser itiStoreYUser) {
        this.itiStoreYUser = itiStoreYUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

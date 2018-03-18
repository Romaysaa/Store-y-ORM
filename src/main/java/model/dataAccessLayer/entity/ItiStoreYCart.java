package model.dataAccessLayer.entity;
// Generated Mar 18, 2018 10:53:52 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * ItiStoreYCart generated by hbm2java
 */
public class ItiStoreYCart implements java.io.Serializable {

    private Long recid;
    private ItiStoreYUser itiStoreYUser;
    private BigDecimal totalsum;
    private Set itiStoreYProductcarts = new HashSet(0);

    public ItiStoreYCart() {
    }

    public ItiStoreYCart(Long recid) {
        this.recid = recid;
    }

    public ItiStoreYCart(Long recid, ItiStoreYUser itiStoreYUser, BigDecimal totalsum, Set itiStoreYProductcarts) {
        this.recid = recid;
        this.itiStoreYUser = itiStoreYUser;
        this.totalsum = totalsum;
        this.itiStoreYProductcarts = itiStoreYProductcarts;
    }

    public Long getRecid() {
        return this.recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public ItiStoreYUser getItiStoreYUser() {
        return this.itiStoreYUser;
    }

    public void setItiStoreYUser(ItiStoreYUser itiStoreYUser) {
        this.itiStoreYUser = itiStoreYUser;
    }

    public BigDecimal getTotalsum() {
        return this.totalsum;
    }

    public void setTotalsum(BigDecimal totalsum) {
        this.totalsum = totalsum;
    }

    public Set getItiStoreYProductcarts() {
        return this.itiStoreYProductcarts;
    }

    public void setItiStoreYProductcarts(Set itiStoreYProductcarts) {
        this.itiStoreYProductcarts = itiStoreYProductcarts;
    }

}

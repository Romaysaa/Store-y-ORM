/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO.impl;

import java.util.List;
import model.dataAccessLayer.entity.ItiStoreYProduct;
import model.dataAccessLayer.DAO.ProductDAOInt;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Eman-PC
 */
public class ProductDAOImpl implements ProductDAOInt {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    static Session session = sessionFactory.openSession();

    /**
     * ******************* add new product *****************
     */
    @Override
    public void addProduct(ItiStoreYProduct product) {
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    /**
     * ******************* delete product *****************
     */
    @Override
    public void deleteProduct(Long id) {
        ItiStoreYProduct product = getProductByID(id);
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.evict(product);
    }

    /**
     * ******************* update product *****************
     */
    @Override
    public void updateProduct(ItiStoreYProduct product) {
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        session.evict(product);
    }

    /**
     * ******************* get product by ID *****************
     */
    @Override
    public ItiStoreYProduct getProductByID(Long id) {
        ItiStoreYProduct product = null;
        Query query = session.createQuery("from ItiStoreYProduct where recid = :recID ");
        query.setParameter("recID", id);
        List<ItiStoreYProduct> list = query.list();

        if (!list.isEmpty()) {
            product = list.get(0);
        }
        session.evict(product);
        return product;
    }

    /**
     * ******************* get all products *****************
     */
    @Override
    public List<ItiStoreYProduct> getProductList() {
        Query query = session.createQuery("from ItiStoreYProduct");
        List<ItiStoreYProduct> list = query.list();

        return list;
    }

    /**
     * ******************* get product Amount *****************
     */
    @Override
    public int productAmount(Long id) {
        int pAmount = -1;
        Query query = session.createQuery("select amount from ItiStoreYProduct where recid = :recID ");
        query.setParameter("recID", id);
        List<Integer> list = query.list();
        if (!list.isEmpty()) {
            pAmount = list.get(0);
        }
        return pAmount;
    }
}

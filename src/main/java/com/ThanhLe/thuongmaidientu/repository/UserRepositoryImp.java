package com.ThanhLe.thuongmaidientu.repository;

import com.ThanhLe.thuongmaidientu.entity.Users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class UserRepositoryImp implements  UserRepository{

    @Autowired
    SessionFactory factory;

    @Override
    public Users findById(Integer id) {
        Session session=factory.getCurrentSession();
        Users entity=session.find(Users.class, id);
        return entity;
    }



    @Override
    public List<Users> findAll() {
        String hql="FROM Users";
        Session session=factory.getCurrentSession();
        TypedQuery<Users> query=session.createQuery(hql,Users.class);
        List<Users> list=query.getResultList();
        return list;
    }

    @Override
    public Users create(Users entity) {
        Session session=factory.getCurrentSession();
        session.save(entity);
        return null;
    }

    @Override
    public void update(Users entity) {
        Session session=factory.getCurrentSession();
        session.update(entity);

    }



    @Override
    public Users delete(Integer id) {
        Session session=factory.getCurrentSession();
        Users entity=session.find(Users.class, id);
        session.delete(entity);
        return entity;
    }

    @Override
    public long getPageCount(int pageSize) {
        String hql="SELECT count(c) FROM Users c";
        Session session=factory.getCurrentSession();
        TypedQuery<Long> query=session.createQuery(hql,Long.class);
        Long rowCount=query.getSingleResult();
        long pageCount= (long) Math.ceil(1.0*rowCount/pageSize);
        return pageCount;
    }

    @Override
    public List<Users> getPage(int pageNo, int pageSize) {
        String hql="FROM Users";
        Session session=factory.getCurrentSession();
        TypedQuery<Users> query=session.createQuery(hql,Users.class);
        query.setFirstResult(pageNo * pageSize);
        query.setMaxResults(pageSize);
        List<Users> list=query.getResultList();
        return list;
    }

}

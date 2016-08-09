package com.starWholesale.hb.dao;

public interface GenericDao<T> {

    public T save(T emp);
    public Boolean delete(T emp);
    public T edit(T emp);
    public T find(Long empId);
}
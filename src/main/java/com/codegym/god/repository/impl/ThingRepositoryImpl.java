package com.codegym.god.repository.impl;

import com.codegym.god.model.Thing;
import com.codegym.god.repository.ThingRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ThingRepositoryImpl implements ThingRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Thing> findAll(){
        TypedQuery<Thing> query = em.createQuery("select c from Thing c", Thing.class);
        return query.getResultList();
    }

    @Override
    public Thing findById(Long id){
        TypedQuery<Thing> query = em.createQuery("select c from Thing c where c.id=:id",Thing.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Thing model){
        if(model.getId() != null){
            em.merge(model);
        }else{
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id){
        Thing thing = findById(id);
        if(thing != null){
            em.remove(thing);
        }
    }
}

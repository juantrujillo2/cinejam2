package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Actor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ActorDaoImp implements ActorDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Actor> getActores() {
        String query = "FROM Actor";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer act_id) {
        Actor actor = entityManager.find(Actor.class, act_id);
        entityManager.remove(actor);
    }

    @Override
    public void registrar(Actor actor) {
        entityManager.merge(actor);
    }
}

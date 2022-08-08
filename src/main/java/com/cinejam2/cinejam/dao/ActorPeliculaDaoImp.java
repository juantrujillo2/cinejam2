package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.ActorPelicula;
import com.cinejam2.cinejam.models.Socio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ActorPeliculaDaoImp implements ActorPeliculaDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<ActorPelicula> getActorPeliculas() {
        String query = "FROM ActorPelicula";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer apl_id) {
        ActorPelicula actorPelicula = entityManager.find(ActorPelicula.class, apl_id);
        entityManager.remove(actorPelicula);
    }

    @Override
    public void registrar(ActorPelicula actorPelicula) {
        entityManager.merge(actorPelicula);
    }
}

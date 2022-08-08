package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Pelicula;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PeliculaDaoImp implements PeliculaDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Pelicula> getPeliculas() {
        String query = "FROM Pelicula";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer pel_id) {
        Pelicula pelicula = entityManager.find(Pelicula.class, pel_id);
        entityManager.remove(pelicula);
    }

    @Override
    public void registrar(Pelicula pelicula) {
        entityManager.merge(pelicula);
    }
}

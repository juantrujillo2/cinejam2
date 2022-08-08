package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Genero;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class GeneroDaoImp implements GeneroDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Genero> getGeneros() {
        String query = "FROM Genero";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer gen_id) {
        Genero genero = entityManager.find(Genero.class, gen_id);
        entityManager.remove(genero);
    }

    @Override
    public void registrar(Genero genero) {
        entityManager.merge(genero);
    }

}

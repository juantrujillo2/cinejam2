package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Sexo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SexoDaoImp implements SexoDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Sexo> getSexos() {
        String query = "FROM Sexo";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer sex_id) {
        Sexo sexo = entityManager.find(Sexo.class, sex_id);
        entityManager.remove(sexo);
    }

    @Override
    public void registrar(Sexo sexo) {
        entityManager.merge(sexo);
    }
}

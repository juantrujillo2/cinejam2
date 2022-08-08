package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Socio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SocioDaoImp implements SocioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Socio> getSocios() {
        String query = "FROM Socio";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer soc_id) {
        Socio socio = entityManager.find(Socio.class, soc_id);
        entityManager.remove(socio);
    }

    @Override
    public void registrar(Socio socio) {
        entityManager.merge(socio);
    }

}

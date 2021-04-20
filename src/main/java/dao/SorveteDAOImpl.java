package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import util.JpaUtil;

public class SorveteDAOImpl implements SorveteDAO {

	public List buscarTodos(Object obj) {
		EntityManager ent = JpaUtil.getEntityManager();
		Query query = ent.createQuery(" from " + obj.getClass().getSimpleName());
		return query.getResultList();
	}

	public void inserir(Object obj) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		ent.merge(obj);
		tx.commit();
		ent.close();
		System.out.println("Inclusão efetuada com sucesso!");

	}

	public void remover(Class classe, Object primaryKey) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		Object obj = ent.find(classe, primaryKey);
		ent.remove(obj);
		tx.commit();
		ent.close();
		System.out.println("Produto removido com sucesso!");

	}
	
}

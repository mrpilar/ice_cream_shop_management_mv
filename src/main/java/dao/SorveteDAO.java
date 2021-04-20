package dao;

import java.util.List;

import entidade.Sorvete;

public interface SorveteDAO {
	
	public List buscarTodos(Object obj);

	public void inserir(Object obj);

	public void remover(Class classe, Object primaryKey);
}

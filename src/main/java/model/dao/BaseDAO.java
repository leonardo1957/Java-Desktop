package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

public interface BaseDAO<T> {
	
	public T salvar(T novaEntidade);
	
	public boolean alterar(T novaEntidade);
	
	public boolean deletar(int id);
	
	public ArrayList<T> consultarTodos();
	
	public T consultarPorId(int id);
	
	public T construirResultSet(ResultSet resultado);

}

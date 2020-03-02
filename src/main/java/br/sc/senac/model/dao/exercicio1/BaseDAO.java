package br.sc.senac.model.dao.exercicio1;


import java.util.ArrayList;

/**
 * 
 * Interface que cont�m os m�todos que todos os DAOs devem implementar.
 * 
 * T � um tipo gen�rico, que indica a classe que implementar� o DAO.
 * 
 * Ex.: para a entidade Pessoa, deve ser criada uma classe PessoaDAO que
 * implementa BaseDAO<Pessoa>.
 * 
 * @author Vilmar C�sar Pereira J�nior
 * @param <T> o tipo da classe de entidade (ou VO) que o DAO implementar�
 * 
 */
public interface BaseDAO<T> {

	/**
	 * Insere um novo registro na tabela de entidade T
	 * 
	 * @param novaEntidade o objeto que cont�m o novo registro que ser� inserido na
	 *                     tabela.
	 * 
	 * @return a novaEntidade salva, agora contendo um id.
	 */
	public T salvar(T novaEntidade);

	/**
	 * Exclui um determinado registro na tabela T, dado a sua chave prim�ria.
	 * 
	 * @param id a chave prim�ria da entidade.
	 * @return true caso excluiu, false caso contr�rio.
	 */
	public boolean excluir(int id);

	/**
	 * Altera um determinado registro na tabela T, dado o objeto escolhido para ser
	 * alterado.
	 * 
	 * @param entidade o objeto que ter� o registro atualizado na tabela T.
	 * @return true caso atualizou, false caso contr�rio.
	 */
	public boolean alterar(T entidade);

	/**
	 * Retorna um objeto do tipo T, dado a sua chave prim�ria.
	 * 
	 * @param id a chave prim�ria do objeto/registro buscado
	 * @return o objeto retornado pela consulta, ou null caso n�o exista registro com o id informado.
	 */
	public T consultarPorId(int id);

	/**
	 * Retorna todos os registros da tabela T
	 * 
	 * @return uma lista de objetos do tipo T.
	 */
	public ArrayList<T> consultarTodos();
}
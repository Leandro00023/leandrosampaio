package leandrosampaio.dao;

import java.util.List;

import leandrosampaio.domain.Profissao;

public interface ProfissaoDao {

	void save(Profissao profissao);

	void update(Profissao profissao);

	void delete(Long id);

	Profissao findById(Long id);

	List<Profissao> findAll();
}

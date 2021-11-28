package leandrosampaio.dao;

import java.util.List;

import leandrosampaio.domain.Cliente;

public interface ClienteDao {

	void save(Cliente cliente);

	void update(Cliente cliente);

	void delete(Long id);

	Cliente findById(Long id);

	List<Cliente> findAll();
}

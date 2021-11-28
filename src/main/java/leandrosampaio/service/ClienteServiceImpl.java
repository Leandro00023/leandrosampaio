package leandrosampaio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leandrosampaio.dao.ClienteDao;
import leandrosampaio.domain.Cliente;

@Service
@Transactional(readOnly = true)
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao dao;

	@Override
	@Transactional(readOnly = false)
	public void salvar(Cliente cliente) {
		dao.save(cliente);

	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Cliente cliente) {
		dao.update(cliente);

	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Override
	public Cliente buscarPorId(Long id) {

		return dao.findById(id);
	}

	@Override
	public List<Cliente> buscarTodos() {

		return dao.findAll();
	}

}

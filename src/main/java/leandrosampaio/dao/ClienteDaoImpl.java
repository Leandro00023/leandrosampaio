package leandrosampaio.dao;

import org.springframework.stereotype.Repository;

import leandrosampaio.domain.Cliente;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao {

}

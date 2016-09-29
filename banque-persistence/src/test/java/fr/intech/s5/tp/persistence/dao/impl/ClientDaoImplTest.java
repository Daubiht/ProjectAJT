package fr.intech.s5.tp.persistence.dao.impl;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.intech.s5.tp.banque.util.exception.BanqueException;
import fr.intech.s5.tp.persistence.dao.ClientDao;
import fr.intech.s5.tp.persistence.model.Client;
import fr.intech.s5.util.*;

public class ClientDaoImplTest extends AbstractDefaultRollbackTestCase {

	@Autowired
	private ClientDao clientDao;
	
	@Test
	public void testAjouterClient() throws BanqueException{
		Client client = ModelHelper.getClient();
	
	
		Long idClient = clientDao.ajouterClient(client);
		getCurrentSession().flush();
		getCurrentSession().clear();
		
		assertNotNull(idClient);
	}
	
	@Test
	public void testRechercherClientParId() throws BanqueException{
		Client client = ModelHelper.getClient();		
		
		Long idClient = clientDao.ajouterClient(client);
		getCurrentSession().flush();
		getCurrentSession().clear();
		
		Client client1 = clientDao.rechercherClientParId(idClient);
		
		assertNotNull(client1);
		assertEquals(idClient.longValue(), client1.getIdClient());
		
		Client client2 = clientDao.rechercherClientParId(222);
		assertNull(client2);
		
	}
	
	@Test
	public void testRechercherTousLesClients() throws BanqueException{
		Client client = ModelHelper.getClient();		
		
		clientDao.ajouterClient(client);
		getCurrentSession().flush();
		getCurrentSession().clear();
		
		List<Client> clients = clientDao.rechercherTousLesClients();
		assertFalse(clients.isEmpty());
		assertEquals(1, clients.size());
		
	}
	
}

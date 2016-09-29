package fr.intech.s5.tp.banque.business.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.intech.s5.tp.banque.impl.BanqueServiceImpl;
import fr.intech.s5.tp.banque.service.BanqueService;
import fr.intech.s5.tp.banque.util.exception.BanqueException;
import fr.intech.s5.tp.persistence.dao.ClientDao;
import fr.intech.s5.tp.persistence.dao.CompteDao;
import fr.intech.s5.tp.persistence.model.Client;

public class BanqueServiceImplTest {

	@InjectMocks
	private BanqueService banqueService = new BanqueServiceImpl();
	
	@Mock
	public ClientDao clientDao;
	
	@Mock
	public CompteDao compteDao;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAuthentifier() throws BanqueException {
		Client client = new Client();
		client.setNom("Martin");
		client.setPrenom("Mickeal");
		client.setAdresse("11 rue La Fayette Paris");
		client.setCodePostal(75002);
		client.setPassword("password");
		client.setVille("Paris");
		client.setEmail("m.martin@gmail.com");
		
		Mockito.when(clientDao.rechercherClientparEmail(Mockito.anyString())).thenReturn(client);
		
		Client clientAuth = banqueService.authentifier("m.martin@gmail.com", "password");
		assertNotNull(clientAuth);
		
		Mockito.verify(clientDao).rechercherClientparEmail("m.martin@gmail.com");
		
	}
	
}

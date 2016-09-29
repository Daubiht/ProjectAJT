package fr.intech.s5.tp.persistence.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.intech.s5.tp.banque.util.exception.BanqueException;
import fr.intech.s5.tp.persistence.model.Client;

public interface ClientDao {
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BanqueException.class)
	public Long ajouterClient(Client pclient) throws BanqueException;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public Client rechercherClientParId(long pidClient) throws BanqueException;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public Client rechercherClientparEmail(String pEmail) throws BanqueException;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Client> rechercherTousLesClients() throws BanqueException;
}

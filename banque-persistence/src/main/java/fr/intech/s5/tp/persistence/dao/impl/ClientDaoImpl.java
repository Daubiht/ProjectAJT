package fr.intech.s5.tp.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import fr.intech.s5.tp.banque.util.exception.BanqueException;
import fr.intech.s5.tp.persistence.dao.ClientDao;
import fr.intech.s5.tp.persistence.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientDaoImpl implements ClientDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Long ajouterClient(Client pclient) throws BanqueException {
		Long idClient = null;
		try {
			idClient = (Long) sessionFactory.getCurrentSession().save(pclient);
		}catch(Exception e) {
			throw new BanqueException("Erreur lors de l'enregistrement du client.", e);
		}
		return idClient;
	}

	@Override
	public Client rechercherClientParId(long pidClient) throws BanqueException {
		Client client = null;
		try {
			client = (Client) sessionFactory.getCurrentSession().get(Client.class, new Long(pidClient));
		}catch(Exception e) {
			throw new BanqueException("Erreur lors de la récupération du client.", e);
		}
		return client;
	}

	@Override
	public List<Client> rechercherTousLesClients() throws BanqueException {
		List<Client> listClient = null;
		try {
			String query = "from Client as c";
			listClient = sessionFactory.getCurrentSession().createQuery(query).getResultList();
		}catch(Exception e) {
			throw new BanqueException("Erreur d'obtention de la liste des clients.", e );
		}
		return listClient;
	}

}

package fr.intech.s5.tp.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.intech.s5.tp.banque.util.exception.BanqueException;
import fr.intech.s5.tp.persistence.dao.CompteDao;
import fr.intech.s5.tp.persistence.model.Client;
import fr.intech.s5.tp.persistence.model.Compte;

public class CompteDaoImpl implements CompteDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Boolean ajouterCompte(Compte pcompte) throws BanqueException {
		try {
			sessionFactory.getCurrentSession().save(pcompte);
		}catch(Exception e) {
			throw new BanqueException("Erreur lors de l'enregistrement du compte.", e);
		}
		return true;
	}

	@Override
	public Compte rechercherCompteParNumero(long pNumeroCompte) throws BanqueException {
		Compte compte = null;
		try {
			compte = (Compte) sessionFactory.getCurrentSession().get(Compte.class, new Long(pNumeroCompte));
		}catch(Exception e) {
			throw new BanqueException("Erreur lors de la récupération du compte.", e);
		}
		return compte;
	}

	@Override
	public List<Compte> rechercherCompteClient(Client pclient) throws BanqueException {
		List<Compte> listCompte = new ArrayList<>();
		try {
			String query = "from compte as c";
			listCompte = sessionFactory.getCurrentSession().createQuery(query).getResultList();
		}catch(Exception e) {
			throw new BanqueException("Erreur d'obtention de la liste des comptes.", e );
		}
		return listCompte;
	}

	@Override
	public Compte modifierCompte(Compte pcompte) throws BanqueException {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(pcompte);
		}catch(Exception e) {
			throw new BanqueException("Erreur lors de la modification du compte.", e );
		}
		
		return pcompte;
	}

}

package fr.intech.s5.tp.banque.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.intech.s5.tp.banque.service.BanqueService;
import fr.intech.s5.tp.banque.util.exception.BanqueException;
import fr.intech.s5.tp.persistence.dao.ClientDao;
import fr.intech.s5.tp.persistence.dao.CompteDao;
import fr.intech.s5.tp.persistence.model.Client;
import fr.intech.s5.tp.persistence.model.Compte;

public class BanqueServiceImpl implements BanqueService {

	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private CompteDao compteDao;
	
	@Override
	public Client authentifier(String pEmail, String pPassword) throws BanqueException {
		try {
			Client client = clientDao.rechercherClientparEmail(pEmail);
			if(null != client && null != client.getPassword() && client.getPassword().equals(pPassword)) {
				return client;
			}
		}catch(Exception e) {
			throw new BanqueException(e);
		}
		return null;
	}

	@Override
	public List<Compte> mesComptes(long pIdClient) throws BanqueException {
		try {
			Client client = clientDao.rechercherClientParId(pIdClient);
			return compteDao.rechercherCompteClient(client);
		}catch(Exception e) {
			throw new BanqueException("Erreur lors de la récupération de vos comptes", e);
		}
	}

	@Override
	public void faireUnVirement(long pNumeroADebiter, long pNumeroACrediter, double pMontant) throws BanqueException {
		try {
			Compte compteADebiter = compteDao.rechercherCompteParNumero(pNumeroADebiter);
			Compte compteACrediter = compteDao.rechercherCompteParNumero(pNumeroADebiter);
			
			compteADebiter.setSolde(compteADebiter.getSolde() - pMontant);
			compteACrediter.setSolde(compteACrediter.getSolde() + pMontant);
			
			compteDao.modifierCompte(compteADebiter);
			compteDao.modifierCompte(compteACrediter);
		}catch(Exception e) {
			throw new BanqueException("Erreur operation de virement", e);
		}
		
	}

}

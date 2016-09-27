package fr.intech.s5.tp.persistence.dao;

import java.util.List;

import fr.intech.s5.tp.banque.util.exception.BanqueException;
import fr.intech.s5.tp.persistence.model.Client;
import fr.intech.s5.tp.persistence.model.Compte;

public interface CompteDao {

	public Boolean ajouterCompte(Compte pcompte) throws BanqueException;
	
	public Compte rechercherCompteParNumero(long pNumeroCompte) throws BanqueException;
	
	public List<Compte> rechercherCompteClient(Client pclient) throws BanqueException;
	
	public Compte modifierCompte(Compte pcompte) throws BanqueException;
	
}

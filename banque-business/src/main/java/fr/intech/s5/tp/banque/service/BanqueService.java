package fr.intech.s5.tp.banque.service;

import java.util.List;

import fr.intech.s5.tp.banque.util.exception.BanqueException;
import fr.intech.s5.tp.persistence.model.Client;
import fr.intech.s5.tp.persistence.model.Compte;

public interface BanqueService {
	
	public Client authentifier(String pEmail, String pPassword) throws BanqueException;
	
	public List<Compte>	mesComptes(long pIdClient) throws BanqueException;
	
	public void faireUnVirement(long pNumeroADebiter, long pNumeroACrediter, double pMontant) throws BanqueException;
	
}

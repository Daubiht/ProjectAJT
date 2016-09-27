package fr.intech.s5.tp.persistence.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id
	@Column(name="numero_compte")
	private long numeroCompte;
	
	@Column(name="solde")
	private double solde;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_client")
	private Client client;
}

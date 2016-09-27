package fr.intech.s5.tp.persistence.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_client")
	private long idClient;
	
	@Column(name="nom", length=255, nullable=false)
	private String nom;
	
	@Column(name="prenom", length=255, nullable=false)
	private String prenom;
	
	@Column(name="adresse", length=255, nullable=false)
	private String adresse;
	
	@Column(name="code_postal", nullable=false)
	private long codePostal;
	
	@Column(name="ville", length=255, nullable=false)
	private String vill;
	
	@Column(name="email", length=255, nullable=false)
	private String email;
	
	@Column(name="password", length=255, nullable=false)
	private String password;
	
}

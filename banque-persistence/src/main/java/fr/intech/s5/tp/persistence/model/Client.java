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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public long getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(long codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
	private String ville;
	
	@Column(name="email", length=255, nullable=false)
	private String email;
	
	@Column(name="password", length=255, nullable=false)
	private String password;

	public String getPassword() {
		return password;
	}	
}

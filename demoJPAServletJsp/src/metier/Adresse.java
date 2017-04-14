package metier;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@NamedQueries({
	@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a"),
	@NamedQuery(name="Adresse.findMot", query="SELECT a FROM Adresse a WHERE a.nomRue LIKE :leMot"),
	})
public class Adresse {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nomRue;
	private String ville;
	private String codePostale;
	
	@Transient
	private String commentaires;
	
	@OneToMany(mappedBy="adresse", fetch=FetchType.LAZY) //on met mappedBy du coté de l'esclave - toujours du coté unique OneToMany- Si on supprime adresse, le contact ne sait plus d'où il vient. 
	private Collection<Contact> contacts; //Si on supprime contact - son adresse peut continue d'exister
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", nomRue=" + nomRue + ", ville=" + ville + ", codePostale=" + codePostale + "]";
	}
	
	
	

}

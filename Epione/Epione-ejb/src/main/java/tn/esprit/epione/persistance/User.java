package tn.esprit.epione.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
public class User implements Serializable {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ; 
	private String firstName ; 
	private String lastName ;
	@Temporal(TemporalType.DATE)
	private Date birthDate ; 
	@Embedded
	private Adresse adresse ; 
	private String phone ; 
	private String email ; 
	private String photo;
	private String login ; 
	private String password ; 
	@Enumerated(EnumType.STRING)
	private Sexe sexe ; 
	@Enumerated(EnumType.STRING)
	private Role role ;
	
	
	
	public User() {
		super();
	}
	
	
	


	public User(String firstName, String lastName, Date birthDate, Adresse adresse, String phone, String email,
			String photo, String login, String password, Sexe sexe, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.adresse = adresse;
		this.phone = phone;
		this.email = email;
		this.photo = photo;
		this.login = login;
		this.password = password;
		this.sexe = sexe;
		this.role = role;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Adresse getAdress() {
		return adresse;
	}
	public void setAdress(Adresse adresse) {
		this.adresse = adresse;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Sexe getSexe() {
		return sexe;
	}
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	} 
	
	
	
	

}

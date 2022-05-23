package one_to_many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FbAccount {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private int id;
	private String email;
	private String password;
	
	@OneToMany
	List<FbPage> fbpage;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<FbPage> getFbpage() {
		return fbpage;
	}

	public void setFbpage(List<FbPage> fbpage) {
		this.fbpage = fbpage;
	}


}

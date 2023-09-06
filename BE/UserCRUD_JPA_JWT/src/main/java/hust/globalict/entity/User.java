package hust.globalict.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user", catalog = "UserManagement", schema = "public")
public class User {
	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_name", length = 255, nullable = false,unique= true)
	private String username;
	
	@Column(name = "password", length = 255, nullable = false,unique= true)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
       name="user_role",
       joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},
       inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")})
    private List<Role> roles;
	
	public User(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username= username; 
		this.password = password ; 
	}
	
}

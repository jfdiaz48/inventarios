package umd.pack.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = ("role"))
public class Role {

	@Id
	@Column(name = ("id"))
	private Integer id;	
	
	@Column(name = ("name"))
	private String name;
	
	
	@Column(name = ("created_at"))
	private Date createdAt;
	
	
	@Column(name = ("created_by"))
	private String createdBy;
	
	
	@Column(name = ("updated_at"))
	private Date updateAt;
	
	
	@Column(name = ("updated_by"))
	private String updatedBy;
	
	@OneToMany(mappedBy="role", targetEntity=User.class)
    @JsonIgnore
    private List<User> listOfUsers;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<User> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(List<User> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}


	
}

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "USERS", schema = "myblog")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
	@NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.login = :login"),
	@NamedQuery(name = "Users.findByPass", query = "SELECT u FROM Users u WHERE u.pass = :pass")})
public class Users implements Serializable {
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "login")
	private Collection<Contacts> contactsCollection;
	@Size(max = 2147483647)
    @Column(name = "NAME")
	private String name;
	@Size(max = 2147483647)
    @Column(name = "ADMIN")
	private String admin;
	@Size(max = 2147483647)
    @Column(name = "REMARKS")
	private String remarks;
	@Column(name = "ID")
	private Integer id;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "login")

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "LOGIN")
	private String login;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PASS")
	private String pass;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usersLogin")
	private Collection<Messages> messagesCollection;
	@OneToMany(mappedBy = "usersLogin")
	private Collection<Groupuser> groupuserCollection;

	public Users() {
	}

	public Users(String login) {
		this.login = login;
	}

	public Users(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@XmlTransient
	public Collection<Messages> getMessagesCollection() {
		return messagesCollection;
	}

	public void setMessagesCollection(Collection<Messages> messagesCollection) {
		this.messagesCollection = messagesCollection;
	}

	@XmlTransient
	public Collection<Groupuser> getGroupuserCollection() {
		return groupuserCollection;
	}

	public void setGroupuserCollection(Collection<Groupuser> groupuserCollection) {
		this.groupuserCollection = groupuserCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (login != null ? login.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Users)) {
			return false;
		}
		Users other = (Users) object;
		if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Users[ login=" + login + " ]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlTransient
	public Collection<Contacts> getContactsCollection() {
		return contactsCollection;
	}

	public void setContactsCollection(Collection<Contacts> contactsCollection) {
		this.contactsCollection = contactsCollection;
	}
}

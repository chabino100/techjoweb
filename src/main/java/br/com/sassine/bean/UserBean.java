package br.com.sassine.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.sassine.dao.UserDao;
import br.com.sassine.entity.User;

@Named
@RequestScoped
public class UserBean {
	
private User user = new User();
	
	public void save() {
		new UserDao().create(this.user);
		System.out.println(this.user);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Registered Successfully"));
	}
	
	public List<User> getUsers(){
		return new UserDao().getAll();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

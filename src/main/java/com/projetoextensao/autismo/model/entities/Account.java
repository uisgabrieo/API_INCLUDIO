package com.projetoextensao.autismo.model.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

@Document(collection = "accounts")
public class Account implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String completeName;
	private String email;
	private String password;
	private TypeAccount account;
	
	public Account( String completeName, String email, String password, TypeAccount account) {
		this.completeName = completeName;
		this.email = email;
		this.password = password;
		this.account = account;
	}

	public Account() {
		
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
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

	public TypeAccount getAccount() {
		return account;
	}

	public void setAccount(TypeAccount account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(getAccount().equals(TypeAccount.EMPLOYER)) 
			return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYER"), new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
		return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getCompleteName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}

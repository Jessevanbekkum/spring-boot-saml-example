package com.xebia.saml.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class User implements UserDetails {

  private final String username;
  private final String email;
  private final String givenName;
  private final String familyName;
  private final List<GrantedAuthority> authorities = new ArrayList<>();

  public User(String username, String email, String givenName, String familyName, Collection<GrantedAuthority> authorities) {
    this.username = username;
    this.email = email;
    this.givenName = givenName;
    this.familyName = familyName;
    this.authorities.addAll(authorities);
  }

  public String getEmail() {
    return email;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.unmodifiableList(authorities);
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public String getGivenName() {
    return givenName;
  }

  public String getFamilyName() {
    return familyName;
  }
}

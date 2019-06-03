package com.jade.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

/**
 * Users
 */
@Entity
@Table(name = "Users", uniqueConstraints={@UniqueConstraint(columnNames = {"id"}), @UniqueConstraint(columnNames = {"email"})})
public class User {

  @Id
  @GenericGenerator(name = "i_ID", strategy = "com.jade.api.utils.helpers.GenericIDGenerator")
  @GeneratedValue(generator = "i_ID")
  @Column(name = "id", unique = true, nullable = false)
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private boolean isActive;

  public User() {

  }

  public User(String id, String firstName, String lastName, String email, String password, String isActive) {
    this.setId(id);
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setEmail(email);
    this.setPassword(password);
    this.setIsActive(false);
    // this.setProfile(profile);
  }

  public void setId(String id) {
    this.id = id;
  }

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public String getId() {
    return id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Column(name = "first_name", nullable = false)
  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "email", nullable = false)
  public String getEmail() {
    return email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name = "password", nullable = false)
  public String getPassword() {
    return password;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  @Column(name = "is_active", nullable = false)
  public boolean getIsActive() {
    return isActive;
  }

  // @Column(name = "profile")
  // public void setProfile(Profiles profile) {
  //   this.profile = profile;
  // }

  // public Profiles getProfile() {
  //   return this.profile;
  // }

  @Override
  public String toString() {
    return "User {"
      +firstName+"\n"
      +lastName+"\n"
      +email+"\n"
      +isActive+
      // +profile+
    "}";
  }
}
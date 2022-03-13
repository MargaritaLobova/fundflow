package server;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

  private @Id @GeneratedValue Long id;
  private String login;
  private String password;
  private String role;

  public User() {}

  public User(String login, String password, String role) {
    this.login = login;
    this.password = password;
    this.role = role;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof User user))
      return false;
    return Objects.equals(this.id, user.id) && Objects.equals(this.login, user.login)
        && Objects.equals(this.role, user.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.login, this.role, this.password);
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + this.id + ", name='" + this.login + '\'' + ", role='" + this.role + '\'' + '}';
  }

}

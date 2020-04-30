package service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Email {

  private String email;

  public Email() {
  }

  public String getEmail() {
    return email;
  }

  public void setType(String email) {
    this.email = email;
  }



  @Override
  public String toString() {
    return "Email{" +
        email +
        '}';
  }
}
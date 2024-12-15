package model;
/**
 *
 * @author thega
 */
public class User {
  private int id;
  private String name;
  private String email;
  private String nrp;
  private String noTelp;
  public int getId() { return id; }
  public void setId(int id) { this.id = id; }
  public String getName() { return name; }
  public void setName (String name) { this.name = name; }
  public String getEmail() { return email; }
  public void setEmail (String email) { this.email = email; }

  public String getNrp() { return nrp; }
  public void setNrp(String nrp) { this.nrp = nrp; }

  public String getNoTelp() { return noTelp; }
  public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
}
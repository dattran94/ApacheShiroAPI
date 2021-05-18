package com.example.demo.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserInfoTest {

  private String iss;
  private Integer exp;
  private Integer nbf;
  private String aud;
  private String oid;
  private String sub;
  private String name;
  private String city;
  private List<String> emails;
  private String tfp;
  private String scp;
  private String azp;
  private String ver;
  private Integer iat;

  public UserInfoTest() {
    super();
  }

  public String getIss() {
    return iss;
  }

  public void setIss(String iss) {
    this.iss = iss;
  }

  public Integer getExp() {
    return exp;
  }

  public void setExp(Integer exp) {
    this.exp = exp;
  }

  public Integer getNbf() {
    return nbf;
  }

  public void setNbf(Integer nbf) {
    this.nbf = nbf;
  }

  public String getAud() {
    return aud;
  }

  public void setAud(String aud) {
    this.aud = aud;
  }

  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  public String getSub() {
    return sub;
  }

  public void setSub(String sub) {
    this.sub = sub;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

  public String getTfp() {
    return tfp;
  }

  public void setTfp(String tfp) {
    this.tfp = tfp;
  }

  public String getScp() {
    return scp;
  }

  public void setScp(String scp) {
    this.scp = scp;
  }

  public String getAzp() {
    return azp;
  }

  public void setAzp(String azp) {
    this.azp = azp;
  }

  public String getVer() {
    return ver;
  }

  public void setVer(String ver) {
    this.ver = ver;
  }

  public Integer getIat() {
    return iat;
  }

  public void setIat(Integer iat) {
    this.iat = iat;
  }

  public UserInfoTest(String iss, Integer exp, Integer nbf, String aud, String oid, String sub,
      String name, String city, List<String> emails, String tfp, String scp, String azp, String ver,
      Integer iat) {
    super();
    this.iss = iss;
    this.exp = exp;
    this.nbf = nbf;
    this.aud = aud;
    this.oid = oid;
    this.sub = sub;
    this.name = name;
    this.city = city;
    this.emails = emails;
    this.tfp = tfp;
    this.scp = scp;
    this.azp = azp;
    this.ver = ver;
    this.iat = iat;
  }

}

package model;
// Generated Dec 10, 2021 8:51:35 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Students generated by hbm2java
 */
public class Students  implements java.io.Serializable {


     private Integer id;
     private String fullname;
     private String password;
     private String email;
     private int phone;
     private Set requests = new HashSet(0);
     private Set issues = new HashSet(0);

    public Students() {
    }

	
    public Students(String fullname, String password, String email, int phone) {
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public Students(String fullname, String password, String email, int phone, Set requests, Set issues) {
       this.fullname = fullname;
       this.password = password;
       this.email = email;
       this.phone = phone;
       this.requests = requests;
       this.issues = issues;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPhone() {
        return this.phone;
    }
    
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public Set getRequests() {
        return this.requests;
    }
    
    public void setRequests(Set requests) {
        this.requests = requests;
    }
    public Set getIssues() {
        return this.issues;
    }
    
    public void setIssues(Set issues) {
        this.issues = issues;
    }




}


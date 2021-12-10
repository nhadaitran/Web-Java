package model;
// Generated Dec 10, 2021 8:51:35 AM by Hibernate Tools 4.3.1



/**
 * Request generated by hbm2java
 */
public class Request  implements java.io.Serializable {


     private Integer id;
     private Students students;
     private String name;
     private String author;
     private String publisher;
     private int date;

    public Request() {
    }

	
    public Request(Students students, String name, String author, int date) {
        this.students = students;
        this.name = name;
        this.author = author;
        this.date = date;
    }
    public Request(Students students, String name, String author, String publisher, int date) {
       this.students = students;
       this.name = name;
       this.author = author;
       this.publisher = publisher;
       this.date = date;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Students getStudents() {
        return this.students;
    }
    
    public void setStudents(Students students) {
        this.students = students;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getDate() {
        return this.date;
    }
    
    public void setDate(int date) {
        this.date = date;
    }




}


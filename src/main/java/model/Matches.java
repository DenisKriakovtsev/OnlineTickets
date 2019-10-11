package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import java.util.Set; 

@Entity
@Table(name = "Matches")
public class Matches implements Serializable {

    private static final long serialVersionUID = 1L; //!!!
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    @Column(name = "NameMatch", nullable = false)
    private String namematch;
    @Column(name = "dateBegin", nullable = false)
    private String dateBegin;
    @Column(name = "Price", nullable = false)
    private double price; 
     
    @ManyToOne
    @JoinColumn(name = "stad_id", nullable = false,updatable = false, insertable = true)
    private Stadium stadium;
        
    public Stadium getStadium() {
        return stadium;
    }
    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
          
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)   
    
    public Set<Fans> fans;
    
    public Set<Fans> getFans() {
	return fans;
    }
    public void setFans(Set<Fans> fans) {
	this.fans = fans;
    } 
    
    public Matches() {}
    
    public Matches(String namematches, String date, double price) {
	this.namematch = namematches;
	this.dateBegin = date;
	this.price = price;  
    }
    public Matches(String namematches, String date, double price, Stadium stadium) {
      	this.namematch = namematches;
	this.dateBegin = date;
	this.price = price; 
	this.stadium = stadium;
    }         
    public long getId() {
	return id;
    }
    public void setId(long id) {
	this.id = id;
    }
    public String getNamematches() {
	return namematch;
    }
    public void setNamematches(String namematches) {
	this.namematch = namematches;
    }
    public String getDate() {
	return dateBegin;
    }
    public void setDate(String date) {
	this.dateBegin = date;
    }
    public double getPrice() {
	return price;
    }
    public void setPrice(double price) {
	this.price = price;
    } 
    @Override
    public String toString() {
	return id+ ", namematches=" + namematch + ", date=" + dateBegin + ", price=" + price;
    }
    @Override
    public int hashCode() {
	int hash = 7;
	hash = 71 * hash + Objects.hashCode(this.namematch); 
	return hash;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Matches other = (Matches) obj;
	if (!Objects.equals(this.namematch, other.namematch)) {
	    return false;
	} 
	return true;
    }
}
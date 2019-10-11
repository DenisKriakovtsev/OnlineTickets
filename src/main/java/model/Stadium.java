package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import javax.persistence.*;
import java.util.Set; 

@Entity
@Table(name = "Stadiums")
public class Stadium implements Serializable {

    private static final long serialVersionUID = 1L; //!!!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name="NAME")
    private String name;
    @Column (name="NumberOfSeats")
    private int numberofseats;  
    @Column (name="DateCreate")
    private String datecreate;
    @Column (name="City")
    private String city;
    
    
    @OneToMany(mappedBy = "stadium", 
	    cascade = CascadeType.ALL,
	    fetch = FetchType.LAZY,
	     orphanRemoval = true)   
    
    public Set<Matches> matchs = new HashSet<Matches>();
    public Set<Matches> getMatches() {
	return matchs;
    }
    public void setMatches(Set<Matches> matchs) {
	this.matchs = matchs;
    }

    public Stadium() {
    }

    public Stadium(String name, int numberofseats,String datecreate, String city) {
	this.name = name;
	this.numberofseats = numberofseats;
	this.city = city;
	this.datecreate = datecreate;
    }

    public Stadium(long id, String name, int numberofseats, String datecreate,String city) {
	this.id = id;
	this.name = name;
	this.numberofseats = numberofseats;
        this.city = city;
	this.datecreate = datecreate;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getNumberofseats() {
	return numberofseats;
    }

    public void setNumberofseats(int numberofseats) {
	this.numberofseats = numberofseats;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }
    
     public String getDatecreate() {
	return datecreate;
    }

    public void setDatecreate(String datecreate) {
	this.datecreate = datecreate;
    }
    @Override
    public String toString() {
	return  name + "\nКоличество мест " + numberofseats + " Дата создания стадиона " + datecreate + " Город " + city;
    }

    @Override //Для того, чтобы записывать в Set
    public int hashCode() {
	int hash = 3;
	hash = 97 * hash + Objects.hashCode(this.name);
	return hash;
    }

    @Override //Для того, чтобы записывать в Set
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
	final Stadium other = (Stadium) obj;
	if (!Objects.equals(this.name, other.name)) {
	    return false;
	}
	return true;
    }
}
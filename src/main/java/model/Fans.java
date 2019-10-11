package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*; 

@Entity
@Table(name = "Fans")
public class Fans implements Serializable {

    private static final long serialVersionUID = 1L; //!!!

    @Id //Аннотация для ключевого поля
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FIO", nullable = false)
    private String fio;
    @Column(name = "Sector", nullable = false)
    private int sector;
    @Column(name = "RowInSector", nullable = false)
    private int RowInSector;
    @Column(name = "Place", nullable = false)
    private int place;
 
    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Matches match;

    public Matches getMatch() {
        return match;
    }

    public void setMatch(Matches match) {
        this.match = match;
    }

    public Fans() {
    }

    public Fans(String fio, int sector, int RowInSector, int place) {
        this.fio = fio;
        this.sector = sector;
        this.RowInSector = RowInSector;
        this.place = place;
    }

    public Fans(String fio, int sector, int RowInSector, int place, Matches match) {
        this.fio = fio;
        this.sector = sector;
        this.RowInSector = RowInSector;
        this.place = place;
        this.match = match;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "fio=" + fio + ", sector=" + sector + ", row=" + RowInSector + ", place=" + place;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.fio);
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
        final Fans other = (Fans) obj;
        if (!Objects.equals(this.fio, other.fio)) {
            return false;
        }
        return true;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public int getRow() {
        return RowInSector;
    }

    public void setRow(int RowInSector) {
        this.RowInSector = RowInSector;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}

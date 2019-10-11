package model;
import dba.DAStadiums;
import java.util.*;

public class ModelStadium {
    private static ModelStadium instance = new ModelStadium();

    private List<Stadium> model;

    public static ModelStadium getInstance() {     
        instance.model = DAStadiums.getStadiumsFromDB();
        return instance;
    } 

    private ModelStadium() {
        model= DAStadiums.getStadiumsFromDB();
    }

    public void add(Stadium stadium) {
        model.add(stadium);        
    }

    public List<Stadium> list() {
        return model;
    }
}
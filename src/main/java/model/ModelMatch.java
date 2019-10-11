package model; 
import dba.DAMatch;
import java.util.*;

public class ModelMatch {
    private static ModelMatch instance = new ModelMatch();

    private List<Matches> model;

    public static ModelMatch getInstance() {     
        instance.model = DAMatch.getMatchesFromDB();
        return instance;
    }
 
    private ModelMatch() {
        model= DAMatch.getMatchesFromDB();
    }

    public void add(Matches matches) {
        model.add(matches);        
    }

    public List<Matches> list() {
        return model;
    }
}
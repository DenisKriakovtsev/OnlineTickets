package model;
import dba.DAFans; 
import java.util.*;

public class ModelFans {
    private static final ModelFans instance = new ModelFans();

    private List<Fans> model;

    public static ModelFans getInstance() {     
        instance.model = DAFans.getFansFromDB();
        return instance;
    }
  
    private ModelFans() {
        model= DAFans.getFansFromDB();
    }

    public void add(Fans fans) {
        model.add(fans);        
    }

    public List<Fans> list() {
        return model;
    }
}
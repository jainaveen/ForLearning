package CoreJava;

import java.util.HashMap;

public final class ImmutableClass {

    //Make field final so that they can be assigned only once.
    private final int id; //Immutable member variable
    private final String name;  //Immutable member variable
    private final HashMap<Integer,String> map; //mutable member variable

    public ImmutableClass(int id, String name, HashMap<Integer,String> map){
        this.id=id;
        this.name=name;

        //assign all mutable member variable using new keyword.
        this.map= new HashMap<>(map);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, String> getMap() {
        return map;
    }
}

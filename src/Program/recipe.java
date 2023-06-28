package Program;

import java.util.List;

public class recipe {
    String name;
    List<String> ingredient;
    String method;


    public recipe(String name,List<String> ingredient, String method){
        this.name=name;
        this.ingredient=ingredient;
        this.method = method;
    }
    public String getName(){

        return name;
    }
    public List<String> getIngredient(){

        return ingredient;
    }
    public String getMethod(){

        return method;
    }

}
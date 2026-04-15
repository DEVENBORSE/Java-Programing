import java.lang.*;

public class Constructor {
 
    int id;
    String name;
    String des;

    Constructor(){
        int id = 112023278;
        String name = "Deven";
        String des = "Manager";

        System.out.println("Id : " + id);
        System.out.println("Name: " + name);
        System.out.println("Des: " + des);
    }

    Constructor (int id, String name, String des){
        id=id;
        name=name;
        des=des;

        System.out.println("Id : " + id);
        System.out.println("Name: "+name);
        System.out.println("Des: "+des);
    }

    public static void main(String[] args) {
        Constructor c1 = new Constructor();
        Constructor c2 = new Constructor(11, "Aryan", "Manager");
    }
}

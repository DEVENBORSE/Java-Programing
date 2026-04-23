import java.lang.*;

class Employee{
    int ID;
    String name;
    String des;

    Employee(){
        System.out.println("employee details");
        int ID=123456789;
        String name="Deven";
        String des="Manager";
        System.out.println("the ID:"+ID);
        System.out.println("the name is:"+name);
        System.out.println("the des:"+des);
    }

    Employee(int i, String n, String d){
        ID = i;
        name = n;
        des = d;
        System.out.println("the ID:"+ID);
        System.out.println("the name is:"+name);
        System.out.println("the des:"+des);
    }

    public static void main(String args[]){
        Employee e=new Employee(12,"Dev","pos");
        Employee e2=new Employee();
        
    }
}
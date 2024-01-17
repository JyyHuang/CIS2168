public class Duck {
    int age;
    String name;

    public Duck(int a, String name) {
        age = a;
        this.name = name;
    }

    void quack(){  
        System.out.println("quack");
    }

    public String toString(){
        return this.name;
    }
}






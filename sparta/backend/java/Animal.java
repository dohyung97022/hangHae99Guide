public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void cry(){
        System.out.println(name+ " is crying");
    }

    public String getName() {
        return name;
    }
}

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void swim(){
        System.out.println(super.getName() + " is swimming.");
    }
}

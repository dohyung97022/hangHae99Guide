public class Overriding {
    class Animal{
        String name;

        public Animal(String name) {
            this.name = name;
        }

        public void cry(){
            System.out.println(name + " is crying.");
        }
    }

    class Dog extends Animal{
        public Dog(String name) {
            super(name);
        }

        @Override
        public void cry() {
            System.out.println(super.name+" is barking.");
        }
    }

    public static void main(String[] args) {
        Overriding overriding = new Overriding();
        overriding.run();
    }

    public void run(){
        Dog dog = new Dog("coco");
        dog.cry();
    }
}

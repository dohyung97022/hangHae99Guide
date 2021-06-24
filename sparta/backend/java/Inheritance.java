public class Inheritance {
    public static void main(String[] args) {
        Animal aDog = new Dog("코코");
        aDog.cry();
        Dog dog = new Dog("coco");
        dog.cry();
        dog.swim();
    }
}

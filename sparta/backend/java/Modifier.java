public class Modifier {
    public class Parent{
        private void privateMethod(){
            System.out.println("running privateMethod");
        }
        public void publicMethod(){
            System.out.println("running publicMethod");
        }
        protected void protectedMethod(){
            System.out.println("running protectedMethod");
        }
    }
    public class Child extends Parent{

    }

    public static void main(String[] args) {
        Modifier modifier = new Modifier();
        modifier.run();
    }

    private void run(){
        Child child = new Child();
//        child.privateMethod();
        child.publicMethod();
        child.protectedMethod();
    }
}

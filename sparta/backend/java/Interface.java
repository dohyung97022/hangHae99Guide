public class Interface {
    interface interfacee{
        public static final int fi = 10;
        public void method();

        default void defaultMethod(){
            System.out.println("method is possible in interface");
        }
    }
    class App implements interfacee{
        @Override
        public void method() {
            System.out.println("this is a interface method");
        }
    }

    public static void main(String[] args) {
        Interface interfacee = new Interface();
        interfacee.run();
    }

    private void run() {
        App app = new App();
        app.method();
        app.defaultMethod();
        System.out.println(app.fi);
    }
}

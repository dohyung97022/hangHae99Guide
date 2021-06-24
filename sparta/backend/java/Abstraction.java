public class Abstraction {
    abstract class Bird{
        private int x,y,z;

        void fly(int x, int y, int z){
            printLocation();
            System.out.println("로 날아갑니다.");
            this.x = x;
            this.y = y;
            if (flyable(z)){
                this.z = z;
            }
            else{
                System.out.println("그 높이로는 날 수 없습니다.");
            }
        }

        private void printLocation() {
            System.out.println(this.x + " "+ this.y + " "+ this.z + " ");
        }

        abstract boolean flyable(int z);
    }

    public static void main(String[] args) {
        Abstraction abstraction = new Abstraction();
        abstraction.run();
    }

    void run(){
        Bird bird = new Bird() {
            @Override
            boolean flyable(int z) {
                return z < 100;
            }
        };
        bird.fly(19,250,110);
        bird.fly(48,50,90);
    }
}

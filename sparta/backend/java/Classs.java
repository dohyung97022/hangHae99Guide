class Phone{
    private String model;
    private String color;
    private int price;

    public Phone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class Classs {
    public static void main(String[] args) {
        Phone galaxy = new Phone("galaxy10","black",100);
        Phone iphone = new Phone("iphoneX","black",200);
    }
}

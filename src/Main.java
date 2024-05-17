import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Testing the DayHr class
        System.out.println("-----------Testing DayHR Class---------");
        DayHr dhr1 = new DayHr();
        System.out.println(dhr1);
        System.out.println("T");
        System.out.println("____________________________________________");

        System.out.println("-------------Testing Flower class -----------");
        Plant flowerPlant = new Flower();
        flowerPlant.setColor("Read");
        System.out.println("Color of the Flower: " + flowerPlant.getColor());
        flowerPlant.setWatered("Tuesday", "12am", "10 minutes");
        flowerPlant.setWatered("Wednesday", "13am", "10 minutes");
        flowerPlant.getWatered().forEach((dayHr -> System.out.println(dayHr)));
        System.out.println("Testing without Plant abstract class::");
        Flower flower = new Flower("Rose");
        flower.setIntensity("strong");
        flower.setColor("Red");
        System.out.println(flower);
        System.out.println("_____________________________________________");

        System.out.println("-------------Testing Tomato class -----------");
        Tomato tomato = new Tomato("Mbutu");
        tomato.setColor("red");
        tomato.setWeight(1);
        System.out.println(tomato);
        System.out.println("Products: " + tomato.products());
        System.out.println(tomato.chop());
        System.out.println(tomato.eat());
        tomato.getWatered().forEach((dayHr -> System.out.println(dayHr)));

        System.out.println("_____________________________________________");

        System.out.println("-------------Testing Citrus class -----------");
        Citrus orange = new Citrus("Oranges");
        orange.setColor("orange");
        orange.setPrice(34);
        orange.setWatered("Monday", "11amr", "30 minutes");
        System.out.println("color: " + orange.getColor());
        System.out.println("Chop(): " + orange.chop());
        System.out.println("Price: " + orange.getPrice());
        System.out.println("eat(): " + orange.eat());
        System.out.println(orange);
        //System.out.println(orange.getWatered());
        System.out.println("Testing watering hours:");
        orange.getWatered().forEach((dayHr -> System.out.println(dayHr)));

        System.out.println("-------------Testing Apple class -----------");
        Apple apple = new Apple("appple");
        apple.setColor("light green");
        apple.setPrice(34);
        apple.setWatered("Monday", "11amr", "30 minutes");
        System.out.println("color: " + apple.getColor());
        System.out.println("Chop(): " + apple.chop());
        System.out.println("Price: " + apple.getPrice());
        System.out.println("eat(): " + apple.eat());
        System.out.println(apple);
        //System.out.println(orange.getWatered());
        System.out.println("Testing watering hours:");
        orange.getWatered().forEach((dayHr -> System.out.println(dayHr)));

        //Creating the GUI
        JFrame frame = new JFrame("Project");
        frame.setSize(new Dimension(800, 600));

        frame.setLayout(new GridLayout(0, 2));
        //frame.setLayout(new BorderLayout());
        JPanel left = new JPanel();
        left.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        JPanel topChild = new JPanel();
        topChild.setLayout(new FlowLayout());
        JPanel bottomChild = new JPanel();
        left.setLayout(new GridLayout(0, 1));

        JPanel right = new JPanel();
        JLabel selectPlant = new JLabel("Select Plant");
        //selectPlant.setPreferredSize(new Dimension(20, 50));

        String[] comboInfo = {"Vegitable", "Fruit", "Flower"};

        JComboBox<String> fruits = new JComboBox<>(comboInfo);
        //fruits.setPreferredSize(new Dimension(40, 20));
        JButton add = new JButton("add");
        JButton search = new JButton("search");

        topChild.add(selectPlant);
        topChild.add(fruits);
        bottomChild.add(add);
        bottomChild.add(search);

        left.add(topChild);
        left.add(bottomChild);



        //second GUI
        right.setLayout(new GridLayout(0, 1));



        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPanel(right, comboInfo[fruits.getSelectedIndex()]);
                System.out.println(fruits.getSelectedIndex());
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextArea(right);
            }
        });
        frame.add(left, BorderLayout.WEST);
        frame.add(right, BorderLayout.EAST);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void addPanel(JPanel right, String plantType) {


        //Enter Plant name label
        right.removeAll();
        Border space = BorderFactory.createEmptyBorder(5, 30, 5, 5);
        Border line = BorderFactory.createLineBorder(Color.BLACK);
        right.setBorder(BorderFactory.createCompoundBorder(space, line));
        JLabel plantName = new JLabel(String.format("Enter %s name", plantType));
        JTextField plantNameField = new JTextField();
        plantNameField.setPreferredSize(new Dimension(100, 20));

        //Color text and field
        JLabel color = new JLabel(String.format("Enter the color of the %s", plantType));
        JTextField colorField = new JTextField();
        colorField.setPreferredSize(new Dimension(100, 20));

        //Intensity of plant field and combo box
        JLabel intensityLabel = new JLabel("Smell intensity of the Flower");
        String[] intensities = {"very strong", "strong", "middle", "weak", "very weak"};
        JComboBox<String> intensityBox = new JComboBox<>(intensities);

        //Watering time info
        JLabel water = new JLabel("watering date/time");
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        JComboBox<String> daysBox = new JComboBox<>(days);
        String[] dayTime = {"00:00am", "1:00am", "2:00am", "3:00am"};
        JComboBox<String> dayTimeBox = new JComboBox<>(dayTime);

        //Duration of watering  info
        JLabel duration = new JLabel("duration");
        JTextField durationText = new JTextField();
        durationText.setPreferredSize(new Dimension(50, 20));

        //Duration button
        JButton submit = new JButton("Submit");


        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pan2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pan3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 60));
        JPanel pan4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pan5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //pan3.setPreferredSize(new Dimension(10, 10));
        //adding to pane 1
        pan1.add(plantName);
        pan1.add(plantNameField);
        //adding to pane 2
        pan2.add(color);
        pan2.add(colorField);

        //adding to pane 3
        if (plantType.equals("Flower")) {
            pan3.add(intensityLabel);
            pan3.add(intensityBox);

            //adding to pane 4
            pan4.add(water);
            pan4.add(daysBox);
            pan4.add(dayTimeBox);
            pan4.add(duration);
            pan4.add(durationText);
        }


        //pane 5
        pan5.add(submit);

        right.add(pan1);
        right.add(pan2);
        right.add(pan3);
        right.add(pan4);
        right.add(pan5);
        right.validate(); // Ensures component sizes and positions are valid
        right.repaint();

    }

    public static void addTextArea(JPanel right) {
        right.removeAll();

        right.setBorder(BorderFactory.createEmptyBorder(5, 5, 20, 10));
        JTextArea results = new JTextArea();
        right.add(results);
        right.validate(); // Ensures component sizes and positions are valid
        right.repaint();
    }
}

//gui functions

//////////////

class DayHr {
    String day, hour, duration;
    public DayHr() {
        day = "Monday";
        hour = "10am";
        duration = "1 hour";
    }
    public String toString() {
        return String.format("%s, %s, %s", this.day, this.hour, this.duration);
    }
}
abstract class Plant{
    private String color;
    private ArrayList<DayHr> wateredTimes = new ArrayList<DayHr>();
    public ArrayList<DayHr> getWatered() {
        return wateredTimes;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setWatered(String day, String hour, String duration) {
        DayHr plantTime = new DayHr();
        plantTime.day = day;
        plantTime.hour = hour;
        plantTime.duration = duration;
        wateredTimes.add(plantTime);
    };
}

interface Eatable{
    String chop();
    String eat();
}



//Create flower subclass of a plant class


enum Intensity {
    very_strong,
    strong,
    middle,
    weak,
    very_weak
    }
class Flower extends Plant{

    private String name;
    private Intensity smell;
    //intensity
    Flower() {
        this("");
    }
    Flower(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIntensity(String intensity) {
        switch (intensity) {
            case "veryStrong":
                smell = Intensity.very_strong;
                break;
            case "strong":
                smell = Intensity.strong;
                break;
            case "middle":
                smell = Intensity.middle;
                break;
            case "weak":
                smell = Intensity.weak;
                break;
            case "veryWeak":
                smell = Intensity.very_weak;
                break;
            default:
                // Handle invalid intensity value
                System.out.println("Invalid intensity value: " + intensity);
                break;
        }
    }

    public Intensity getIntensity() {
        return smell;
    }


    public void setWatered(String day, String hour, String duration) {
        super.setWatered(day, hour, duration);
    }

    public ArrayList<DayHr> getWatered() {
        return super.getWatered();
    }

    public String toString() {
        return "Name: " + this.name + " Intensity: " + this.smell + " Color:" + this.getColor();
    }
}

abstract class Fruit extends Plant implements Eatable{
    int price;

    public void setPrice(int p){
        price = p;
    }
    public int getPrice(){
        return (price);
    }
    public String chop(){
        return "Dont chop the fruit byte it";
    }
    public String eat(){
        return "You should eat fruits raw";
    }

}

abstract class Vegetable extends Plant implements Eatable{
    private int Weight;

    public void setWeight(int weight) {
        Weight = weight;
    }
    public int getWeight() {
        return Weight;
    }
    public String chop() {
        return "Chop the vegetable dont bite it";
    }
    public String eat() {
        return "You should eat vegetables cooked";
    }

}

class Citrus extends Fruit{
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return this.cname;
    }
    public Citrus(String cname) {
        this.cname = cname;
    }


    public String getColor () {
        return super.getColor();
    }


    public void setColor(String newColor) {
        super.setColor(newColor);
    }

    public String toString() {
        return "Name: " + this.cname + " color:" + this.getColor() + " price:" + this.getPrice();
    }
}

class Apple extends Fruit{
    private String aname;

    public Apple(String aname) {
        this.aname = aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAname() {
        return aname;
    }
    public String getColor() {
        return super.getColor();
    }


    public void setColor(String newColor) {
        super.setColor(newColor);
    }

    public String toString() {
        return "Name: " + this.aname + " color:" + this.getColor() + " price:" + this.getPrice();
    }

}

class Tomato extends Vegetable{

    private String kind;

    public Tomato(String kind) {
        this.kind = kind;
        super.setWatered("Monday", "9am", "30minutes");
        super.setWatered("Wednesday", "9am", "30minutes");
        super.setWatered("Friday", "9am", "30minutes");
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public String getKind() {
        return kind;
    }


    public ArrayList<DayHr> getWatered() {
        return super.getWatered();
    }

    public ArrayList<String> products() {
        ArrayList<String> info = new ArrayList();
        info.add("Salad");
        info.add("Soup");
        info.add("paste");
        return  info;
    }

    public String toString() {
        return "Kind: " + this.kind + " weight: " + super.getWeight() + " color: " + super.getColor();
    }
}
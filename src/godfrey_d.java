import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class godfrey_d {
    //Array list of all objects created using GUI and Testing
    static final ArrayList<Apple> apples = new ArrayList<>();
    static final ArrayList<Citrus> citruses = new ArrayList<>();
    static final ArrayList<Tomato> tomatoes = new ArrayList<>();
    static final ArrayList<Flower> flowers = new ArrayList<>();
    public static void main(String[] args) {

        //Testing the DayHr class
        System.out.println("-----------Testing DayHR Class---------");
        DayHr dhr1 = new DayHr();
        System.out.println(dhr1);
        //System.out.println("T");
        System.out.println("____________________________________________");

        //Testing Plant class
        //Testing the flower class
        System.out.println("-------------Testing Flower class -----------");
        Flower flowerPlant = new Flower("Rose");
        flowerPlant.setColor("Red");
        flowerPlant.setName("rose");
        System.out.println("Color of the Flower: " + flowerPlant.getColor());
        flowerPlant.setWatered("Tuesday", "12am", "10");
        flowerPlant.setWatered("Wednesday", "13am", "10");
        System.out.println("Testing the Watering time:");
        for (DayHr dayHr: flowerPlant.getWatered())
        {
            System.out.println(dayHr);
        }
        //flowerPlant.getWatered().forEach((dayHr -> System.out.println(dayHr)));
        flowerPlant.setIntensity("strong");
        System.out.println("Testing intensity:" + flowerPlant.getIntensity());
        flowers.add(flowerPlant);
        System.out.println("Testing toString()");
        System.out.println(flowers.get(0));
        System.out.println("_____________________________________________");

        //Testing the Tomato class
        System.out.println("-------------Testing Tomato class -----------");
        Tomato tomato = new Tomato("Tomato");
        tomato.setKind("BritishTomato");
        tomato.setColor("yellow");
        tomato.setWeight(1);
        System.out.println("Products that can be ade from tomato: " + tomato.products());
        System.out.println(tomato.chop());
        System.out.println(tomato.eat());
        System.out.println("Testing weight :" + tomato.getWeight() + "mg");
        System.out.println("Kind of tomato" + tomato.getKind());
        tomatoes.add(tomato);
        System.out.println("Watering times of a tomato:");
        for (DayHr dayHr: tomato.getWatered())
        {
            System.out.println(dayHr);
        }
        //tomato.getWatered().forEach((dayHr -> System.out.println(dayHr)));
        System.out.println("Testing the toString:");
        System.out.println(tomatoes.get(0));
        System.out.println("_____________________________________________");

        //Testing the citrus class
        System.out.println("-------------Testing Citrus class -----------");
        Citrus orange = new Citrus("Orange");
        orange.setColor("Orange");
        orange.setPrice(34);
        orange.setWatered("Monday", "11am", "30 minutes");
        System.out.println("color: " + orange.getColor());
        System.out.println("Chop(): " + orange.chop());
        System.out.println("Price: " + orange.getPrice());
        System.out.println("eat(): " + orange.eat());
        System.out.println("Testing watering hours:");
        for (DayHr dayHr: orange.getWatered())
        {
            System.out.println(dayHr);
        }
        //orange.getWatered().forEach((dayHr -> System.out.println(dayHr)));
        citruses.add(orange);
        System.out.println(citruses.get(0));
        System.out.println("_____________________________________________");

        //Testing the apple class
        System.out.println("-------------Testing Apple class -----------");
        Apple apple = new Apple("apple");
        apple.setAname("GreenApple");
        apple.setColor("light green");
        apple.setPrice(34);
        apple.setWatered("Monday", "12am", "30 minutes");
        System.out.println("color: " + apple.getColor());
        System.out.println("Chop(): " + apple.chop());
        System.out.println("Price: " + apple.getPrice());
        System.out.println("eat(): " + apple.eat());
        System.out.println("Name:" + apple.getAname());
        //System.out.println(orange.getWatered());
        System.out.println("Testing watering hours:");
        apples.add(apple);
        System.out.println(apples.get(0));
        for (DayHr dayHr: apple.getWatered())
        {
            System.out.println(dayHr);
        }
        //orange.getWatered().forEach((dayHr -> System.out.println(dayHr)));

        //Creating the GUI
        JFrame frame = new JFrame("Project");
        frame.setSize(new Dimension(850, 500));
        frame.setLayout(new GridLayout(0, 2));

        //frame.setLayout(new BorderLayout());
        JPanel left = new JPanel();
        left.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        left.setLayout(new GridLayout(0, 1));
        JPanel topChild = new JPanel();
        topChild.setLayout(new FlowLayout());
        JPanel bottomChild = new JPanel();


        JPanel right = new JPanel();
        JLabel selectPlant = new JLabel("Select Plant");
        //selectPlant.setPreferredSize(new Dimension(20, 50));

        String[] comboInfo = {"Vegitable", "Fruit", "Flower"};

        JComboBox<String> fruits = new JComboBox<>(comboInfo);
        //fruits.setPreferredSize(new Dimension(40, 20));
        JButton add = new JButton("Add");
        JButton search = new JButton("Search");

        //adding panels to the left pane
        topChild.add(selectPlant);
        topChild.add(fruits);
        bottomChild.add(add);
        bottomChild.add(search);
        left.add(topChild);
        left.add(bottomChild);


        //second GUI
        right.setLayout(new GridLayout(0, 1));



        //attach events to the add button
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPanel(right, comboInfo[fruits.getSelectedIndex()]);
                //System.out.println(fruits.getSelectedIndex());
            }
        });

        //attach events to the search button
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextArea(right,  comboInfo[fruits.getSelectedIndex()]);

            }
        });

        //adding panels to the main frame
        frame.add(left, BorderLayout.WEST);
        frame.add(right, BorderLayout.EAST);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }



    //Function which add the right panel in the main FRAME
    public static void addPanel(JPanel right, String plantType) {

        //Enter Plant name label
        right.removeAll();
        Border space = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border line = BorderFactory.createLineBorder(Color.BLACK);
        right.setBorder(BorderFactory.createCompoundBorder(space, line));
        JLabel plantName = new JLabel(String.format("Enter %s name", plantType));
        JTextField plantNameField = new JTextField();
        plantNameField.setPreferredSize(new Dimension(130, 25));

        //Color text and field
        JLabel color = new JLabel(String.format("Enter the color of the %s", plantType));
        JTextField colorField = new JTextField();
        colorField.setPreferredSize(new Dimension(130, 25));

        //Intensity of plant field and combo box
        JLabel intensityLabel = new JLabel("Smell intensity of the Flower");
        String[] intensities = {"very strong", "strong", "middle", "weak", "very weak"};
        JComboBox<String> intensityBox = new JComboBox<>(intensities);

        //Watering time info
        JLabel water = new JLabel("watering date/time");
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        JComboBox<String> daysBox = new JComboBox<>(days);
        String[] dayTime = new String[24]; // String array to store time strings

        for (int hour = 0; hour < 12; hour++) {
            dayTime[hour] = hour +1 + " am";
        }

        dayTime[11] = "12 pm";

        for (int hour = 12; hour < 23; hour++) { // Iterate up to index 22
            dayTime[hour] = (hour  - 11) + " pm";
        }
        dayTime[23] = "12 am";
        JComboBox<String> dayTimeBox = new JComboBox<>(dayTime);
        //Duration of watering  info
        JLabel duration = new JLabel("duration");
        JTextField durationText = new JTextField();
        durationText.setPreferredSize(new Dimension(50, 20));

        //Duration button
        JButton submit = new JButton("Submit");

        //creating child right panels
        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pan2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pan3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 60));
        JPanel pan4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pan5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //pan3.setPreferredSize(new Dimension(10, 10));

        //adding to pane 1
        pan1.add(plantName);
        pan1.add(plantNameField);
        pan2.add(color);
        pan2.add(colorField);

        //Only show intensity and watering time if it is a flower
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


        //add button actions
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (plantType.equals("Flower")) {
                    String intensity = intensities[intensityBox.getSelectedIndex()];
                    String day = days[daysBox.getSelectedIndex()];
                    String time = dayTime[dayTimeBox.getSelectedIndex()];
                    String[] info = {plantNameField.getText(), colorField.getText(), intensity, day, time, durationText.getText()};
                    SubmitData.addFlower(info);
                }
                else
                {
                    String[] info = {plantNameField.getText(), colorField.getText()};
                    if (plantType.equals("Vegitable"))
                    {
                        SubmitData.addVeg(info);
                    }
                    else
                    {
                        SubmitData.addFruit(info);
                    }

                }

                //clear the text of the right text fields
                plantNameField.setText("");
                colorField.setText("");
                durationText.setText("");
                intensityBox.setSelectedIndex(0);
                daysBox.setSelectedIndex(0);
                dayTimeBox.setSelectedIndex(0);
            }
        });

        //adding panels  to the right panel
        pan5.add(submit);
        right.add(pan1);
        right.add(pan2);
        right.add(pan3);
        right.add(pan4);
        right.add(pan5);

        //reloading the panel to update changes
        right.validate(); // Ensures component sizes and positions are valid
        right.repaint();

    }

    //adds the results to the text area when search button is pressed
    public static void addTextArea(JPanel right, String plantType) {
        right.removeAll();
        right.setBorder(BorderFactory.createEmptyBorder(5, 5, 20, 10));
        JTextArea results = new JTextArea();
        results.setText("");
        switch (plantType)
        {
            case "Flower":
                for (Flower flower: flowers)
                {
                    DayHr t = flower.getWatered().get(0);
                    results.append(flower.getName() + ", " + flower.getColor() + ", " + flower.getIntensity() + ", " + t.day + ", " + t.hour + ", " + t.duration + " minutes\n");
                }
                //System.out.println("Flower34");
                break;

            case "Vegitable":
                for (Tomato tom: tomatoes)
                {
                    results.append(tom.getKind() + ", " + tom.getColor() + "\n");
                    results.append("Watering time for:" + tom.getKind() + "\n" );
                    for (DayHr t: tom.getWatered())
                    {
                        results.append(t.day + ", " + t.hour + ", " + t.duration + "\n");
                    }
                    results.append("\n");
                }
                break;

            case "Fruit":
                for (Citrus c: citruses)
                {
                    DayHr t = c.getWatered().get(0);
                    results.append(c.getCname() + ", " + c.getColor() + ", " + t.day + ", " + t.hour + ", " + t.duration + "\n");
                }
                break;

        }

        right.add(results);
        right.validate(); // Ensures component sizes and positions are valid
        right.repaint();
    }
}

//holds the watering time
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

//Eatable interface
interface Eatable{
    String chop();
    String eat();
}

//Plant class
abstract class Plant{
    private String color;
    private final ArrayList<DayHr> wateredTimes = new ArrayList<>();
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
    }
}




//Create flower subclass of a plant class


enum Intensity {
    very_strong,
    strong,
    middle,
    weak,
    very_weak
    }

//flower class
class Flower extends Plant{

    private String name;
    private Intensity smell;

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

//Fruit class
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


//Citrus class
class Citrus extends Fruit{
    private String cname;

    public Citrus(String cname) {
        this.cname = cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return this.cname;
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

//Apple class
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

//Tomato class
class Tomato extends Vegetable{

    private String kind;

    Tomato(String kind) {
        this.kind = kind;
        super.setWatered("Monday", "9 am", "30 minutes");
        super.setWatered("Wednesday", "9 am", "30 minutes");
        super.setWatered("Friday", "9 am", "30 minutes");
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
        ArrayList<String> info = new ArrayList<>();
        info.add("Salad");
        info.add("Soup");
        info.add("paste");
        return  info;
    }

    public String toString() {
        return "Kind: " + this.kind + " weight: " + super.getWeight() + " color: " + super.getColor();
    }
}


//creates object using data from GUI
class SubmitData {
    //citrus, apple, tomato and flower
    public static void addFlower(String[] info) {
        Flower newFlower = new Flower(info[0]);
        newFlower.setColor(info[1]);
        newFlower.setIntensity(info[2]);
        newFlower.setWatered(info[3], info[4], info[5]);
        godfrey_d.flowers.add(newFlower);
    }

    public static void addVeg(String[] info) {
        Tomato tom = new Tomato(info[0]);
        tom.setColor(info[1]);
        tom.setWeight(20);
        godfrey_d.tomatoes.add(tom);
    }

    public static void addFruit(String[] info) {
        Citrus orange = new Citrus("orange");
        orange.setCname(info[0]);
        orange.setColor(info[1]);
        orange.setWatered("Tuesday", "10:30 am", "30 minutes");
        orange.setPrice(10);
        godfrey_d.citruses.add(orange);
    }


}

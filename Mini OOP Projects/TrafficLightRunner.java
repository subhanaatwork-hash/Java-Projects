//Traffic Light

class TrafficLight{
private String color;
private int timer;

public TrafficLight(){
    color = "Red";
    timer = 60;
}
public TrafficLight(String c, int t){
    color = c;
    timer = t;
}
public void changeColor() {
        if (color.equals("Red")) {
            color = "Green";
            timer = 45;
            System.out.println("Light changed to GREEN. Timer: " + timer + "s");
        } else if (color.equals("Green")) {
            color = "Yellow";
            timer = 10;
            System.out.println("Light changed to YELLOW. Timer: " + timer + "s");
        } else if (color.equals("Yellow")) {
            color = "Red";
            timer = 60;
            System.out.println("Light changed to RED. Timer: " + timer + "s");
        }
    }

    public void resetTimer() {
        if (color.equals("Red")) {
            timer = 60;
        } else if (color.equals("Green")) {
            timer = 45;
        } else if (color.equals("Yellow")) {
            timer = 10;
        }
        System.out.println("Timer reset to " + timer + "s for " + color + " light.");
    }

    public void showStatus() {
        System.out.println("TRAFFIC LIGHT STATUS");
        System.out.println("Current Color : " + color);
        System.out.println("Timer         : " + timer + " seconds");
    }
}

public class TrafficLightRunner {
    public static void main(String[] args) {

        TrafficLight light = new TrafficLight();  

        light.showStatus();     

        light.changeColor();    
        light.showStatus();

        light.changeColor();    
        light.showStatus();

        light.changeColor();    

        light.resetTimer();     
        light.showStatus();
    }
}

//Smart Device
import java.util.Scanner;
class SmartDevice{
    private String brand;
    private int batteryLevel;
    private int volume;
    private boolean isOn;
    String [] apps = { "Settings", "Instagram" , "Snapchat", "Youtube" , "FarmGame"};

     public SmartDevice(){    //default constrctor
        brand = "nokia";
        volume = 10;
        isOn = false;
        batteryLevel = 10;
    }

    public SmartDevice(String b, int vo, int batteryLvl, boolean on) {
        brand = b;
        volume = (vo <= 20) ? vo : 20;          
        batteryLevel = (batteryLvl <= 100) ? batteryLvl : 100;
        isOn = on;
    }

    public void powerOn() {
        if(isOn == false){
        isOn = true;
        System.out.println("The device is now ON.");
        } else {
        System.out.println("Device is already ON.");
        }
    }
    public void powerOff() {
        if(isOn == true){
        isOn = false;
        System.out.println("The device is now OFF.");
        } else {
        System.out.println("Device is already OFF.");
        }
    }
    public void increaseVolume() {
        if( isOn== false) {
            System.out.println("DEVICE IS OFF!");
            return;
        }
        if(volume < 20){
            volume++;
            System.out.println("Volume increased to: " + volume);

        }
    }
    public void useApp() {
    if (isOn == false) {
        System.out.println("DEVICE IS OFF!");
        return;
    }
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Select the app you want to use:");
    for (int i = 0; i < apps.length; i++) {
        System.out.println((i + 1) + ". " + apps[i]);
    }
    
    System.out.print("Enter app number: ");
    int choice = sc.nextInt();
    
    if (choice >= 1 && choice <= apps.length) {
        System.out.println("Opening " + apps[choice - 1] + "...");
    } else {
        System.out.println("Invalid choice!");
    }
}
    public void charge() {
       if( batteryLevel > 50){
        System.out.println( "Battery is: " + batteryLevel + "%");
    }
       else if ( batteryLevel > 20 && batteryLevel <= 50){
        System.out.println("Battery is: " + batteryLevel + "%");
        System.out.println("Battery is at a moderate level. You can continue using the device.");
    } 
        else if( batteryLevel < 20){
        System.out.println("LOW BATTERY" + "\n Kindly connect a charger.");
        batteryLevel = 100;
        System.out.println("Battery is now fully charged: " + batteryLevel + "%");
    }
        else
        {
            System.out.println("Battery is: " + batteryLevel + "%");
            System.out.println("Put your device on charging.");
        }
    }

    public void showStatus() {
        System.out.println("Brand: " + brand);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Volume: " + volume);
        System.out.println("Power Status: " + (isOn ? "On" : "Off"));
    }
}

    public class SmartDeviceRunner{
        public static void main(String [] args){
            SmartDevice phone1 = new SmartDevice ();
            phone1.showStatus();
            phone1.charge();
            phone1.powerOn();
            phone1.increaseVolume();
            phone1.useApp();
            SmartDevice phone2 = new SmartDevice ("GooglePixel",30,10, true);
            phone2.showStatus();
            phone2.charge();
            phone2.powerOn();
            phone2.increaseVolume();
            phone2.useApp();

            
        }
    }
//PrinterMachine
import java.util.Scanner;
class PrinterMachine {
    private int inkLevel;
    private int paperCount;
    private boolean isOn;

    public PrinterMachine() { //defaultConstructor
        inkLevel    = 20;
        paperCount  = 10;
        isOn        = false;
    }

    public PrinterMachine(int inkLvl, int paperCnt, boolean powerStatus) { //paramterezied constrctor
        inkLevel   = inkLvl;
        paperCount = paperCnt;
        isOn       = powerStatus;
    }
 
    public void powerOn() {  //question asked for power status checking so..
        if (isOn == false) {
            isOn = true;
            System.out.println("Printer is now ON.");
        } else {
            System.out.println("Printer is already ON.");
        }
    }

    public void powerOff() {
        if (isOn == true) {
            isOn = false;
            System.out.println("Printer is now OFF.");
        } else {
            System.out.println("Printer is already OFF.");
        }
    }

    public void printPages() {
    if (isOn == false) {
        System.out.println("Printer is OFF. Please turn it on first.");
        return;
    }
    if (inkLevel <= 0) {
        System.out.println("No ink! Please refill.");
        return;
    }
    if (paperCount <= 0) {
        System.out.println("No paper! Please add paper.");
        return;
    }

    Scanner sc = new Scanner(System.in);  // created locally inside method so dont have to pass it

    System.out.print("Enter number of pages to print: ");
    int n = sc.nextInt();

    if (paperCount < n) {
        System.out.println("Not enough paper! Only " + paperCount + " sheets left.");
        return;
    }
    if (inkLevel < n * 2) {
        System.out.println("Not enough ink to print " + n + " pages.");
        return;
    }

    System.out.println("Print on one side (1) or both sides (2)?");
    int sides = sc.nextInt();

    if (sides == 1) {
        inkLevel   -= n;
        paperCount -= n;
        System.out.println("Printed " + n + " page(s) single sided.");
    } else if (sides == 2) {
        inkLevel   -= n * 2;
        paperCount -= n;
        System.out.println("Printed " + n + " page(s) double sided.");
    } else {
        System.out.println("Invalid choice. Enter 1 or 2.");
    }
}
    public void refillInk() {
        if (inkLevel < 20) {
            System.out.println("Refilling ink...");
            inkLevel = 100;
            System.out.println("Ink is now full: " + inkLevel + "%");
        } else {
            System.out.println("Ink level is sufficient: " + inkLevel + "%");
        }
    }

    public void addPaper() {
        if (paperCount < 10) {
            System.out.println("Paper count is low. adding paper...");
            paperCount = 50;
            System.out.println("Paper count is now: " + paperCount);
        } else {
            System.out.println("Paper is sufficient: " + paperCount + " sheets.");
        }
    }

    public void showStatus() {
        System.out.println("PRINTER STATUS");
        System.out.println("Ink Level   : " + inkLevel + "%");
        System.out.println("Paper Count : " + paperCount + " sheets");
        System.out.println("Power Status: " + (isOn ? "ON" : "OFF"));
    }
}

public class PrinterMachineRunner {
    public static void main(String[] args) {

        PrinterMachine printer1 = new PrinterMachine();
        PrinterMachine printer2 = new PrinterMachine(80, 30, false);

        System.out.println("Printer 1: ");
        printer1.showStatus();
        printer1.powerOn();
        printer1.printPages();
        printer1.refillInk();
        printer1.addPaper();
        printer1.powerOff();
        printer1.showStatus();

        System.out.println("Printer 2: ");
        printer2.showStatus();
        printer2.powerOn();
        printer2.printPages();
        printer2.refillInk();
        printer2.addPaper();
        printer2.powerOff();
        printer2.showStatus();

    }
}

interface RemoteControl {
    void turnOn();
    void turnOff();
}

abstract class Appliance {
    abstract void displayAppliance();
}

class SmartTV extends Appliance implements RemoteControl {

    String brand = "Samsung";
    int size = 55;
    boolean status = false;

    public void turnOn() {
        status = true;
        System.out.println("Smart TV is turned ON");
    }

    public void turnOff() {
        status = false;
        System.out.println("Smart TV is turned OFF");
    }

    void displayAppliance() {
        System.out.println("Appliance Details:");
        System.out.println("Brand : " + brand);
        System.out.println("Screen Size : " + size + " inches");
        System.out.println("Status : " + (status ? "ON" : "OFF"));
    }
}

public class Main {
    public static void main(String[] args) {

        Appliance appliance = new SmartTV();

        appliance.displayAppliance();

        RemoteControl remote = (SmartTV) appliance;

        remote.turnOn();

        appliance.displayAppliance();

        remote.turnOff();

        appliance.displayAppliance();
    }
}
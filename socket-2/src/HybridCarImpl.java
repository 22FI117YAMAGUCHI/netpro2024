public class HybridCarImpl implements ICar, IElectricCharge, INavigation {
    private int battery = 50;
    private int speed = 5;
    private String destination;

    public static void main(String[] args) {
        HybridCarImpl masaCar = new HybridCarImpl();

        ICar car = (ICar) masaCar;
        car.setSpeed(60);
        car.printCarName();

        IElectricCharge charger = (IElectricCharge) masaCar;
        charger.chargeBattery(100);

        INavigation navigator = (INavigation) masaCar;
        navigator.setDestination("Tokyo");
        navigator.printRoute();
    }

    // IElectricCharge methods
    @Override
    public void chargeBattery(int b) {
        this.battery = b;
    }

    @Override
    public int getAllBattery() {
        return battery;
    }

    @Override
    public int consumeBattery(int b) {
        this.battery -= b;
        return this.battery;
    }

    // ICar methods
    @Override
    public void setSpeed(int sp) {
        this.speed = sp;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void printCarName() {
        System.out.println("masacar");
    }

    // INavigation methods
    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public void printRoute() {
        System.out.println("Route to " + destination);
    }
}
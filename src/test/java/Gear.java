public class Gear
{
    //Java Encapsulation
    private int gear;

    //get
    public int getGear(){
        return gear;
    }

    //Set
    public void setGear(int gear){
        this.gear=gear;
    }

    public static void main(String[] args){
        Gear a = new Gear();
        a.setGear(5);
        System.out.println("Current gear: "+ a.getGear());
    }

}

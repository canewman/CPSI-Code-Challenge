public class partTimeEmployee extends Employee{

    public partTimeEmployee (String name, String rate, String hours, String type){
        super(name, rate, hours, type);
    }

    @Override
    public double calcSalary(){//Hours*Rate, no overtime
        salary = Double.parseDouble(this.hours)*Double.parseDouble(this.rate);
        return salary;
    }
}

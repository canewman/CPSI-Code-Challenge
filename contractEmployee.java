public class contractEmployee extends Employee {

    public contractEmployee (String name, String rate, String hours, String type){
        super(name, rate, hours, type);
    }

    @Override
    public double calcSalary(){//$10,000 + (Hours*Rate). There is no cap.
        salary = 10000 + Double.parseDouble(this.hours)*Double.parseDouble(this.rate);
        return salary;
    }
}

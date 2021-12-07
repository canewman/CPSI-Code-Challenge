public class fullTimeEmployee extends Employee{

    public fullTimeEmployee (String name, String rate, String hours, String type){
        super(name, rate, hours, type);
    }

    @Override
    public double calcSalary(){//Hours*Rate but capped at $50,000
        double cap = 50000;
        salary = Double.parseDouble(this.hours)*Double.parseDouble(this.rate);
        if(salary > 50000){salary = 50000;}
        else if(salary<0){salary = 0;}

        return salary;
    }
}

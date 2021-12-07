public class Employee {

    String name;
    String rate;
    String hours;
    String type;
    double salary=0.0;

    public Employee(){}

    public Employee (String name, String rate, String hours, String type){
        this.name = name;
        this.rate = rate;
        this.hours = hours;
        this.type = type;
    }

    public double calcSalary(){return salary;}

    public String getName(){return this.name;}
    public void setName(String inputName){this.name = inputName;}

    public String getRate(){return this.rate;}
    public void setRate(String inputRate){this.rate = inputRate;}

    public String getHours(){return this.hours;}
    public void setHours(String inputHours){this.hours = inputHours;}

    public String getType(){return this.type;}
    public void setType(String inputType){this.type = inputType;}
}

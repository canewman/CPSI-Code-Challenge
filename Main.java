import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean check = true;
        boolean programLoopCheck = true;
        String choice;
        String filePath;
        String searchType = "";

        while(programLoopCheck) {//prompt user for info
            System.out.println("Thank you for using this program\nPlease provide a file path");
            filePath = in.nextLine();
            System.out.println("\nDo you want the salary of all employee or the salary of a specific role?");
            System.out.println("1 All employees");
            System.out.println("2 A specific role");

            choice = in.nextLine();

            while (check) {
                switch (choice) {
                    case "1":
                        searchType = "ALL";
                        check = false;
                        break;

                    case "2":
                        check = false;
                        break;

                    default:
                        System.out.println("\nInvalid Entry");
                        System.out.println("1 All employees");
                        System.out.println("2 A specific role");
                        choice = in.nextLine();


                }
            }

            check = true;
            if(choice.equals("2")) {

                while(check){
                    System.out.println("1: CONTRACT 2: FULLTIME 3: PARTTIME");
                    String type = in.nextLine();

                    switch (type) {
                        case "1":
                            searchType = "CONTRACT";
                            check = false;
                            break;
                        case "2":
                            searchType = "FULLTIME";
                            check = false;
                            break;
                        case "3":
                            searchType = "PARTTIME";
                            check = false;
                            break;
                        default:
                            System.out.println("\nInvalid Entry");
                            break;
                    }
                }
            }
            System.out.println("\nYour choices are:\nFile Path: " + filePath + "\nCalculation Type: " + searchType + "\n\nIs this correct? Type 1 for yes or 2 for no");
            check = true;
            choice = in.nextLine();

            while (check) {
                switch (choice) {
                    case "1":
                        programLoopCheck = false;
                        check = false;
                        break;
                    case "2":
                        check = false;
                        break;

                    default:
                        System.out.println("\nInvalid Entry");
                        System.out.println("Type 1 for yes or 2 for no");
                        choice = in.nextLine();
                }
            }
            if(choice.equals("1")){readFile(filePath, searchType);}//read the file and display the results
        }

    }




    public static void readFile(String file, String searchType) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";
            String splitBy = ",";
            ArrayList<Employee> employeeList = new ArrayList();

            while ((line = br.readLine()) != null)
            {
                String[] currentEmployee = line.split(splitBy);

                switch(currentEmployee[3]){

                    case "FULLTIME":
                        fullTimeEmployee ftEmp = new fullTimeEmployee(currentEmployee[0], currentEmployee[1], currentEmployee[2], currentEmployee[3]);
                        employeeList.add(ftEmp);
                        break;
                    case "PARTTIME":
                        partTimeEmployee ptEmp = new partTimeEmployee(currentEmployee[0], currentEmployee[1], currentEmployee[2], currentEmployee[3]);
                        employeeList.add(ptEmp);
                        break;
                    case "CONTRACT":
                        contractEmployee cEmp = new contractEmployee(currentEmployee[0], currentEmployee[1], currentEmployee[2], currentEmployee[3]);
                        employeeList.add(cEmp);
                        break;
                    default:
                        System.out.println("Contract type in file was entered incorrectly");

                }
            }

            double total=0;
            if(searchType.equals("ALL")){for(int i = 0; i < employeeList.size(); i++){//calculate all salary of chosen type
                total += employeeList.get(i).calcSalary();}
            }
            else{
                for(int i = 0; i < employeeList.size(); i++){
                    if(employeeList.get(i).type.equals(searchType)){
                        total += employeeList.get(i).calcSalary();
                    }
                }
            }
            System.out.println("The total for " + searchType + " is: " + total);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
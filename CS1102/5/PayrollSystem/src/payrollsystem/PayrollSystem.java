package payrollsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) throws Exception {
      ArrayList<Employee> arrEmp = new ArrayList<Employee>();
      String varCont = "N";
      byte menuOption = 0;

      do {
        menuOption = showMenu();

        switch (menuOption) {
          case 1:
            FullTime ft;
            ft = readNewFullTime();
            addEmployee(arrEmp, ft);
            break;
          case 2:
            PartTime pt;
            pt = readNewPartTime();
            addEmployee(arrEmp, pt);
            break;
          case 3:
            calcPayroll(arrEmp);
            break;
          default:
            break;
        }
      } while (menuOption != 4);
    }

    public static FullTime readNewFullTime() {
      int id = 0;
      String name = null;
      double sal = 0.0;
      double hourAndHalf = 0.0;
      Scanner kbd = new Scanner(System.in);

      System.out.println("Enter Id: ");     id = kbd.nextInt();
      System.out.println("\nEnter Name: ");  name = kbd.next();
      System.out.println("\nEnter Salary: ");  sal = kbd.nextDouble();
      System.out.println("\nEnter Bonus: ");  hourAndHalf = kbd.nextDouble();

      FullTime ftl = null;
      ftl = new FullTime(id, name, sal, hourAndHalf, getVehicle());

      return ftl;
    }

    public static PartTime readNewPartTime() {
      int id = 0;
      String name = null;
      double rate = 0.0;
      double hoursWorked = 0.0;

      Scanner kbd = new Scanner(System.in);
      System.out.println("Enter Id: ");     id = kbd.nextInt();
      System.out.println("\nEnter Name: ");  name = kbd.next();
      System.out.println("\nEnter Hourly Rate: ");  rate = kbd.nextDouble();
      System.out.println("\nEnter Hours Worked: ");  hoursWorked = kbd.nextDouble();

      Vehicle v1 = getVehicle();
      PartTime pt1 = null;
      pt1 = new PartTime(id, name, rate, hoursWorked, v1);

      return pt1;
    }

    public static void addEmployee(ArrayList<Employee> pArrEmp, Employee pEmp) {
      pArrEmp.add(pEmp);
    }

    public static byte showMenu() {
      byte menuOption = 0;
      Scanner kbd = new Scanner(System.in);

      System.out.println(""
        + "/* *************************************** /"
        + "\n/ * 1. Add FullTime                     */"
        + "\n/ * 2. Add ParTime                      */"
        + "\n/ * 3. Calculate Payroll                */"
        + "\n/ * 4. Exit                             */"
        + "\n/ ************************************** /"
      );

      System.out.println("Input: ");   menuOption = kbd.nextByte();

      return menuOption;
    }

    public static void calcPayroll (ArrayList<Employee> pArrEmp) {
      double totalCompanyPay = 0.0;
      double individualPay;

      for (int i = 0; i < pArrEmp.size(); i++) {
        System.out.println("/* *************************************** /");

        individualPay = (pArrEmp.get(i)).calculatePay();
        Vehicle v = (pArrEmp.get(i)).getVehicle();
        String hasVehicle;

        if (v == null) {
          hasVehicle = "No";
        } else {
          hasVehicle = "Yes";
        }

        if (v!= null) {
          System.out.println("Plate Number: " + v.getPlateNumber());
          System.out.println("Colour: " + v.getColour());
        }

        System.out.println("Take Home Pay: " + individualPay);

        totalCompanyPay = totalCompanyPay + individualPay;
      }

      System.out.println("/* ****************************\n Total Pay Roll of the company is " +  totalCompanyPay + "\n****** /");
    }

    public static Vehicle getVehicle() {
      Scanner kbd = new Scanner(System.in);
      String hasVehicle = "N";
  
      System.out.println("\n Does this employee have a vehicle? Y?N : \n Input: ");

      if (hasVehicle.equalsIgnoreCase("Y")) {
        System.out.println("\n Enter plate number: ");  String auxPlate = kbd.next();
        System.out.println("\n Enter vehicle colour: ");  String auxColour = kbd.next();
        return (new Vehicle(auxPlate, auxColour));
      } else {
        return (null);
      }
    }
}
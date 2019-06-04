package payrollsystem;

public abstract class Employee {
  private int empId;
  private String name;
  private Vehicle vehicle;

  public Employee() {
    // default constructor

    System.out.println("... inside Employee default constructor");
    empId = 0;
    name = "";
  }

  public Employee(int pEmpId, String pName, Vehicle pV) {
    // non-default constructor

    System.out.println("... inside Employee non-default constructor");
    empId = pEmpId;
    name = pName;
    this.vehicle = pV;
  }

  public abstract double calculatePay();

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
}
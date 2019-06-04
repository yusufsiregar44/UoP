package payrollsystem;

public abstract class PartTime extends Employee {
  private double rate;
  private double hoursWorked;
 
  PartTime(int id, String name, double rate, double hoursWorked, Vehicle vehicle) {
    super(id, name, vehicle);
    this.rate = rate;
    this.hoursWorked = hoursWorked;
  }

  public double calculatePay() {
    System.out.println("Part time employee");
    return (this.rate * this.hoursWorked);
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public double getHoursWorked() {
    return hoursWorked;
  }

  public void setHoursWorked(double hoursWorked) {
    this.hoursWorked = hoursWorked;
  }
}
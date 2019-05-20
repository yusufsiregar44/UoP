public class Student  {
  int age;
  static int age2 = 3;

  public static void main(String[] args) {
        Student student1;
        Student student2;
        Student student3;

        student1 = new Student();
        student1.age = 10;
        student2 = student1;
        student3 = new Student();
        System.out.println(student2.age+"  "+ student3.age2);
  }
}


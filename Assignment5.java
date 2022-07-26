import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Assignment5 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.empInfo1();
        employee.empInfo2();
    }
}

class Employee implements Comparable<Employee> {
    //attributes
    int id;
    String name;
    int age;
    String gender;
    String dept;
    int yearOfJoining;
    double salary;
    TreeMap<Employee, Integer> treeMap;

    //first constructor
    Employee(String name, int age, String gender, String dept, int yearOfJoining, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    //second constructor
    Employee() {
        treeMap = new TreeMap<>();
        treeMap.put(new Employee("Asch", 32, "M", "Programming", 2020, 90000.00), 11);
        treeMap.put(new Employee("Cap", 22, "M", "Maintenance", 2002, 60000.00), 15);
        treeMap.put(new Employee("Pot", 18, "F", "Legal", 2022, 50000.00), 29);
        treeMap.put(new Employee("Midori", 38, "F", "Maintenance", 2003, 95000.00), 29);
    }

    public void empInfo1() {
        int m = 0;
        int f = 0;
        int aveAgeF = 0;
        int aveAgeM = 0;
        double avgSalF = 0;
        double avgSalM = 0;


        for (Map.Entry<Employee, Integer> entry : treeMap.entrySet()) {
            if (Objects.equals(entry.getKey().gender, "M")) {
                m = m + 1;
                aveAgeM = (entry.getKey().age + aveAgeM) / m;
                avgSalM = (entry.getKey().salary + avgSalM) / m;
            }
            if (Objects.equals(entry.getKey().gender, "F")) {
                f = f + 1;
                aveAgeF = (entry.getKey().age + aveAgeF) / f;
                avgSalF = (entry.getKey().salary + avgSalF) / f;
            }
            if (entry.getKey().age <= 30) {
                System.out.println(entry.getKey().name + " is younger or equal to 30 years old.");
            }
            if (entry.getKey().age > 30) {
                System.out.println(entry.getKey().name + " is older than 30 years old.");
            }
            if (entry.getKey().yearOfJoining > 2015) {
                System.out.println(entry.getKey().name + " joined after 2015.");
            }
        }
        System.out.println("There are " + m + " male and " + f + " female employees in the organization.");
        System.out.println("The average age of male and female employees are " + aveAgeM + " and " + aveAgeF + ".");

    }

    public void empInfo2() {
        int f = 0;
        int m = 0;
        int prgmDept = 0;
        int mainDept = 0;
        int legDept = 0;
        int maxAge = treeMap.lastKey().age;
        double maxSal = treeMap.lastKey().salary;

        for (Map.Entry<Employee, Integer> entry : treeMap.entrySet()) {
            if (entry.getKey().salary == maxSal) {
                System.out.println(entry.getKey().name + " is the highest paid employee.");
            }
            if (entry.getKey().age == maxAge) {
                System.out.println(entry.getKey().name + " is the senior most employee.");
            }
            if (Objects.equals(entry.getKey().gender, "M") && Objects.equals(entry.getKey().dept, "Maintenance")) {
                m = m + 1;
            }
            if (Objects.equals(entry.getKey().gender, "F") && Objects.equals(entry.getKey().dept, "Maintenance")) {
                f = f + 1;
            }
            if (Objects.equals(entry.getKey().dept, "Programming")) {
                prgmDept = prgmDept + 1;
                System.out.println(entry.getKey().name + " is in the programming department.");
            }
            if (Objects.equals(entry.getKey().dept, "Legal")) {
                legDept = legDept + 1;
                System.out.println(entry.getKey().name + " is in the legal department.");
            }
            if (Objects.equals(entry.getKey().dept, "Maintenance")) {
                mainDept = mainDept + 1;
                System.out.println(entry.getKey().name + " is in the maintenance department.");
            }

        }
        System.out.println("There are " + m + " male and " + f + " female employee in Maintenance department.");
        System.out.println("There are " + prgmDept + " employees in the programming department, " +
                legDept + " employees in the legal department, and " +
                mainDept + " employees in the maintenance department.");
    }

    @Override
    public int compareTo(Employee a) {
        return (int) (this.salary - a.salary);
    }
}
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {

        WashingMachine clothes = new WashingMachine();
        clothes.acceptClothes(10);

        Student student = new Student("Asch");
        student.average(90, 10, 40);

        Bank bank = new Bank(500, 800);
        bank.deposit(bank.amount, bank.balance);
        bank.withdraw(bank.amount, bank.balance);

        Truck tr = new Truck();
        tr.setColor("red");
        tr.setLoadingCapacity(120);
        tr.setManufacturer("Honda");
        tr.setVehicleNo("JAVA1234");
        tr.print();
    }
}

/*
 i)  Create a washing machine class with methods as swtichOn, acceptClothes, acceptDetergent, switchOff.
    acceptClothes accepts the noofClothes as argument & returns the no of Clothes.
*/

class WashingMachine {
    void switchOn() {
    }

    // number of clothes
    int acceptClothes(int noOfClothes) {
        System.out.println("The number clothes accepted are " + noOfClothes);
        return noOfClothes;
    }
    void acceptDetergents() {
    }
    void switchOff() {
    }
}
/*
ii) Create a class Student which has following methods
   i) Average: which would accept marks of 3 examinations & return whether the student has passed or failed depending on whether he
      has scored an average above 50 or not?
   ii) Input : which would accept the name of the student & returns the name?
*/
class Student {
    //attributes
    String name;

    //constructor
    Student(String name) {
        this.name = name;
        input(this.name);
    }

    //average of 3 exams
    double average(int ex1, int ex2, int ex3) {
        double ave = (double) (ex1 + ex2 + ex3) / 3;

        if (ave > 50.0) {
            System.out.println(this.name + " passed.");
        } else {
            System.out.println(this.name + " failed.");
        }
        return ave;
    }

    //student's name
    String input(String name) {
        return this.name;
    }
}

/*
iii)Create a Bank class with methods deposit & withdraw. The deposit method would
 accept attributes amount & balance (returns the new balance which
   is the sum of amount & balance. Similarly the withdraw method
   would accept the attributes amount & balance & returns the
   new balance if(balance >=amount or return 0 otherwise
*/
class Bank {
    //attributes
    int amount;
    int balance;

    //constructor
    Bank(int amount, int balance) {
        this.amount = amount;
        this.balance = balance;

    }

    //sum of amount and balance
    int deposit(int amount, int balance) {
        int newBalance = this.amount + this.balance;
        System.out.printf("The new balance after the deposit is $ %,.2f\n",(float)newBalance);
        return newBalance;
    }

    //difference after withdrawal
    int withdraw(int amount, int balance) {
        int newBalance = this.balance - this.amount;
        if (this.balance >= this.amount)
            System.out.printf("The new balance after the withdrawal is $%,.2f\n", (float)newBalance);
        return 0;
    }
}
/*
 iv) Create a Vehicle having following attributes. vehicle no,
 Model  manufacturer and color. create truck which has following
 additional attributes: loadingcapacity(100 tons).
 Add a behavior tochange the color and loading capacity.
 Display the updated truck details.
*/

//super class
abstract class Vehicle {
    String vehicleNo = "SQL1234";
    String manufacturer = "Toyota";
    String color = "Blue";

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
//subclass
class Truck extends Vehicle {
    int loadingCapacity = 100;

    public void setLoadingCapacity(int loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }
    //print statement
    public void print(){
        System.out.println("The vehicle no. of the " + super.color + " " +
                super.manufacturer + " is " + super.vehicleNo + " and loading capacity is " + this.loadingCapacity + ".");
    }
}
/*
 v) The bookstore application:
    The bookstore sells books, music CD's, and software's. Typically a customer first logs on to the system , entering a customer id and password. The customer can then browse for titles or search by keyword. The customer puts some of the titles into a shopping cart which keeps track of the desired titles. When the customer is done shopping, he/she confirms the order, shipping and billing address. The bookstore system then issues a shipping order, bills the customer and issues an electronic receipt.
    At the end of transaction the customer logs off.
    OO Design: With reference to the above create, a scenario
    system diagram, classes and attributes and relationship as well */
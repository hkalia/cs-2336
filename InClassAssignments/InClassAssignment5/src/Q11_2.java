import java.util.Date;

public class Q11_2 {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "Earth", "1234", "johndoe@johndoe.com");
        Student student = new Student("John Doe", "Earth", "1234", "johndoe@johndoe.com");
        Employee employee = new Employee("John Doe", "Earth", "1234", "johndoe@johndoe.com");
        Faculty faculty = new Faculty("John Doe", "Earth", "1234", "johndoe@johndoe.com");
        Staff staff = new Staff("John Doe", "Earth", "1234", "johndoe@johndoe.com");

        System.out.println(person.toString());
        System.out.println(student.toString());
        System.out.println(employee.toString());
        System.out.println(faculty.toString());
        System.out.println(staff.toString());
    }
}

class Person {
    private String name;
    private String address;
    private String phone;
    private String email;

    public Person() {
    }

    public Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "name: " + name + " class name: Person";
    }
}

class Student extends Person {
    private String status;

    public Student() {
    }

    public Student(String name, String address, String phone, String email) {
        super(name, address, phone, email);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + " class name: Student";
    }
}

class Employee extends Person {
    private String office;
    private int salary;
    private Date dateHired;

    public Employee() {
    }

    public Employee(String name, String address, String phone, String email) {
        super(name, address, phone, email);
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + " class name: Employee";
    }
}

class Staff extends Employee {
    private String title;

    public Staff() {
    }

    public Staff(String name, String address, String phone, String email) {
        super(name, address, phone, email);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + " class name: Staff";
    }
}

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty() {
    }

    public Faculty(String name, String address, String phone, String email) {
        super(name, address, phone, email);
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + " class name: Faculty";
    }
}
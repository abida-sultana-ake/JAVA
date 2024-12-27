package bank.management;
public class Employee
{
    private String empId;
    private String name;
    private int age;
    private String department;
    private double salary;
    public Employee(String empId, String name, int age, String department, double salary)
    {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }
    public String getEmpId()
    {
        return empId;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getDepartment()
    {
        return department;
    }
    public double getSalary()
    {
        return salary;
    }
    @Override
    public String toString()
    {
        return "ID: " + empId + ", Name: " + name + ", Age: " + age + ", Department: " + department + ", Salary: " + salary;
    }
}
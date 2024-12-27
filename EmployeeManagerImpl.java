package bank.management;
import java.util.ArrayList;
import java.util.List;
public class EmployeeManagerImpl implements EmployeeManager
{
    private List<Employee> employees;
    public EmployeeManagerImpl()
    {
        employees = new ArrayList<>();
    }
    @Override
    public void addEmployee(Employee employee)
    {
        employees.add(employee);
        System.out.println("Employee " + employee.getName() + " added successfully.");
    }
    @Override
    public List<Employee> viewEmployees()
    {
        return employees;
    }
    @Override
    public Employee searchEmployeeById(String id)
    {
        for (Employee employee : employees)
        {
            if (employee.getEmpId().equals(id))
            {
                return employee;
            }
        }
        return null;
    }
    @Override
    public boolean updateEmployeeById(String id, Employee updatedEmployee)
    {
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees.get(i).getEmpId().equals(id))
            {
                employees.set(i, updatedEmployee);
                System.out.println("Employee with ID " + id + " updated successfully.");
                return true;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
        return false;
    }
    @Override
    public boolean deleteEmployeeById(String id)
    {
        for (Employee employee : employees)
        {
            if (employee.getEmpId().equals(id))
            {
                employees.remove(employee);
                System.out.println("Employee " + id + " deleted successfully.");
                return true;
            }
        }
        return false;
    }
}

package bank.management;
import java.util.List;
public interface EmployeeManager
{
    void addEmployee(Employee employee);
    List<Employee> viewEmployees();
    Employee searchEmployeeById(String id);
    boolean updateEmployeeById(String id, Employee updatedEmployee);
    boolean deleteEmployeeById(String id);
}

package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class EmployeeManagementSystemWithGUI extends JFrame {
    private EmployeeManager employeeManager;
    private JTextArea textArea;
    private JTextField empIdField, nameField, ageField, deptField, salaryField;
    public EmployeeManagementSystemWithGUI()
    {
        employeeManager = new EmployeeManagerImpl();
        setTitle("Employee Management System");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initUI();
    }
    private void initUI()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        JLabel empIdLabel = new JLabel("Employee ID:");
        empIdField = new JTextField();
        JLabel nameLabel = new JLabel("Employee Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Employee Age:");
        ageField = new JTextField();
        JLabel deptLabel = new JLabel("Department:");
        deptField = new JTextField();
        JLabel salaryLabel = new JLabel("Salary:");
        salaryField = new JTextField();
        panel.add(empIdLabel);
        panel.add(empIdField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(deptLabel);
        panel.add(deptField);
        panel.add(salaryLabel);
        panel.add(salaryField);
        JButton addButton = new JButton("Add Employee");
        JButton viewButton = new JButton("View Employees");
        JButton searchButton = new JButton("Search Employee");
        JButton deleteButton = new JButton("Delete Employee");
        JButton updateButton = new JButton("Update Employee");
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        addButton.addActionListener(e -> addEmployee());
        viewButton.addActionListener(e -> viewEmployees());
        searchButton.addActionListener(e -> searchEmployee());
        deleteButton.addActionListener(e -> deleteEmployee());
        updateButton.addActionListener(e -> updateEmployee());
    }
    private void addEmployee()
    {
        try
        {
            String id = empIdField.getText();
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String department = deptField.getText();
            double salary = Double.parseDouble(salaryField.getText());
            Employee employee = new Employee(id, name, age, department, salary);
            employeeManager.addEmployee(employee);
            JOptionPane.showMessageDialog(this, "Employee added successfully!");
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please enter valid values.");
        }
    }
    private void viewEmployees()
    {
        List<Employee> employees = employeeManager.viewEmployees();
        textArea.setText("");
        if (employees.isEmpty())
        {
            textArea.append("No employees found.");
        }
        else
        {
            for (Employee emp : employees)
            {
                textArea.append(emp + "\n");
            }
        }
    }
    private void searchEmployee()
    {
        String id = empIdField.getText();
        Employee employee = employeeManager.searchEmployeeById(id);
        if (employee != null)
        {
            textArea.setText(employee.toString());
        }
        else
        {
            textArea.setText("Employee with ID " + id + " not found.");
        }
    }
    private void deleteEmployee()
    {
        String id = empIdField.getText();
        boolean isDeleted = employeeManager.deleteEmployeeById(id);
        if (isDeleted)
        {
            JOptionPane.showMessageDialog(this, "Employee deleted successfully!");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Employee with ID " + id + " not found.");
        }
    }
    private void updateEmployee()
    {
        try
        {
            String id = empIdField.getText();
            String newName = nameField.getText();
            int newAge = Integer.parseInt(ageField.getText());
            String newDepartment = deptField.getText();
            double newSalary = Double.parseDouble(salaryField.getText());
            Employee updatedEmployee = new Employee(id, newName, newAge, newDepartment, newSalary);
            if (employeeManager.updateEmployeeById(id, updatedEmployee))
            {
                JOptionPane.showMessageDialog(this, "Employee updated successfully!");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Employee with ID " + id + " not found.");
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please enter valid values.");
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            EmployeeManagementSystemWithGUI system = new EmployeeManagementSystemWithGUI();
            system.setVisible(true);
        });
    }
}


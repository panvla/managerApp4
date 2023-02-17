package com.vladimirpandurov.managerApp4.service;

import com.vladimirpandurov.managerApp4.exception.EmployeeNotFoundException;
import com.vladimirpandurov.managerApp4.model.Employee;
import com.vladimirpandurov.managerApp4.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long employeeid){
        return this.employeeRepository.findEmployeeById(employeeid).orElseThrow(()-> new EmployeeNotFoundException("Employee with id " + employeeid + " not found"));
    }

    public List<Employee> getAllEmployees(){
        return this.employeeRepository.findAll();
    }

    public Employee editEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        this.employeeRepository.deleteEmployeeById(id);
    }

}

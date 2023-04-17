package com.nicotine.addiction.example.rest.empRest;

import com.nicotine.addiction.example.entity.Employee;
import com.nicotine.addiction.example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp/api")
public class EmployeeRestController {

    private final EmployeeService _employeeService;

    public EmployeeRestController(EmployeeService employeeService ) {
        _employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return _employeeService.findAll();
    }

    @GetMapping("/employees/{idEmp}")
    public Employee findById(@PathVariable int idEmp) {
        if (_employeeService.findById(idEmp) == null) {
            throw new IllegalArgumentException("Employee with id " + idEmp + " was not found");
        }
        return _employeeService.findById(idEmp);
    }

    @DeleteMapping("/employees/delete/{idEmp}")
    public void deleteById(@PathVariable int idEmp) {
        if (_employeeService.findById(idEmp) == null) {
            throw new IllegalArgumentException("Employee with id " + idEmp + " was not found");
        }
        _employeeService.deleteById(idEmp);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return _employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return _employeeService.save(employee);
    }


}

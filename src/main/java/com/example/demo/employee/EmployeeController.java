package com.example.demo.employee;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/getEmployees")
    public List<Employee> getAllControllerEmployees() {
        return employeeService.getAllServiceEmployees();
    }

    @PostMapping(value = "/addEmployee")
    public void addEmployee(@RequestBody JsonNode json) {
        employeeService.addServiceEmployee(json);
    }

    @DeleteMapping(value = "/delEmployee/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteServiceEmployee(employeeId);
    }

    @PutMapping(value = "/updateEmployee/{id}")
    public void updateObjective(@RequestBody JsonNode json, @PathVariable Long id) {
        employeeService.updateServiceEmployee(json, id);
    }
}



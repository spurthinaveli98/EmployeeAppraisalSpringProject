package com.example.demo.employee;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/getEmployees")
    public List<Employee> getEmployees() throws Exception{
        List<Employee> allInfo = employeeService.getEmployees();
        if(allInfo.isEmpty())
            throw new NullPointerException("No Employees in the List");
            return allInfo;
    }

    @GetMapping(value = "/getEmployee/{id}")
    public Employee getEmployee(@PathVariable Long id) throws Exception{
        Employee info = employeeService.getEmployee(id);
                try{
                    info.getId(); //To check if employee exists or not.
                    return info;
                }
                catch(NullPointerException e){
                    throw new NullPointerException("No such Employee is Found");
                }
    }

    @PostMapping(value = "/addEmployee")
    public void addEmployee(@RequestBody JsonNode json)throws Exception {
        try{
        employeeService.addEmployee(json);
    }
        catch (NullPointerException e) {
            throw new NullPointerException("Incomplete Information");
        }
    }

    @DeleteMapping(value = "/delEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id) throws Exception  {
        try {
        employeeService.deleteEmployee(id);
        }
        catch (NullPointerException e) {
            throw new NullPointerException("No such employee exist");
        }
    }

    @PutMapping(value = "/updateEmployee/{id}")
    public void updateEmployee(@RequestBody JsonNode json, @PathVariable Long id) throws Exception {
        try {
            employeeService.updateEmployee(json, id);
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Employee with id:"+"{"+id+"}"+" "+"does not exist");
        }
        catch(NullPointerException e){
            throw new NullPointerException("No such field is present in table");
        }
    }
}



package com.example.demo.employee;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllServiceEmployees() {

        return employeeRepository.findAll();
    }

    public Employee addServiceEmployee(JsonNode json) {

        Employee employee = new Employee();

        String name = json.get("employeeName").asText();
        employee.setEmployeeName(name);

        String quality = json.get("quality").asText();
        employee.setQuality(quality);

        String quantity = json.get("quantity").asText();
        employee.setQuantity(quantity);

        String technicalKnowledge = json.get("technicalKnowledge").asText();
        employee.setTechnicalKnowledge(technicalKnowledge);

        Integer grades = json.get("grades").asInt();
        employee.setGrades(grades);

        String increment = salaryIncrement(quality,quantity);
        employee.setIncrement(increment);

        return employeeRepository.save(employee);
    }

    public String salaryIncrement(String quality, String quantity) {
        String increment;

        if (quality.equalsIgnoreCase(String.valueOf(LevelEnum.Level.High)) && quantity.equalsIgnoreCase(String.valueOf(LevelEnum.Level.High))) {
            increment="80%";
        } else if (quality.equalsIgnoreCase(String.valueOf(LevelEnum.Level.High)) && quantity.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Medium))) {
            increment="70%";
        } else if (quality.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Medium)) && quantity.equalsIgnoreCase(String.valueOf(LevelEnum.Level.High))) {
            increment="60%";
        } else if (quality.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Medium)) && quantity.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Medium))) {
            increment="50%";
        } else if (quality.equalsIgnoreCase(String.valueOf(LevelEnum.Level.High)) && quantity.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Low))) {
            increment="40%";
        } else if (quality.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Low)) && quantity.equalsIgnoreCase(String.valueOf(LevelEnum.Level.High))) {
            increment="30%";
        } else if (quality.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Medium)) && quantity.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Low))) {
            increment="20%";
        } else if (quality.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Low)) && quantity.equalsIgnoreCase(String.valueOf(LevelEnum.Level.Medium))) {
            increment="10%";
        } else  {
            increment="No increment in salary";
        }

        return increment;
    }


//    public void deleteServiceEmployee(Long employeeId) {
//        Employee employee=employeeRepository.getOneById(employeeId);
//        employeeRepository.save(employee);
//    }


}

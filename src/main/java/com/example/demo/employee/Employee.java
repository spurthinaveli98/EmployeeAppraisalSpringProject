package com.example.demo.employee;

import javax.persistence.*;

@Entity
@Table(name= "request")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false)
    private String quality;

    @Column(nullable = false)
    private String quantity;

    @Column(nullable = false)
    private String technicalKnowledge;

    @Column(nullable = false)
    private Integer grades;

    @Column
    private String increment;

    public void setEmployeeName(String employeeName) {

        this.employeeName = employeeName;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setTechnicalKnowledge(String technicalKnowledge) {
        this.technicalKnowledge = technicalKnowledge;
    }

    public void setGrades(Integer grades) {
        this.grades = grades;
    }

    public void setIncrement(String increment) {
        this.increment = increment;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getQuality() {
        return quality;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTechnicalKnowledge() {
        return technicalKnowledge;
    }

    public Integer getGrades() {
        return grades;
    }

    public String getIncrement() {
        return increment;
    }

}

package com.empapp.empapp.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
//employee constructor
public class EmpModel {
    private int id;
    private String name;
    private int age;
    private String workPlace;
    private int dailyIncome;
}


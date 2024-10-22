package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecreteMessage")
//    public String getMySuperSecreteMessage(){
//        return  "Secrete Message: hiiiii%dfvh";
//    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return new EmployeeDTO(id, "Sandip", "sandipgardi935@gmail.com", 23, LocalDate.of(2024,11,1), true);
    }

    @GetMapping(path = "")
    public String getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return "hi age "+age + " "+ sortBy;
    }

//    @PostMapping
//    public String  createNewEmployee(){
//        return "Hello from POST";
//    }
    @PostMapping
    public EmployeeDTO  createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }


    @PutMapping
    public String updateEmployee(){
        return "Hello from PUT";
    }
}







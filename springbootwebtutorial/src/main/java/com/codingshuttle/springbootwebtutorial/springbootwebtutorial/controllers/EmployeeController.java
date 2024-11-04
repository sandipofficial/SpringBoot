package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.Exceptions.ResourceNotFoundException;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecreteMessage")
//    public String getMySuperSecreteMessage(){
//        return  "Secrete Message: hiiiii%dfvh";
//    }
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(ResponseEntity:: ok)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: "+id));
//        if (employeeDTO == null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(employeeDTO);
    }



    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO>  createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
        public ResponseEntity<Boolean> deleteEmployee( @PathVariable Long employeeId){
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployee(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId){
         EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId, updates);
         if (employeeDTO == null) return ResponseEntity.notFound().build();
         return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping(path = "/deleteAll")
        public boolean deleteAllEmployee( ){
        return employeeService.deleteAllEmployee();


    }
}









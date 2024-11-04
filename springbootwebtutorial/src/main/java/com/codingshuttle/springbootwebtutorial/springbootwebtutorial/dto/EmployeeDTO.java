package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    @NotBlank(message = "Name can not be blank")
    @Size(min = 1, max = 10, message = "number of characters should be in range")
    private String name;

    @NotBlank
    @Email(message = "should be a valid email")
    private String email;

    @NotNull
    @Max(value = 80, message = "age should less than 80")
    @Min(value = 10, message = "age should be greater than 10")
    private Integer age;

    @NotNull(message = "Salary of employee should be not null")
    @Positive(message = "Salary of employee shold not be neagative")
    @Digits(integer = 6, fraction = 2, message = "Salary can be in XXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @NotBlank(message = "role can not be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "The role of employee can be ADMIN or USER")  //regular expression
    @EmployeeRoleValidation
    private String role; //admin or user

    @PastOrPresent(message = "date can not be in future")
    private LocalDate dateOfJoining;

    @AssertTrue
    @JsonProperty("isActive")
    private Boolean isActive;


}

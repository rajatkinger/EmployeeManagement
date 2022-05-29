package com.employee.EmployeeManagement.model;

import com.employee.EmployeeManagement.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection= Constants.EMP_COLLECTION)
public class Employee {

    @Id
    private String  empId;
    private String firstName;
    private String lastName;
    private String department;

}

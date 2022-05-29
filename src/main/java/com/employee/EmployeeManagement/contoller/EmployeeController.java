package com.employee.EmployeeManagement.contoller;

import com.employee.EmployeeManagement.model.Employee;
import com.employee.EmployeeManagement.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger log= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        log.info("Sending a create employee request to employeeService");
        try{
            employeeService.createEmployee(employee);
        }catch(Exception e){
            log.error("Could not create the employee {}",e.getMessage());
        }
        return ResponseEntity.ok("Employee created");
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") String Id) {
        log.info("Finding the employee with the ID {}", Id);
        Optional<Employee> employee = null;
        try {
            employee = employeeService.getEmployeeById(Id);
        } catch (Exception e) {
            log.error("Exception occurred {}", e.getMessage());
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmpById(@PathVariable("id")String Id){
        log.info("Deleting the employee with the ID {}",Id);
        employeeService.deleteEmployee(Id);
        return ResponseEntity.ok("Employee with ID "+Id+" deleted");
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        log.info("Fetching all the employee details from the DB ");
        List<Employee> allEmployees=employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

}

package com.rm.SpringbootRest.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rm.SpringbootRest.controller.EmployeeController;
import com.rm.SpringbootRest.model.Employee;
import com.rm.SpringbootRest.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private EmployeeServiceImpl employeeservice;
	

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
         
        Employee emp = new Employee("Roshan");
     
        List<Employee> findAllEmployees = Arrays.asList(emp);
     
//        given(employeeservice.getAllEmployees()).willReturn(allEmployees);
     
           mvc.perform(get("/api/employees")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
        
   }
}

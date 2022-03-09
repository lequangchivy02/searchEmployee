package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.dto.EmployeeDTO;
import net.javaguides.springboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.repository.EmployRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	// get all employees
	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployees(){
		return employeeService.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/employees}")
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee) {
		return employeeService.save(employee);
	}

	@GetMapping("/")
	public String add(Model model) {
		List<EmployeeDTO> listemployee = employeeService.listAll();
		model.addAttribute("employee", new EmployeeDTO());
		return "index";
	}


	@PostMapping("/search")
	public String doSearchEmployee(@ModelAttribute("employeeSearchFormData") EmployeeDTO formData, Model model) {
		EmployeeDTO emp = employeeService.get(formData.getId());
		model.addAttribute("employee", emp);
		return "index";
	}
	// get employee by id rest api
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
//		EmployeeDTO employeeDTO = (EmployeeDTO) employeeService.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		return ResponseEntity.ok(employeeDTO);
//	}
//
//	// update employee rest api
//
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
//		Employee employee = employeeService.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setEmailId(employeeDetails.getEmailId());
//
//		Employee updatedEmployee = employeeService.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
//
//	// delete employee rest api
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//		Employee employee = employeeService.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//		employeeService.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
//
	
}

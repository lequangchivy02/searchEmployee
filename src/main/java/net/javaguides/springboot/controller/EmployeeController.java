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

//	@GetMapping("/")
//	public String add(Model model) {
//		List<EmployeeDTO> listemployee = employeeService.listAll();
//		model.addAttribute("employee", new EmployeeDTO());
//		return "index";
//	}
//
//
//	@PostMapping("/search")
//	public String doSearchEmployee(@ModelAttribute("employeeSearchFormData") EmployeeDTO formData, Model model) {
//		EmployeeDTO emp = employeeService.get(formData.getId());
//		model.addAttribute("employee", emp);
//		return "index";
//	}
}

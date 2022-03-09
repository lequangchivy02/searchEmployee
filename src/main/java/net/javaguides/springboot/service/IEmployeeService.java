package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeDTO;
import net.javaguides.springboot.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Optional<Object> findById(Long id);

    List<EmployeeDTO> findAll();

    EmployeeDTO save(EmployeeDTO employeeDTO);

    List<EmployeeDTO> listAll();

    EmployeeDTO get(long id);
}

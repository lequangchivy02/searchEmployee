package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.converter.EmployeeConverter;
import net.javaguides.springboot.dto.EmployeeDTO;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.repository.EmployRepository;
import net.javaguides.springboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployService implements IEmployeeService {

    @Autowired
    private EmployRepository employeeRepository;

    @Autowired
    private EmployeeConverter employeeConverter;


    @Override
    public Optional<Object> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<EmployeeDTO> findAll() {
       return null;
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employeeEntity = employeeConverter.toEntity(employeeDTO);
        employeeEntity = employeeRepository.save(employeeEntity);
        return employeeConverter.toDTO(employeeEntity);
    }
    //
    @Override
    public List<EmployeeDTO> listAll() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employeeEntity = employeeConverter.toEntity(employeeDTO);
       // employeeEntity = employeeRepository.findAll();
        //return employeeConverter.toDTO(employeeEntity) ;
        return null;
    }

    @Override
    public EmployeeDTO get(long id) {
        //return employeeRepository.findById(id).get();
        return null;
    }
}

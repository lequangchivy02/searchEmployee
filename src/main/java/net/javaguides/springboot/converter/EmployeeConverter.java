package net.javaguides.springboot.converter;

import net.javaguides.springboot.dto.EmployeeDTO;
import net.javaguides.springboot.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {
    public Employee toEntity(EmployeeDTO dto){
        Employee entity = new Employee();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmailId(dto.getEmailId());
        return entity;
    }

    public EmployeeDTO toDTO(Employee entity){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmailId(entity.getEmailId());
        return dto;
    }
}

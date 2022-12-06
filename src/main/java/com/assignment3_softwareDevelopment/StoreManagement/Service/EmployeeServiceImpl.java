package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Employee;
import com.assignment3_softwareDevelopment.StoreManagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

    @Qualifier("employeeRepository")
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Object[]> getEmployeesListByStore(String storeId) {
        return employeeRepository.findEmployeesByStore(storeId);
    }

    @Override
    public List<Object[]> getManagersList() {
        return employeeRepository.findManagers();
    }

    @Override
    public Employee getOneEmployee(String id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).get();
    }

    /**
     * Method to update Employee.
     * @param empToUpdate Employee to update
     * @param emp Employee to copy
     * @param managerId Updated managerId value
     */
    @Override
    public void updateEmployee(Employee empToUpdate, Employee emp, String managerId) {
        empToUpdate.setName(emp.getName());
        empToUpdate.setSurname(emp.getSurname());
        if(!managerId.equals("")){
            if(empToUpdate.getManager()==null || !empToUpdate.getManager().getId().equals(managerId)){
                Employee manager = getOneEmployee(managerId);
                empToUpdate.setManager(manager);
            }
        } else {
            empToUpdate.setManager(null);
        }
    }
}

package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Object[]> getEmployeesListByStore(String storeId);
    List<Object[]> getManagersList();
    void saveEmployee(Employee employee);
    void deleteEmployee(String id);
    Employee findById(String id);
    Employee getOneEmployee(String id);
    void updateEmployee(Employee empToUpdate, Employee emp, String managerId);
}

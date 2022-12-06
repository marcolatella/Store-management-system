package com.assignment3_softwareDevelopment.StoreManagement.Repository;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("Select e.id, e.name, e.surname, e.manager.id from Employee as e where e.workPlace.idStore=:storeId")
    List<Object[]> findEmployeesByStore(@Param("storeId") String storeId);

    @Query("Select e.id, e.surname from Employee as e where e.manager IS NULL")
    List<Object[]> findManagers();
}

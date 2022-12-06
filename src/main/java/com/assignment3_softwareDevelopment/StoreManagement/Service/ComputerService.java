package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Computer;

import java.util.List;

public interface ComputerService {
    List<Object[]> findComputerByStore(String store);
    void updateComputer(Computer compToUpdate, Computer comp);
}

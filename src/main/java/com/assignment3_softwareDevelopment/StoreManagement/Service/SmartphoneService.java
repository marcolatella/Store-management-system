package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Smartphone;

import java.util.List;

public interface SmartphoneService {
    List<Object[]> findSmartphoneByStore(String store);
    void updateSmartphone(Smartphone smartToUpdate, Smartphone smart);
}

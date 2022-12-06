package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Store;

public interface StoreService {
    Store getStore(String id);
    boolean isPresent(String id);
    Store createStore(String storeID);

}

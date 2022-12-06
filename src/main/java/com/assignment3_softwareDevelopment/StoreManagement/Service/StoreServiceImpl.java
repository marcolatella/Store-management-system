package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Store;
import com.assignment3_softwareDevelopment.StoreManagement.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("storeService")
public class StoreServiceImpl implements StoreService{
    @Qualifier("storeRepository")
    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store getStore(String id) {
        if(isPresent(id)) {
            return storeRepository.findById(id).get();
        }else{
            return createStore(id);
        }
    }

    @Override
    public boolean isPresent(String id) {
        return storeRepository.findById(id).isPresent();
    }


    /**
     * Method to create store.
     * @param storeID ID of store to create
     * @return created store object
     */
    @Override
    public Store createStore(String storeID){
        Store s1;
        switch (storeID){
            case "100100": s1 = new Store("100100","Via Torino", "Milano"); break;
            case "100200": s1 = new Store("100200","Via Giolitti", "Bergamo");break;
            case "100300":
            default:
                s1 = new Store("100300","Via Vittorio Emanuele", "Roma"); break;
        }
        return s1;
    }
}

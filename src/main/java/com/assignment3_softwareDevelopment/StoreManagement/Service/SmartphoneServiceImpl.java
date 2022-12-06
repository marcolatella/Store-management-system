package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Smartphone;
import com.assignment3_softwareDevelopment.StoreManagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("smartphoneService")
public class SmartphoneServiceImpl implements SmartphoneService{

    @Qualifier("productRepository")
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Object[]> findSmartphoneByStore(String store) {
        return productRepository.findSmartphoneByStore(store);
    }

    /**
     * Method to update smartphone parameters. Wrapping method for the set instructions.
     * @param smartToUpdate Smartphone to update
     * @param smart Smartphone to copy
     */
    @Override
    public void updateSmartphone(Smartphone smartToUpdate, Smartphone smart) {
        smartToUpdate.setName(smart.getName());
        smartToUpdate.setBrand(smart.getBrand());
        smartToUpdate.setStorage(smart.getStorage());
        smartToUpdate.setColor(smart.getColor());
        smartToUpdate.setFiveG(smart.isFiveG());
    }
}

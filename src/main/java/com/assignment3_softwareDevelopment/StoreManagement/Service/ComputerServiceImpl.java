package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Computer;
import com.assignment3_softwareDevelopment.StoreManagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("computerService")
public class ComputerServiceImpl implements ComputerService{

    @Qualifier("productRepository")
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Object[]> findComputerByStore(String store) {
        return productRepository.findComputerByStore(store);
    }

    /**
     * Method to update computer parameters. Wrapping method for the set instructions.
     * @param compToUpdate Computer to update
     * @param comp Computer to copy
     */
    @Override
    public void updateComputer(Computer compToUpdate, Computer comp) {
        compToUpdate.setName(comp.getName());
        compToUpdate.setBrand(comp.getBrand());
        compToUpdate.setStorage(comp.getStorage());
        compToUpdate.setRam(comp.getRam());
        compToUpdate.setInches(comp.getInches());
        compToUpdate.setSsd(comp.isSsd());
    }
}

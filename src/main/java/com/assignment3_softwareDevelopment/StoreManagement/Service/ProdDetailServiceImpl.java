package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.ProdDetail;
import com.assignment3_softwareDevelopment.StoreManagement.Repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("productDetailService")
public class ProdDetailServiceImpl implements ProdDetailService{

    @Qualifier("productDetailRepository")
    @Autowired
    ProductDetailRepository prodDetailRepository;


    @Override
    public ProdDetail findById(Long id) {
        return prodDetailRepository.findById(id).get();
    }

    @Override
    public void deleteProdDetail(Long id) {
        prodDetailRepository.deleteById(id);
    }

    @Override
    public boolean isPresent(Long id) {
        return prodDetailRepository.findById(id).isPresent();
    }

    @Override
    public ProdDetail getProdDetToUpdate(Long id) {
        return prodDetailRepository.getOne(id);
    }

    @Override
    public void saveProductDet(ProdDetail pd) {
        prodDetailRepository.save(pd);
    }

    @Override
    public void updateProdDet(ProdDetail pd, int quantity, double price) {
        pd.setQuantity(quantity);
        pd.setPrice(price);
    }
}

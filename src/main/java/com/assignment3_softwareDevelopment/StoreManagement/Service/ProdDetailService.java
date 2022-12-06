package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.ProdDetail;


public interface ProdDetailService {
    ProdDetail findById(Long id);
    void deleteProdDetail(Long id);
    boolean isPresent(Long id);
    ProdDetail getProdDetToUpdate(Long id);
    void saveProductDet(ProdDetail pd);
    void updateProdDet(ProdDetail pd, int quantity, double price);
}

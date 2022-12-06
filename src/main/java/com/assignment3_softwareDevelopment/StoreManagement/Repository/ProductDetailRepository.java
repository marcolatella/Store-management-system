package com.assignment3_softwareDevelopment.StoreManagement.Repository;

import com.assignment3_softwareDevelopment.StoreManagement.Model.ProdDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productDetailRepository")
public interface ProductDetailRepository extends JpaRepository<ProdDetail, Long> {

}
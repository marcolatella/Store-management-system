package com.assignment3_softwareDevelopment.StoreManagement.Repository;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, String> {

    /**
     * SQL query to get smartphones in required store.
     * @param store ID of store to search from
     * @return list of array of objects containing the selected attributes
     */
    @Async
    @Query("SELECT pd.id, s.code, s.name, s.brand, pd.price, pd.quantity, s.storage, s.color, s.fiveG from Smartphone s left join ProdDetail as pd on s.code=pd.product.code where pd.store.idStore=:store")
    List<Object[]> findSmartphoneByStore(@Param("store") String store);

    /**
     * SQL query to get computer in required store.
     * @param store store ID of store to search from
     * @return list of array of objects containing the selected attributes
     */
    @Async
    @Query("SELECT pd.id, c.code, c.name, c.brand, pd.price, pd.quantity, c.storage, c.ram, c.inches, c.ssd from Computer c left join ProdDetail as pd on c.code=pd.product.code where pd.store.idStore=:store")
    List<Object[]> findComputerByStore(@Param("store") String store);


}

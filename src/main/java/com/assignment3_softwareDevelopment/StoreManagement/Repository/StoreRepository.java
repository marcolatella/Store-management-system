package com.assignment3_softwareDevelopment.StoreManagement.Repository;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("storeRepository")
public interface StoreRepository extends JpaRepository<Store, String> {
}

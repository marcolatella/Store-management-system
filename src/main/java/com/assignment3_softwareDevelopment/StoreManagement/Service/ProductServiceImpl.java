package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Product;
import com.assignment3_softwareDevelopment.StoreManagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Qualifier("productRepository")
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product p) { productRepository.save(p); }

    @Override
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(String id){
        Product tmp;
        if(isPresent(id))
            tmp = productRepository.findById(id).get();
        else
            tmp = null;
        return tmp;
    }

    @Override
    public Product getProdToUpdate(String id) {
        if(isPresent(id))
            return productRepository.getOne(id);
        return null;
    }

    @Override
    public boolean isPresent(String id) { return productRepository.findById(id).isPresent(); }


}

package com.assignment3_softwareDevelopment.StoreManagement.Controller;

import com.assignment3_softwareDevelopment.StoreManagement.Model.*;
import com.assignment3_softwareDevelopment.StoreManagement.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProdDetailService prodDetailService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private SmartphoneService smartphoneService;
    @Autowired
    private ComputerService computerService;

    /**
     * Method that redirect the user to the correct path
     * @return ModelAndView with starting path
     */
    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("redirect:/store/100100/products");
    }

    /**
     * Products section Home Page. This page show the list of products of selected store.
     * @param storeId ID of selected store
     * @return ModelAndView containing the products to show
     */
    @GetMapping("/store/{storeId}/products")
    public ModelAndView homeStore(@PathVariable String storeId){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home-products");
        List<Object[]> smartphones = smartphoneService.findSmartphoneByStore(storeId);
        List<Object[]> computers = computerService.findComputerByStore(storeId);

        mav.addObject("listSmartphone", smartphones);
        mav.addObject("listComputer", computers);

        return mav;
    }

    /**
     * Method that return the page for adding a new product.
     * @return ModelAndView with the add-product.jsp page containing the smartphone and computer objects.
     */
    @GetMapping("/add-product")
    public ModelAndView addProduct() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add-product");
        mav.addObject("smartphone", new Smartphone());
        mav.addObject("computer", new Computer());
        return mav;
    }

    /**
     * Method that saves the smartphone in the selected store creating the ProdDetail object
     * @param smart Smartphone to save obtained from the add-product.jsp page
     * @param storeID ID of the store in which to save the product
     * @param quantity Quantity of the product to add
     * @param price Price of the product to add
     * @return Home Page
     */
    @PostMapping("/add-product/smartphone")
    public ModelAndView saveSmartphone(@ModelAttribute("smartphone") @Valid Smartphone smart,
                                       @RequestParam String storeID, @RequestParam int quantity,
                                       @RequestParam double price) {

        Store s1 = storeService.getStore(storeID);
        ProdDetail pd1 = new ProdDetail(smart, s1, quantity, price);

        if(productService.isPresent(smart.getCode())){
            Product prod = productService.getProdToUpdate(smart.getCode());
            if(prod instanceof Smartphone) {
                Smartphone sma = (Smartphone) prod;
                ProdDetail pd2 = new ProdDetail(sma, s1, quantity, price);
                sma.add(pd2);
                productService.saveProduct(sma);
            }
            return new ModelAndView("redirect:/store/"+storeID+"/products");
        }

        smart.add(pd1);
        productService.saveProduct(smart);

        return new ModelAndView("redirect:/store/"+storeID+"/products");
    }

    /**
     * Method that saves the computer in the selected store creating the ProdDetail object
     * @param comp Computer obtained from the add-product.jsp page
     * @param storeID ID of the store in which to save the product
     * @param quantity Quantity of the product to add
     * @param price Price of the product to add
     * @return Home Page
     */
    @PostMapping("/add-product/computer")
    public ModelAndView saveComputer(@ModelAttribute("computer") @Valid Computer comp,
                                     @RequestParam String storeID, @RequestParam int quantity,
                                     @RequestParam double price){

        Store s1 = storeService.getStore(storeID);
        ProdDetail pd1 = new ProdDetail(comp, s1, quantity, price);

        if(productService.isPresent(comp.getCode())){
            Product prod = productService.getProdToUpdate(comp.getCode());
            if(prod instanceof Computer){
                Computer computer = (Computer) prod;
                ProdDetail pd2 = new ProdDetail(computer, s1, quantity, price);
                computer.add(pd2);
                productService.saveProduct(computer);
            }
            return new ModelAndView("redirect:/store/"+storeID+"/products");
        }

        comp.add(pd1);
        productService.saveProduct(comp);

        return new ModelAndView("redirect:/store/"+storeID+"/products");
    }

    /**
     * Method that delete the selected product in the selected store deleting the respectively product detail
     * @param prodDetailId ID of the product detail to delete
     * @param p_val ID of the product
     * @param storeID ID of the selected store
     * @return Home Page
     */
    @PostMapping("/store/{storeID}/delete-product/{prodDetailId}")
    public ModelAndView confirmDelete(@PathVariable("prodDetailId") Long prodDetailId, @RequestParam String p_val,
                                      @PathVariable("storeID") String storeID) {
        if(!prodDetailService.isPresent(prodDetailId) || !productService.isPresent(p_val))
            return home();
        Product prod = productService.findById(p_val);
        prodDetailService.deleteProdDetail(prodDetailId);

        if(prod.getProductDetails().isEmpty()){
            productService.deleteProduct(p_val);
        }

        return new ModelAndView("redirect:/store/"+storeID+"/products");
    }


    /**
     * Display the page containing the form to update the product
     * @param storeId ID of selected store
     * @param prodId ID of product to update
     * @param prodDetailId ID of product detail to update
     * @return ModelAndView containing set up for updating products
     */
    @GetMapping(value = "/store/{storeId}/update-product/{prodId}/{prodDetailId}")
    public ModelAndView updateProduct(@PathVariable("storeId") String storeId, @PathVariable("prodId") String prodId,
                                      @PathVariable("prodDetailId") Long prodDetailId){
        Product prod = productService.findById(prodId);
        ProdDetail pd = prodDetailService.findById(prodDetailId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("prodToEdit", prod);
        mav.addObject("prodDetToEdit", pd);
        if(prod instanceof Smartphone){
            mav.setViewName("edit-smartphone");
        } else {
            mav.setViewName("edit-computer");
        }

        return mav;
    }


    /**
     * Method that actually update the smartphone
     * @param storeId ID of selected store
     * @param prodDetailId ID of product detail to update
     * @param smart Smartphone updated obtained from edit-smartphone.jsp
     * @param quantity Updated quantity value
     * @param price Updated price value
     * @return Home Page
     */
    @PostMapping(value = "/store/{storeId}/update-smartphone/{prodDetailId}")
    public ModelAndView updateSmart(@PathVariable("storeId") String storeId,
                                    @PathVariable("prodDetailId") Long prodDetailId,
                                    @ModelAttribute("prodToEdit") @Valid Smartphone smart, @RequestParam int quantity,
                                    @RequestParam double price) {
        Smartphone smartToUpdate = (Smartphone) productService.getProdToUpdate(smart.getCode());
        smartphoneService.updateSmartphone(smartToUpdate, smart);
        productService.saveProduct(smartToUpdate);

        ProdDetail pd = prodDetailService.getProdDetToUpdate(prodDetailId);
        prodDetailService.updateProdDet(pd,quantity,price);
        prodDetailService.saveProductDet(pd);
        return new ModelAndView("redirect:/store/"+storeId+"/products");
    }

    /**
     * Method that actually update the computer
     * @param storeId ID of selected store
     * @param prodDetailId ID of product detail to update
     * @param comp Computer updated obtained from edit-computer.jsp
     * @param quantity Updated quantity value
     * @param price Updated price value
     * @return Home Page
     */
    @PostMapping(value = "/store/{storeId}/update-computer/{prodDetailId}")
    public ModelAndView updateComp(@PathVariable("storeId") String storeId,
                                   @PathVariable("prodDetailId") Long prodDetailId,
                                   @ModelAttribute("prodToEdit") @Valid Computer comp, @RequestParam int quantity,
                                   @RequestParam double price) {
        Computer compToUpdate = (Computer) productService.getProdToUpdate(comp.getCode());
        computerService.updateComputer(compToUpdate, comp);
        productService.saveProduct(compToUpdate);

        ProdDetail pd = prodDetailService.getProdDetToUpdate(prodDetailId);
        prodDetailService.updateProdDet(pd,quantity,price);
        prodDetailService.saveProductDet(pd);
        return new ModelAndView("redirect:/store/"+storeId+"/products");
    }

}

package com.assignment3_softwareDevelopment.StoreManagement.Controller;

import com.assignment3_softwareDevelopment.StoreManagement.Model.*;
import com.assignment3_softwareDevelopment.StoreManagement.Service.EmployeeService;
import com.assignment3_softwareDevelopment.StoreManagement.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StoreService storeService;

    /**
     * Employees section Home Page. This page show the list of employees of selected store.
     * @param storeId ID of selected store
     * @return ModelAndView containing the employees to show
     */
    @GetMapping(value = "/store/{storeId}/employees")
    public ModelAndView showEmployeesPage(@PathVariable("storeId") String storeId){
        ModelAndView mav = new ModelAndView("employees");
        List<Object[]> employeesList = employeeService.getEmployeesListByStore(storeId);
        mav.addObject("employeesList", employeesList);
        return mav;
    }

    /**
     * Method that return the page for adding a new employee.
     * @return ModelAndView with the add-employee.jsp page containing the employee and manager list objects.
     */
    @GetMapping("/add-employee")
    public ModelAndView addEmployee() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add-employee");
        mav.addObject("employee", new Employee());
        List<Object[]> managersList = employeeService.getManagersList();
        mav.addObject("managersList", managersList);
        return mav;
    }

    /**
     * Method that saves the employee in the selected store
     * @param emp Employee to save obtained from add-employee.jsp page
     * @param storeID ID of the store in which to save the employee
     * @param managerId ID of manager to assign to the employee
     * @return
     */
    @PostMapping("/add-employee/save")
    public ModelAndView saveEmployee(@ModelAttribute("employee") @Valid Employee emp, @RequestParam String storeID,
                                     @RequestParam String managerId) {

        Store store = storeService.getStore(storeID);

        if(!managerId.equals("")){
            Employee manager = employeeService.getOneEmployee(managerId);
            emp.setManager(manager);
        }

        emp.setWorkPlace(store);
        employeeService.saveEmployee(emp);

        return new ModelAndView("redirect:/store/"+storeID+"/employees");
    }

    /**
     * Method that delete the selected employee in the selected store
     * @param id_empl ID of the employee to delete
     * @param storeId ID of selected store
     * @return Employees section Home Page
     */
    @PostMapping("/store/{storeId}/delete-employee/{id_empl}")
    public ModelAndView deleteEmployee(@PathVariable("id_empl") String id_empl,
                                       @PathVariable("storeId") String storeId) {

        List<Employee> sub = employeeService.getOneEmployee(id_empl).getSubordinates();

        if(sub.isEmpty())
            employeeService.deleteEmployee(id_empl);

        return new ModelAndView("redirect:/store/"+storeId+"/employees");
    }

    /**
     * Display the page containing the form to update the employee
     * @param id_emp ID of employee to update
     * @param storeId ID of selected store
     * @return ModelAndView containing set up for updating employees
     */
    @GetMapping(value = "/store/{storeId}/update-employee/{id_emp}")
    public ModelAndView updateEmployee(@PathVariable("id_emp") String id_emp, @PathVariable("storeId") String storeId){
        ModelAndView mav = new ModelAndView();

        Employee empToEdit = employeeService.findById(id_emp);
        mav.addObject("empToEdit", empToEdit);

        List<Object[]> managersList = employeeService.getManagersList();
        mav.addObject("managersList", managersList);

        mav.setViewName("edit-employee");
        return mav;
    }

    /**
     * Method that actually update the employee
     * @param emp Employee updated obtained from edit-employee.jsp
     * @param managerId Updated managerId value
     * @param storeId ID of selected store
     * @return Employees section Home Page
     */
    @PostMapping("/store/{storeId}/update-employee")
    public ModelAndView saveModifyEmployee(@ModelAttribute("employee") @Valid Employee emp,
                                           @RequestParam String managerId, @PathVariable("storeId") String storeId) {

        Employee empToUpdate = employeeService.getOneEmployee(emp.getId());
        employeeService.updateEmployee(empToUpdate, emp, managerId);
        employeeService.saveEmployee(empToUpdate);

        return new ModelAndView("redirect:/store/"+storeId+"/employees");
    }
}

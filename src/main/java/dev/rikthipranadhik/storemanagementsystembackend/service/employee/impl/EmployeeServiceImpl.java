package dev.rikthipranadhik.storemanagementsystembackend.service.employee.impl;

import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.HourlyEmployee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.store.Store;
import dev.rikthipranadhik.storemanagementsystembackend.repository.employee.EmployeeRepository;
import dev.rikthipranadhik.storemanagementsystembackend.repository.employee.HourlyEmployeeRepository;
import dev.rikthipranadhik.storemanagementsystembackend.repository.store.StoreRepository;
import dev.rikthipranadhik.storemanagementsystembackend.service.employee.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

     private final EmployeeRepository employeeRepository;
     private final HourlyEmployeeRepository hourlyEmployeeRepository;
     private final StoreRepository storeRepository;

     public EmployeeServiceImpl(EmployeeRepository employeeRepository, StoreRepository storeRepository, HourlyEmployeeRepository hourlyEmployeeRepository) {
         this.employeeRepository = employeeRepository;
         this.storeRepository = storeRepository;
         this.hourlyEmployeeRepository = hourlyEmployeeRepository;
     }

    @Override
    public List<Employee> listAllEmployees(Long storeId) {
        return employeeRepository.findByStoreId(storeId);
    }

    @Override
    public HourlyEmployee createHourlyEmployee(HourlyEmployee hourlyEmployee) {
         return hourlyEmployeeRepository.save(hourlyEmployee);
    }


    @Override
    public Employee createEmployee(Employee employee, Integer supervisorId, Long storeId) {
        if (employee.getId() != null){
            throw new IllegalArgumentException("Employee Already has an ID");
        }

        if (employee.getName() == null || employee.getName().isEmpty()){
            throw new IllegalArgumentException("Employee Name is Empty");
        }

        Store store;
        if (storeId != null){
            store = storeRepository.findById(storeId).orElse(null);
        }else{
            throw new  IllegalArgumentException("Store Id is Empty");
        }

        if (store == null){
            throw new  IllegalArgumentException("Store doesn't exist");
        }

        Employee supervisor = null;

        if (supervisorId != null){
            supervisor = employeeRepository.findById(supervisorId).orElse(null);
        }

        return (new Employee(
                null,
                employee.getName(),
                employee.getGender(),
                employee.getPhoneNumber(),
                employee.getDateOfBirth(),
                employee.getEmailAddress(),
                employee.getAddress(),
                supervisor,
                store
        ));
    }

    @Override
    public Employee getEmployeeById(Long storeId, Integer id){

         return employeeRepository.findById(id)
                 .orElseThrow(
                         ()->new IllegalArgumentException("Employee Not Found")
                 );
    }

    public Employee getEmployeeByEmailAddress(String emailAddress){
         return employeeRepository.findByEmailAddress(emailAddress)
                 .orElseThrow(
                         () -> new IllegalArgumentException("Employee Not Found")
                 );
    }


}

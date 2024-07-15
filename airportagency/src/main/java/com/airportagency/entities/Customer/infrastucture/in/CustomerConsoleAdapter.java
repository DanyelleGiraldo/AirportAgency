package com.airportagency.entities.Customer.infrastucture.in;

import java.util.Scanner;

import com.airportagency.entities.Customer.application.CustomerCreateService;
import com.airportagency.entities.Customer.application.CustomerDeleteService;
import com.airportagency.entities.Customer.application.CustomerGetAllService;
import com.airportagency.entities.Customer.application.CustomerSearchService;
import com.airportagency.entities.Customer.application.CustomerUpdateService;

public class CustomerConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final CustomerCreateService customerCreateService;
    private final CustomerUpdateService customerUpdateService;
    private final CustomerDeleteService customerDeleteService;
    private final CustomerSearchService customerSearchService;
    private final CustomerGetAllService customerGetAllService;

    public CustomerConsoleAdapter(CustomerCreateService customerCreateService,
            CustomerUpdateService customerUpdateService, CustomerDeleteService customerDeleteService,
            CustomerSearchService customerSearchService, CustomerGetAllService customerGetAllService) {
        this.customerCreateService = customerCreateService;
        this.customerUpdateService = customerUpdateService;
        this.customerDeleteService = customerDeleteService;
        this.customerSearchService = customerSearchService;
        this.customerGetAllService = customerGetAllService;
    }

    public void CreateCustomer(){
        String rta = "S";

        white(rta.equalsIgnoreCase("S")){
            System.out.println();
        }
    }
}

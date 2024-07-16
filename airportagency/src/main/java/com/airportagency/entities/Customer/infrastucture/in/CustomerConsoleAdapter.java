package com.airportagency.entities.Customer.infrastucture.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.Customer.application.CustomerCreateService;
import com.airportagency.entities.Customer.application.CustomerDeleteService;
import com.airportagency.entities.Customer.application.CustomerGetAllService;
import com.airportagency.entities.Customer.application.CustomerSearchService;
import com.airportagency.entities.Customer.application.CustomerUpdateService;
import com.airportagency.entities.Customer.domain.entity.Customer;

public class CustomerConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final CustomerCreateService customerCreateService;
    private final CustomerUpdateService customerUpdateService;
    private final CustomerDeleteService customerDeleteService;
    private final CustomerSearchService customerSearchService;
    private final CustomerGetAllService customerGetAllService;

    public CustomerConsoleAdapter(CustomerCreateService customerCreateService,
                                  CustomerUpdateService customerUpdateService, 
                                  CustomerDeleteService customerDeleteService,
                                  CustomerSearchService customerSearchService, 
                                  CustomerGetAllService customerGetAllService) {
        this.customerCreateService = customerCreateService;
        this.customerUpdateService = customerUpdateService;
        this.customerDeleteService = customerDeleteService;
        this.customerSearchService = customerSearchService;
        this.customerGetAllService = customerGetAllService;
    }

    public void createCustomer(){
        String rta = "S";

        while(rta.equalsIgnoreCase("S")){
            System.out.println("REGISTRAR CLIENTE");
            System.out.println("INGRESE EL ID DEL CLIENTE: ");
            String id = sc.nextLine();
            Optional<Customer> customer = customerSearchService.getCustomerById(id);
            customer.ifPresentOrElse(
                as -> System.out.println(MessageFormat.format("EL ID {0} YA ESTÁ OCUPADO.", as.getId())),
                () -> {
                    System.out.println("INGRESE EL NOMBRE DEL CLIENTE:");
                    String customerName = sc.nextLine();

                    System.out.println("INGRESE EL APELLIDO DEL CLIENTE:");
                    String customerLastName = sc.nextLine();

                    System.out.println("INGRESE LA EDAD DEL CLIENTE:");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.println("INGRESE EL NÚMERO DE DOCUMENTO DEL CLIENTE:");
                    int documentNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.println("INGRESE EL ID DEL TIPO DE DOCUMENTO:");
                    int idDocumentType = sc.nextInt();
                    sc.nextLine();

                    Customer newCustomer = new Customer(id, customerName, customerLastName, age, documentNumber, idDocumentType);
                    customerCreateService.createCustomer(newCustomer);
                }
            );
            System.out.println("DESEA AÑADIR OTRO CLIENTE? [S] - SI | [CUALQUIER TECLA] - NO");
            rta = sc.nextLine();
        }
    }

    public void searchCustomer(){
        List<Customer> customers = customerGetAllService.getAllCustomers();

        if (customers.isEmpty()){
            System.out.println("NO HAY NINGÚN CLIENTE REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("BUSCAR CLIENTE");
            System.out.println("INGRESE EL ID DEL CLIENTE A BUSCAR: ");
            String searchId = sc.nextLine();

            Optional<Customer> customer = customerSearchService.getCustomerById(searchId);
            customer.ifPresentOrElse(
                c -> {
                    System.out.println("CLIENTE");
                    System.out.println(MessageFormat.format("ID: {0}\nNOMBRE: {1}\nAPELLIDO: {2}\nEDAD: {3}\nNUMERO DE DOCUMENTO: {4}\nTIPO DE DOCUMENTO: {5}",
                            c.getId(), c.getName(), c.getLastName(), c.getAge(), c.getDocumentNumber(), c.getIdDocumentType()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("CLIENTE NO ENCONTRADO");
                    sc.nextLine();
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void updateCustomer(){
        List<Customer> customers = customerGetAllService.getAllCustomers();

        if (customers.isEmpty()){
            System.out.println("NO HAY NINGÚN CLIENTE REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL CLIENTE A ACTUALIZAR: ");
            String searchId = sc.nextLine();

            Optional<Customer> customer = customerSearchService.getCustomerById(searchId);
            customer.ifPresentOrElse(
                c -> {
                    System.out.println("ACTUALIZAR CLIENTE");
                    System.out.println(MessageFormat.format("ID: {0}\nNOMBRE: {1}\nAPELLIDO: {2}\nEDAD: {3}\nNUMERO DE DOCUMENTO: {4}\nTIPO DE DOCUMENTO: {5}",
                            c.getId(), c.getName(), c.getLastName(), c.getAge(), c.getDocumentNumber(), c.getIdDocumentType()));

                    System.out.println("INGRESE EL NUEVO NOMBRE DEL CLIENTE:");
                    String customerName = sc.nextLine();

                    System.out.println("INGRESE EL NUEVO APELLIDO DEL CLIENTE:");
                    String customerLastName = sc.nextLine();

                    System.out.println("INGRESE LA NUEVA EDAD DEL CLIENTE:");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.println("INGRESE EL NUEVO NÚMERO DE DOCUMENTO DEL CLIENTE:");
                    int documentNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.println("INGRESE EL NUEVO ID DEL TIPO DE DOCUMENTO:");
                    int idDocumentType = sc.nextInt();
                    sc.nextLine();

                    Customer updatedCustomer = new Customer(c.getId(), customerName, customerLastName, age, documentNumber, idDocumentType);
                    customerUpdateService.updateCustomer(updatedCustomer);

                    System.out.println("CLIENTE ACTUALIZADO CORRECTAMENTE.");
                },
                () -> {
                    System.out.println("CLIENTE NO ENCONTRADO");
                    sc.nextLine();
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void deleteCustomer(){
        List<Customer> customers = customerGetAllService.getAllCustomers();

        if (customers.isEmpty()){
            System.out.println("NO HAY NINGÚN CLIENTE REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL CLIENTE A ELIMINAR: ");
            String searchId = sc.nextLine();

            Optional<Customer> customer = customerSearchService.getCustomerById(searchId);
            customer.ifPresentOrElse(
                c -> {
                    customerDeleteService.deleteCustomer(searchId);
                    System.out.println("CLIENTE ELIMINADO CORRECTAMENTE.");
                },
                () -> {
                    System.out.println("CLIENTE NO ENCONTRADO");
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getAllCustomers(){
        List<Customer> customers = customerGetAllService.getAllCustomers();

        if (customers.isEmpty()){
            System.out.println("NO HAY NINGÚN CLIENTE REGISTRADO");
            sc.nextLine();
        } else {
            customerGetAllService.getAllCustomers().forEach(c -> {
                System.out.println(MessageFormat.format("ID: {0}\nNOMBRE: {1}\nAPELLIDO: {2}\nEDAD: {3}\nNUMERO DE DOCUMENTO: {4}\nTIPO DE DOCUMENTO: {5}",
                        c.getId(), c.getName(), c.getLastName(), c.getAge(), c.getDocumentNumber(), c.getIdDocumentType()));
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }
}

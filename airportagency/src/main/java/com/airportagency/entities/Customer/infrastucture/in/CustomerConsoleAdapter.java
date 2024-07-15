package com.airportagency.entities.Customer.infrastucture.in;

import java.util.Scanner;

import com.airportagency.entities.Customer.application.CustomerCreateService;

public class CustomerConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final CustomerCreateService customerCreateService;
    private final CustomerUpdateService customerUpdateService;
}

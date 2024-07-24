package com.airportagency.entities.PaymentMethod.infrastructure.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.airportagency.entities.PaymentMethod.application.PaymentMethodService;
import com.airportagency.entities.PaymentMethod.domain.entity.PaymentMethod;

public class PaymentMethodConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final PaymentMethodService paymentMethodService;

    

    public PaymentMethodConsoleAdapter(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    public void createPayMethod() {
        String rta = "S";

        while (rta.equalsIgnoreCase("S")) {
            System.out.println("REGISTRAR METODO DE PAGO");
            System.out.println("INGRESE EL ID DEL METODO DE PAGO A CREAR: ");
            int id = sc.nextInt();
            Optional<PaymentMethod> paymentMethod = paymentMethodService.getPayMethodById(id);
            paymentMethod.ifPresentOrElse(
                c -> {
                    System.out.println(MessageFormat.format("EL ID (0) YA ESTA OCUPADO.", c.getId()));
                },
                () -> {
                    System.out.println("REGISTRAR METODO DE PAGO");

                    System.out.println("INGRESE EL NOMBRE DEL METODO DE PAGO: ");
                    String paymentMethodName = sc.nextLine();
    
                    PaymentMethod newPaymentMethod = new PaymentMethod(id, paymentMethodName);
                    paymentMethodService.createPayMethod(newPaymentMethod);
                });

            System.out.println("DESEA AÑADIR OTRO METODO DE PAGO? [S] - SI | [INGRESE CUALQUIER TECLA] - NO");
            rta = sc.nextLine();
        }
    }

    public void searchPaymentMethod() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllPayMethods();
        
        if (paymentMethods.isEmpty()) {
            System.out.println("NO HAY NINGUN METODO DE PAGO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("BUSCAR METODO DE PAGO");
            System.out.println("INGRESE EL ID DEL METODO DE PAGO A BUSCAR: ");
            int id = sc.nextInt();

            Optional<PaymentMethod> paymentMethod = paymentMethodService.getPayMethodById(id);
            paymentMethod.ifPresentOrElse(
                p -> {
                    System.out.println("METODO DE PAGO");
                    System.out.println(MessageFormat.format(" ID : {0}\nMETODO PAGO : {1}", p.getId(), p.getPaymentMethod()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("METODO DE PAGO NO ENCONTRADO");
                    sc.nextLine();
                });
                System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                sc.nextLine();
        }
    }

    public void getAllPayMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllPayMethods();
        
        if (paymentMethods.isEmpty()) {
            System.out.println("NO HAY NINGUN METODO DE PAGO REGISTRADO");
            sc.nextLine();
        } else {
            paymentMethodService.getAllPayMethods().forEach(p -> {
               System.out.println(MessageFormat.format("ID : {0}\nMETODO PAGO : {1}", p.getId(), p.getPaymentMethod()));
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }
}

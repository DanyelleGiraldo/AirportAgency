package com.airportagency.entities.employee.infrastucture.in;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.employee.application.EmployeeService;
import com.airportagency.entities.employee.domain.entity.Employee;


public class EmployeeConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final EmployeeService employeeService;

    

    public EmployeeConsoleAdapter(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void createEmployee() {
        String rta = "S";

        while (rta.equalsIgnoreCase("S")) {
            System.out.println("REGISTRAR EMPLEADO");
            System.out.println("INGRESE EL ID DEL EMPLEADO A CREAR: ");
            String id = sc.nextLine();
            Optional<Employee> employee = employeeService.getEmployeeById(id);
            employee.ifPresentOrElse(
                c -> {
                    System.out.println(MessageFormat.format("EL ID (0) YA ESTA OCUPADO.", c.getId()));
                },
                () -> {
                    System.out.println("REGISTRAR EMPLEADO");

                    System.out.println("INGRESE EL NOMBRE DEL EMPLEADO: ");
                    String employeeName = sc.nextLine();
    
                    System.out.println("INGRESE EL APELLIDO DEL EMPLEADO: ");
                    String employeeLastName = sc.nextLine();
    
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate employeeIngress = null;
                    boolean isActiveDate = false;
                    String newDate = "";
                    while (!isActiveDate) {
                        System.out.println("INGRESE LA FECHA DE INGRESO DEL EMPLEADO: ");
                        newDate = sc.nextLine();
                        try {
                            employeeIngress = LocalDate.parse(newDate, formatter);
                            isActiveDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Fecha ingresada no válida. Use el formato dd-MM-yyyy.");
                        }
                    }
    
                    System.out.println("INGRESE EL ROL DEL EMPLEADO: ");
                    String employeeRole = sc.nextLine();

                    System.out.println("INGRESE LA AEREOLINEA DEL EMPLEADO: ");
                    String employeeAirline = sc.nextLine();

                    System.out.println("INGRESE EL AEREOPUERTO DEL EMPLEADO: ");
                    String employeeAirport = sc.nextLine();
    
                    Employee newEmployee = new Employee(id, employeeName, employeeLastName, employeeIngress, employeeRole, employeeAirline, employeeAirport);
                    employeeService.createEmployee(newEmployee);
                });

            System.out.println("DESEA AÑADIR OTRO EMPLEADO? [S] - SI | [INGRESE CUALQUIER TECLA] - NO");
            rta = sc.nextLine();
        }
    }

    public void searchEmployee() {
        List<Employee> Employees = employeeService.getAllEmployees();
        
        if (Employees.isEmpty()) {
            System.out.println("NO HAY NINGUN EMPLEADO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("BUSCAR EMPLEADO");
            System.out.println("INGRESE EL ID DEL EMPLEADO A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<Employee> Employee = employeeService.getEmployeeById(findId);
            Employee.ifPresentOrElse(
                e -> {
                    System.out.println("EMPLEADO");
                    System.out.println(MessageFormat.format("ID : {0}\nNOMBRE : {1}\nAPELLIDO : {2}\nFECHA DE INGRESO: {3}\n ROL : {4}\n AEREOLINEA : {5}\n AEREOPUERTO : {6}", e.getId(), e.getName() + e.getLastName(), e.getIngressDate(), e.getIdRole(), e.getIdAirline(), e.getIdAirport()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("EMPLEADO NO ENCONTRADO");
                    sc.nextLine();
                });
                System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                sc.nextLine();
        }
    }

    public void updateEmployee() {
        List<Employee> Employees = employeeService.getAllEmployees();

        if (Employees.isEmpty()) {
            System.out.println("NO HAY NINGUN EMPLEADO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL EMPLEADO A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<Employee> Employee = employeeService.getEmployeeById(findId);
            Employee.ifPresentOrElse(
            c -> {
                System.out.println("REGISTRAR EMPLEADO");

                System.out.println("INGRESE EL NOMBRE DEL EMPLEADO: ");
                String employeeName = sc.nextLine();

                System.out.println("INGRESE EL APELLIDO DEL EMPLEADO: ");
                String employeeLastName = sc.nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate employeeIngress = null;
                    boolean isActiveDate = false;
                    String newDate = "";
                    while (!isActiveDate) {
                        System.out.println("INGRESE LA FECHA DE INGRESO DEL EMPLEADO: ");
                        newDate = sc.nextLine();
                        try {
                            employeeIngress = LocalDate.parse(newDate, formatter);
                            isActiveDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Fecha ingresada no válida. Use el formato dd-MM-yyyy.");
                        }
                    }
                

                System.out.println("INGRESE EL ROL DEL EMPLEADO: ");
                String employeeRole = sc.nextLine();

                System.out.println("INGRESE LA AEREOLINEA DEL EMPLEADO: ");
                String employeeAirline = sc.nextLine();

                System.out.println("INGRESE EL AEREOPUERTO DEL EMPLEADO: ");
                String employeeAirport = sc.nextLine();

                Employee newEmployee = new Employee(findId, employeeName, employeeLastName, employeeIngress, employeeRole, employeeAirline, employeeAirport);
                employeeService.updateEmployee(newEmployee);

                System.out.println("EMPLEADO ACTUALIZADO CORRECTAMENTE.");
                sc.nextLine();
            },
            () -> {
                System.out.println("EMPLEADO NO ENCONTRADO");
                sc.nextLine();
            }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void deleteEmployee() {
        List<Employee> employees = employeeService.getAllEmployees();
        
        if (employees.isEmpty()) {
            System.out.println("NO HAY NINGUN EMPLEADO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL EMPLEADO A ELIMINAR: ");
            String findId = sc.nextLine();

            Optional<Employee> employee = employeeService.getEmployeeById(findId);
            employee.ifPresentOrElse(
                c -> {
                    employeeService.deleteEmployee(findId);
                    System.out.println("EMPLEADO ELIMINADO CORRECTAMENTE.");
                    sc.nextLine();
                },
                () -> {
                    System.out.println("EMPLEADO NO ENCONTRADO");
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        
        if (employees.isEmpty()) {
            System.out.println("NO HAY NINGUN EMPLEADO REGISTRADO");
            sc.nextLine();
        } else {
            employeeService.getAllEmployees().forEach(e -> {
               System.out.println(MessageFormat.format("ID : {0}\nNOMBRE : {1}\nAPELLIDO : {2}\nFECHA DE INGRESO: {3}\n ROL : {4}\n AEREOLINEA : {5}\n AEREOPUERTO : {6}", e.getId(), e.getName() + e.getLastName(), e.getIngressDate(), e.getIdRole(), e.getIdAirline(), e.getIdAirport()));
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }
    
}
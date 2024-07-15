package com.airportagency.entities.Country.infrastucture.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.Country.application.CountryCreateService;
import com.airportagency.entities.Country.application.CountryDeleteService;
import com.airportagency.entities.Country.application.CountryGetAllService;
import com.airportagency.entities.Country.application.CountrySearchService;
import com.airportagency.entities.Country.application.CountryUpdateService;
import com.airportagency.entities.Country.domain.entity.Country;

public class CountryConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final CountryCreateService countryCreateService;
    private final CountryUpdateService countryUpdateService;
    private final CountryDeleteService countryDeleteService;
    private final CountrySearchService countrySearchService;
    private final CountryGetAllService countryGetAllService;

    public CountryConsoleAdapter(CountryCreateService countryCreateService, CountryUpdateService countryUpdateService,
            CountryDeleteService countryDeleteService, CountrySearchService countrySearchService,
            CountryGetAllService countryGetAllService) {
        this.countryCreateService = countryCreateService;
        this.countryUpdateService = countryUpdateService;
        this.countryDeleteService = countryDeleteService;
        this.countrySearchService = countrySearchService;
        this.countryGetAllService = countryGetAllService;
    }

    public void createCountry(){
        String rta = "S";

        while (rta.equalsIgnoreCase("S")) {
            System.out.println("REGISTRAR PAIS");
            System.out.println("INGRESE EL ID DEL PAIS A CREAR: ");
            String id = sc.nextLine();
            Optional<Country> country = countrySearchService.getCountryById(id);
            country.ifPresentOrElse(
                c -> {
                    System.out.println(MessageFormat.format("EL ID (0) YA ESTA OCUPADO.", c.getId()));
                },
                () -> {
                    System.out.println("REGISTRAR PAIS ***************");
            
                    System.out.println("INGRESE EL NOMBRE DEL PAIS: ");
                    String countryName = sc.nextLine();
            
                    Country newCountry = new Country(id, countryName);
                    countryCreateService.createCountry(newCountry);
                });

            System.out.println("DESEA AÑADIR OTRO PAIS? [S] - SI | [INGRESE CUALQUIER TECLA] - NO");
            rta = sc.nextLine();
        }
    }

    public void searchCountry() {
        List<Country> countries = countryGetAllService.getAllCountries();
        
        if (countries.isEmpty()) {
            System.out.println("NO HAY NINGUN PAIS REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("BUSCAR PAIS");
            System.out.println("INGRESE EL ID DEL PAIS A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<Country> country = countrySearchService.getCountryById(findId);
            country.ifPresentOrElse(
                c -> {
                    System.out.println("PAIS");
                    System.out.println(MessageFormat.format("ID : {0}\n PAIS : {1}", c.getId(), c.getCountryName()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("PAIS NO ENCONTRADO");
                    sc.nextLine();
                });
                System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                sc.nextLine();
        }
    }

    public void updateCountry() {
        List<Country> Countrys = countryGetAllService.getAllCountries();

        if (Countrys.isEmpty()) {
            System.out.println("NO HAY NINGUN PAIS REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL PAIS A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<Country> Country = countrySearchService.getCountryById(findId);
            Country.ifPresentOrElse(
            c -> {
                System.out.println("ACTUALIZAR PAIS");
                System.out.println(MessageFormat.format("ID : {0}\n PAIS : {1}", c.getId(), c.getCountryName()));

                System.out.println("INGRESE EL NOMBRE DEL PAIS: ");
                String countryName = sc.nextLine();
            
                Country updatedCountry = new Country(c.getId(), countryName);
                countryUpdateService.updateCountry(updatedCountry);
                sc.nextLine();

                System.out.println("PAIS ACTUALIZADO CORRECTAMENTE.");
                sc.nextLine();
            },
            () -> {
                System.out.println("PAIS NO ENCONTRADO");
                sc.nextLine();
            }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }


    public void deleteCountry() {
        List<Country> countries = countryGetAllService.getAllCountries();
        
        if (countries.isEmpty()) {
            System.out.println("NO HAY NINGUN PAIS REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL PAIS A ELIMINAR: ");
            String findId = sc.nextLine();

            Optional<Country> country = countrySearchService.getCountryById(findId);
            country.ifPresentOrElse(
                c -> {
                    countryDeleteService.deleteCountry(findId);
                    System.out.println("PAIS ELIMINADO CORRECTAMENTE.");
                    sc.nextLine();
                },
                () -> {
                    System.out.println("PAIS NO ENCONTRADO");
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getAllCountries() {
        List<Country> countries = countryGetAllService.getAllCountries();
        
        if (countries.isEmpty()) {
            System.out.println("NO HAY NINGUN PAIS REGISTRADO");
            sc.nextLine();
        } else {
            countryGetAllService.getAllCountries().forEach(c -> {
               System.out.println(MessageFormat.format("ID : {0}\n PAIS : {1}", c.getId(), c.getCountryName())); 
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }
}

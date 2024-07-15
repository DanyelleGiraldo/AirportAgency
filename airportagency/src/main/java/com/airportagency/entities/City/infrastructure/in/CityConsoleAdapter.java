package com.airportagency.entities.City.infrastructure.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.City.application.CityCreateService;
import com.airportagency.entities.City.application.CityDeleteService;
import com.airportagency.entities.City.application.CityGetAllService;
import com.airportagency.entities.City.application.CitySearchService;
import com.airportagency.entities.City.application.CityUpdateService;
import com.airportagency.entities.City.domain.entity.City;

public class CityConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final CityCreateService CityCreateService;
    private final CityDeleteService cityDeleteService;
    private final CityGetAllService cityGetAllService;
    private final CitySearchService citySearchService;
    private final CityUpdateService cityUpdateService;

    public CityConsoleAdapter(com.airportagency.entities.City.application.CityCreateService cityCreateService,
            CityDeleteService cityDeleteService, CityGetAllService cityGetAllService,
            CitySearchService citySearchService, CityUpdateService cityUpdateService) {
        CityCreateService = cityCreateService;
        this.cityDeleteService = cityDeleteService;
        this.cityGetAllService = cityGetAllService;
        this.citySearchService = citySearchService;
        this.cityUpdateService = cityUpdateService;
    }

    public void createCity() {
        String rta = "S";

        while (rta.equalsIgnoreCase("S")) {
            System.out.println("REGISTRAR CIUDAD ");
            System.out.println("INGRESE EL ID DE LA CIUDAD A CREAR: ");
            String id = sc.nextLine();
            Optional<City> city = citySearchService.getCityById(id);
            city.ifPresentOrElse(
                c -> {
                    System.out.println(MessageFormat.format("EL ID (0) YA ESTA OCUPADO.", c.getId()));
                },
                () -> {
                    System.out.println("REGISTRAR CIUDAD");
            
                    System.out.println("INGRESE EL NOMBRE DE LA CIUDAD: ");
                    String cityName = sc.nextLine();
            
                    System.out.println("INGRESE EL ID DEL PAIS DE LA CIUDAD: ");
                    String countryCity = sc.nextLine();
                
                    City newCity = new City(id, cityName, countryCity);
                    CityCreateService.createCity(newCity);
                });

            System.out.println("DESEA AÑADIR OTRO CIUDAD? [S] - SI | [INGRESE CUALQUIER TECLA] - NO");
            rta = sc.nextLine();
        }
    }

    public void searchCity() {
        List<City> citys = cityGetAllService.getAllCities();
        
        if (citys.isEmpty()) {
            System.out.println(" NO HAY NINGUNA CIUDAD REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("BUSCAR CIUDAD");
            System.out.println("INGRESE EL ID DEL CIUDAD A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<City> city = citySearchService.getCityById(findId);
            city.ifPresentOrElse(
                c -> {
                    System.out.println("CIUDAD");
                    System.out.println(MessageFormat.format("ID : {0}\n CIUDAD : {1}\n PAIS : {2}", c.getId(), c.getCityName(), c.getCountryCity()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("CIUDAD NO ENCONTRADA");
                    sc.nextLine();
                });
                System.out.println("  PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                sc.nextLine();
        }
    }

    public void updateCity() {
        List<City> cities = cityGetAllService.getAllCities();

        if (cities.isEmpty()) {
            System.out.println("NO HAY NINGUN CLIENTE REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL CLIENTE A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<City> city = citySearchService.getCityById(findId);
            city.ifPresentOrElse(
            c -> {
                System.out.println("ACTUALIZAR CLIENTE");
                System.out.println(MessageFormat.format("ID : {0}\n CIUDAD : {1}\n PAIS : {2}", c.getId(), c.getCityName(), c.getCountryCity()));

                System.out.println("INGRESE EL NOMBRE DE LA CIUDAD: ");
                String cityName = sc.nextLine();
        
                System.out.println("INGRESE EL ID DEL PAIS DE LA CIUDAD: ");
                String countryCity = sc.nextLine();
            
                City updatedCity = new City(c.getId(), cityName, countryCity);
                cityUpdateService.updateCity(updatedCity);
                sc.nextLine();

                System.out.println("CLIENTE ACTUALIZADO CORRECTAMENTE.");
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

    public void deleteCity() {
        List<City> cities = cityGetAllService.getAllCities();
        
        if (cities.isEmpty()) {
            System.out.println("NO HAY NINGUN CIUDAD REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL CIUDAD A ELIMINAR: ");
            String findId = sc.nextLine();

            Optional<City> city = citySearchService.getCityById(findId);
            city.ifPresentOrElse(
                c -> {
                    cityDeleteService.deleteCity(findId);
                    System.out.println("CIUDAD ELIMINADO CORRECTAMENTE.");
                    sc.nextLine();
                },
                () -> {
                    System.out.println("CIUDAD NO ENCONTRADO");
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getAllCitys() {
        List<City> cities = cityGetAllService.getAllCities();
        
        if (cities.isEmpty()) {
            System.out.println("NO HAY NINGUNA CIUDAD REGISTRADO");
            sc.nextLine();
        } else {
            cityGetAllService.getAllCities().forEach(c -> {
               System.out.println(MessageFormat.format("ID : {0}\n CIUDAD : {1}\n PAIS : {2}", c.getId(), c.getCityName(), c.getCountryCity())); 
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }
}

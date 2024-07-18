package com.airportagency.entities.user.infrastucture.in;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.user.aplication.CreateUserUseCase;
import com.airportagency.entities.user.aplication.DelateUserUseCase;
import com.airportagency.entities.user.aplication.FindUserUseCase;
import com.airportagency.entities.user.aplication.ReadUsersUseCase;
import com.airportagency.entities.user.aplication.UpdateUserUseCase;
import com.airportagency.entities.user.aplication.UserUseCase;
import com.airportagency.entities.user.domain.entity.User;

public class UserConsoleAdapter {
    private CreateUserUseCase createUserUseCase;
    private FindUserUseCase findUserUseCase;
    private UpdateUserUseCase updateUserUseCase;
    private DelateUserUseCase delateUserUseCase;
    private ReadUsersUseCase readUserUseCase;

    public UserConsoleAdapter(CreateUserUseCase createUserUseCase, FindUserUseCase findUserUseCase,
            UpdateUserUseCase updateUserUseCase, DelateUserUseCase delateUserUseCase, ReadUsersUseCase readUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.findUserUseCase = findUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.delateUserUseCase = delateUserUseCase;
        this.readUserUseCase = readUsersUseCase;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre del usuario:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese contraseña del usuario:");
            String password = scanner.nextLine();

            User user = new User();
            user.setNombre_usuario(nombre);
            user.setPassword(password);

            createUserUseCase.execute(user);
            System.out.println("Usuario creado exitosamente");
        } catch (Exception e) {
            System.err.println("Error al crear el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void findUserById() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el ID del usuario a buscar:");
            Long id = scanner.nextLong();
            scanner.nextLine(); 

            User user = findUserUseCase.execute(id);

            if (user != null) {
                System.out.println("Usuario encontrado:");
                System.out.println("ID: " + user.getId_usuario());
                System.out.println("Nombre: " + user.getNombre_usuario());
            } else {
                System.out.println("No se encontró ningún usuario con el ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateById() throws SQLException {

        List<User> users = readUserUseCase.readAllUser();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el ID del usuario a actualizar:");
            Long id = scanner.nextLong();
            scanner.nextLine(); 

            User user = findUserUseCase.execute(id);
            if (user != null) {
                System.out.println("Usuario encontrado:");
                System.out.println("ID: " + user.getId_usuario());
                System.out.println("Nombre: " + user.getNombre_usuario()); 
                System.out.println("Ingresa el nuevo nombre:");
                String newName = scanner.nextLine();
                System.out.println("Ingresa la nueva contraseña :");
                String newPassword = scanner.nextLine();
                System.out.println("Ingrese el nuevo rol: ");
                int newRol = scanner.nextInt();
                scanner.nextLine();
                User updatedUser = updateUserUseCase.execute(id, newName, newPassword, newRol);

            }
        }
    }

    
    public void deleteById() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el ID del usuario a eliminar:");
            Long id = scanner.nextLong();
            scanner.nextLine(); // Consumir la nueva línea después de nextLong()

            User userFound = findUserUseCase.execute(id);
            if (userFound != null) {
                System.out.println("Usuario a eliminar:");
                System.out.println("ID: " + userFound.getId_usuario());
                System.out.println("Nombre: " + userFound.getNombre_usuario());

                System.out.println("¿Estás seguro que deseas eliminar el usuario?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después de nextInt()

                switch (choice) {
                    case 1:
                        User deletedUser = delateUserUseCase.execute(id);
                        if (deletedUser != null) {
                            System.out.println("Usuario eliminado con éxito.");
                        } else {
                            System.out.println("Error al eliminar el usuario.");
                        }
                        break;
                    case 2:
                        System.out.println("Operación de eliminación cancelada.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } else {
                System.out.println("No se encontró ningún usuario con el ID: " + id);
            }

        } catch (Exception e) {
            System.err.println("Error al eliminar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

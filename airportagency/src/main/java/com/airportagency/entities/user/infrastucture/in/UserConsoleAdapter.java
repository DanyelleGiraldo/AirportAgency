package com.airportagency.entities.user.infrastucture.in;

import java.util.List;
import java.util.Scanner;

import com.airportagency.entities.user.aplication.CreateUserUseCase;
import com.airportagency.entities.user.aplication.DelateUserUseCase;
import com.airportagency.entities.user.aplication.FindUserUseCase;
import com.airportagency.entities.user.aplication.ReadUserUseCase;
import com.airportagency.entities.user.aplication.UpdateUserUseCase;
import com.airportagency.entities.user.domain.entity.User;

public class UserConsoleAdapter {
    private CreateUserUseCase createUserUseCase;
    private FindUserUseCase findUserUseCase;
    private UpdateUserUseCase updateUserUseCase;
    private DelateUserUseCase delateUserUseCase;
    private ReadUserUseCase readUserUseCase;

    public UserConsoleAdapter(CreateUserUseCase createUserUseCase, FindUserUseCase findUserUseCase,
            UpdateUserUseCase updateUserUseCase, DelateUserUseCase delateUserUseCase, ReadUserUseCase readUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.findUserUseCase = findUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.delateUserUseCase = delateUserUseCase;
        this.readUserUseCase = readUserUseCase;
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

    public void updateById() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el ID del usuario a actualizar:");
            Long id = scanner.nextLong();
            scanner.nextLine(); 

            User user = findUserUseCase.execute(id);
            if (user != null) {
                System.out.println("Usuario encontrado:");
                System.out.println("ID: " + user.getId_usuario());
                System.out.println("Nombre: " + user.getNombre_usuario());

                System.out.println("¿Qué deseas modificar del usuario?");
                System.out.println("1. Nombre");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.println("Ingresa el nuevo nombre:");
                        String newName = scanner.nextLine();
                        User updatedUser = updateUserUseCase.execute(id, newName, newName);
                        if (updatedUser != null) {
                            System.out.println("Nombre actualizado a: " + updatedUser.getNombre_usuario());
                        } else {
                            System.out.println("Error al actualizar el nombre.");
                        }
                        break; 
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } else {
                System.out.println("No se encontró ningún usuario con el ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar el usuario: " + e.getMessage());
            e.printStackTrace();
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

    @SuppressWarnings("unchecked")
    public void listUserbyName() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre del usuario a buscar:");
            String nombre = scanner.nextLine();

          
            List<User> userList = (List<User>) readUserUseCase.execute(nombre);

            if (!userList.isEmpty()) {
                System.out.println("Usuarios encontrados con el nombre '" + nombre + "':");
                for (User user : userList) {
                    System.out.println("ID: " + user.getId_usuario());
                    System.out.println("Nombre: " + user.getNombre_usuario());
                    System.out.println("---------------------------");
                }
            } else {
                System.out.println("No se encontraron usuarios con el nombre '" + nombre + "'.");
            }

        } catch (Exception e) {
            System.err.println("Error al buscar usuarios por nombre: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

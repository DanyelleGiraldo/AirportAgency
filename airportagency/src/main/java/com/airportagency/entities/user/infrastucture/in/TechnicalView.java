package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

import com.airportagency.entities.Revision.application.RevisionService;
import com.airportagency.entities.Revision.infrastructure.in.RevisionConsoleAdapter;
import com.airportagency.entities.Revision.infrastructure.out.RevisionSQLRepository;

public class TechnicalView {
    RevisionSQLRepository revisionSQLRepository = new RevisionSQLRepository();
    public void start(){
        try(Scanner scanner = new Scanner(System.in)){
            boolean salir = false;

            while (!salir) {
                System.out.println("Elige una opción: ");
                System.out.println("1. Registrar revisión");
                System.out.println("2. Ver historial de revisiones del avión");
                System.out.println("3. Actualizar información de la revisión");
                System.out.println("4. Eliminar revisión de mantenimiento");
                System.out.println("5. Salir");


                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> {
                        RevisionService revisionService = new RevisionService(revisionSQLRepository);
                        RevisionConsoleAdapter revisionConsoleAdapter = new RevisionConsoleAdapter(revisionService);
                        revisionConsoleAdapter.createRevision();
                    }
                    case 2 -> {
                        RevisionService revisionService = new RevisionService(revisionSQLRepository);
                        RevisionConsoleAdapter revisionConsoleAdapter = new RevisionConsoleAdapter(revisionService);
                        revisionConsoleAdapter.getAllRevisions();
                    }
                    case 3 -> {
                        RevisionService revisionService = new RevisionService(revisionSQLRepository);
                        RevisionConsoleAdapter revisionConsoleAdapter = new RevisionConsoleAdapter(revisionService);
                        revisionConsoleAdapter.updateRevision();
                    }
                    case 4 -> {
                        RevisionService revisionService = new RevisionService(revisionSQLRepository);
                        RevisionConsoleAdapter revisionConsoleAdapter = new RevisionConsoleAdapter(revisionService);
                        revisionConsoleAdapter.deleteRevision();
                    }
                    case 5 -> {
                        salir = true;
                        MainView mainView = new MainView();
                        mainView.start();
                    }
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 5.");
                }
            }
        }
    }
}

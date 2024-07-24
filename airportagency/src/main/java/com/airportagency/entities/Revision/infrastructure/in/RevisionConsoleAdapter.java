package com.airportagency.entities.Revision.infrastructure.in;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.Revision.application.RevisionService;
import com.airportagency.entities.Revision.domain.entity.Revision;

public class RevisionConsoleAdapter {
    Scanner scanner = new Scanner(System.in);

    private final RevisionService revisionService;

    public RevisionConsoleAdapter(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public void createRevision(){
        System.out.println("INGRESE EL ID DE LA REVISION A CREAR");
        String idRevision = scanner.nextLine();

        System.out.println("INGRESE LA FECHA DE LA REVISION (YYYY-MM-DD)");
        String revisionDate = scanner.nextLine();
        Date revDate = Date.valueOf(revisionDate);

        System.out.println("INGRESE EL ID DEL AVION");
        String idPlane = scanner.nextLine();

        System.out.println("INGRESE EL ID DE DETALLES");
        String idDetails = scanner.nextLine();

        Revision newRevision = new Revision(idRevision, revDate, idPlane, idDetails);
        revisionService.createRevision(newRevision);
    }


    public void searchRevision(){
        System.out.println(" INGRESE EL ID DE LA REVISION A BUSCAR\n\n");
        String findId = scanner.nextLine();

        Optional<Revision> revision = revisionService.getRevisionById(findId);
        revision.ifPresentOrElse(
            a -> System.out.println("ID: "+ a.getId()),
            () -> System.out.println("REVISION NO ENCONTRADA")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }


    public void updateRevision(){
        System.out.println("INGRESE EL ID DE LA REVISION A EDITAR\n\n");
        String findId = scanner.nextLine();

        Optional<Revision> revision = revisionService.getRevisionById(findId);
        revision.ifPresentOrElse(
            a -> {
                System.out.println("ID: " + a.getId());
                System.out.println("Fecha de la revisión actual: " + a.getRevisionDate());
                System.out.println("INGRESE LA NUEVA FECHA DE LA REVISION (YYYY-MM-DD)");
                String updateRevisionDate = scanner.nextLine();
                Date updatedDate = Date.valueOf(updateRevisionDate);
                

                System.out.println("ID del avión actual: " + a.getIdPlane());
                System.out.println("INGRESE EL NUEVO ID DEL AVION");
                String updateIdPlane = scanner.nextLine();
    
                System.out.println("ID de detalles actual: " + a.getIdDetails());
                System.out.println("INGRESE EL NUEVO ID DE DETALLES");
                String updateIdDetails = scanner.nextLine();
    
                Revision updatedRevision = new Revision(a.getId(), updatedDate, updateIdPlane, updateIdDetails);
                revisionService.updateRevisions(updatedRevision);

            },
            () -> System.out.println("REVISION NO ENCONTRADA")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR....");
        scanner.nextLine();     
    
    }

    public void deleteRevision(){
        System.out.println("INGRESE EL ID DE LA REVISION A ELIMINAR\n\n");
        String findId = scanner.nextLine();

        Optional<Revision> revision = revisionService.getRevisionById(findId);
        revision.ifPresentOrElse(
            a -> {
                revisionService.deleteRevision(findId);
            },
            () -> System.out.println("REVISION NO ENCONTRADA")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }

    public void getAllRevisions(){
        revisionService.getAllRevisions().forEach(a -> {
            System.out.println("ID: "+ a.getId() + "FECHA DE REVISION: " + a.getRevisionDate() + "ID DE AVION: " + a.getIdPlane() + "DETALLES DE ID: " + a.getIdDetails());
        });
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }
}

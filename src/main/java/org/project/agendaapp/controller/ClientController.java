package org.project.agendaapp.controller;

import org.project.agendaapp.DTO.ApiResponse;
import org.project.agendaapp.DTO.ClientDto;
import org.project.agendaapp.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ClientDto>>> getAllClients() {
        List<ClientDto> clients = clientService.getAllClients();
        ApiResponse<List<ClientDto>> response = ApiResponse.success(
                clients,
                "Liste des clients récupérée avec succès",
                HttpStatus.OK
        );
        LocalDateTime dateTime = response.getLocalDateTime();
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("Liste des clients récupérée avec succès le " + formattedDateTime);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClientDto>> getClientById(@PathVariable Long id) {
        ClientDto client = clientService.getClientById(id);
        ApiResponse<ClientDto> response = ApiResponse.success(
                client,
                "Client récupéré avec succès",
                HttpStatus.OK
        );
        LocalDateTime dateTime = response.getLocalDateTime();
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("Client récupéré avec succès le " + formattedDateTime);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteClientById(@PathVariable Long id) {
        clientService.deleteClient(id);
        ApiResponse<Void> response = ApiResponse.success(
                null,
                "Client supprimé avec succès",
                HttpStatus.NO_CONTENT
        );
        System.out.println("Client supprimé avec succès le " + response.getLocalDateTime().format(formatter));
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createClient(@RequestBody ClientDto clientDto) {
        try {
            String clientId = clientService.createClient(clientDto);
            ApiResponse<String> response = ApiResponse.success(
                    clientId,
                    "Client créé avec succès",
                    HttpStatus.CREATED
            );
            LocalDateTime creationDateTime = response.getLocalDateTime();
            System.out.println("Nouveau client créé avec succès" + clientId + " le " + creationDateTime.format(formatter));
            return ResponseEntity.status(response.getStatus()).body(response);

        } catch (Exception e) {
            System.out.println("Message d'erreur: " + e.getMessage());
            ApiResponse<String> response = ApiResponse.error(
                    HttpStatus.BAD_REQUEST,
                    "Erreur lors de la création du client"
            );
            return ResponseEntity.status(response.getStatus()).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        clientService.updateClient(id, clientDto);
        ApiResponse<Void> response = ApiResponse.success(
                null,
                "Client mis à jour avec succès",
                HttpStatus.OK
        );
        LocalDateTime dateTime = response.getLocalDateTime();
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("Client mis à jour avec succès "+id+" le " + formattedDateTime);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}

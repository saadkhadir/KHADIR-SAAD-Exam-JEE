package org.example.exam_jee.web;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.exam_jee.dtos.*;
import org.example.exam_jee.services.GestionCreditService;
import org.example.exam_jee.dtos.ClientDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class GestionCreditController {

    private final GestionCreditService service;
    @PostMapping("/clients")
    public ClientDTO saveClient(@RequestBody ClientDTO dto) {
        return service.saveClient(dto);
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return service.getClientById(id);
    }

    @GetMapping("/clients")
    public List<ClientDTO> getAllClients() {
        return service.getAllClients();
    }

    @PutMapping("/clients/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO dto) {
        return service.updateClient(id, dto);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
    }
    @GetMapping("/credits")
    public List<CreditDTO> getAllCredits() {
        return service.getAllCredits();
    }

    @GetMapping("/credits/{id}")
    public CreditDTO getCreditById(@PathVariable Long id) {
        return service.getCreditById(id);
    }

    @DeleteMapping("/credits/{id}")
    public void deleteCredit(@PathVariable Long id) {
        service.deleteCredit(id);
    }

    @GetMapping("/clients/{clientId}/credits")
    public List<CreditDTO> getCreditsByClientId(@PathVariable Long clientId) {
        return service.getCreditsByClientId(clientId);
    }

    @PostMapping("/credits/personnel")
    public CreditPersonnelDTO saveCreditPersonnel(@RequestBody CreditPersonnelDTO dto) {
        return service.saveCreditPersonnel(dto);
    }

    @PostMapping("/credits/immobilier")
    public CreditImmobilierDTO saveCreditImmobilier(@RequestBody CreditImmobilierDTO dto) {
        return service.saveCreditImmobilier(dto);
    }

    @PostMapping("/credits/professionnel")
    public CreditProfessionnelDTO saveCreditProfessionnel(@RequestBody CreditProfessionnelDTO dto) {
        return service.saveCreditProfessionnel(dto);
    }

    @PostMapping("/remboursements")
    public RemboursementDTO saveRemboursement(@RequestBody RemboursementDTO dto) {
        return service.saveRemboursement(dto);
    }

    @GetMapping("/remboursements/{id}")
    public RemboursementDTO getRemboursementById(@PathVariable Long id) {
        return service.getRemboursementById(id);
    }

    @GetMapping("/remboursements")
    public List<RemboursementDTO> getAllRemboursements() {
        return service.getAllRemboursements();
    }

    @GetMapping("/credits/{creditId}/remboursements")
    public List<RemboursementDTO> getRemboursementsByCreditId(@PathVariable Long creditId) {
        return service.getRemboursementsByCreditId(creditId);
    }

    @PutMapping("/remboursements/{id}")
    public RemboursementDTO updateRemboursement(@PathVariable Long id, @RequestBody RemboursementDTO dto) {
        return service.updateRemboursement(id, dto);
    }

    @DeleteMapping("/remboursements/{id}")
    public void deleteRemboursement(@PathVariable Long id) {
        service.deleteRemboursement(id);
    }
}
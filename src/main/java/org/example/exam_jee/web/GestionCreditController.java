package org.example.exam_jee.web;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.exam_jee.dtos.*;
import org.example.exam_jee.services.GestionCreditService;
import org.example.exam_jee.dtos.ClientDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class GestionCreditController {

    private final GestionCreditService service;
    @PostMapping("/clients")
    @PreAuthorize("hasAnyRole('EMPLOYE', 'ADMIN')")
    public ClientDTO saveClient(@RequestBody ClientDTO dto) {
        return service.saveClient(dto);
    }

    @GetMapping("/clients/{id}")
    @PreAuthorize("hasAnyRole('EMPLOYE', 'ADMIN')")
    public ClientDTO getClientById(@PathVariable Long id) {
        return service.getClientById(id);
    }

    @GetMapping("/clients")
    @PreAuthorize("hasAnyRole('EMPLOYE', 'ADMIN')")
    public List<ClientDTO> getAllClients() {
        return service.getAllClients();
    }

    @PutMapping("/clients/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO dto) {
        return service.updateClient(id, dto);
    }

    @DeleteMapping("/clients/{id}")
    @PreAuthorize("hasAnyRole('EMPLOYE', 'ADMIN')")
    public void deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
    }

    @PostMapping("/credits/personnel")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public CreditPersonnelDTO saveCreditPersonnel(@RequestBody CreditPersonnelDTO dto) {
        return service.saveCreditPersonnel(dto);
    }

    @PostMapping("/credits/immobilier")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public CreditImmobilierDTO saveCreditImmobilier(@RequestBody CreditImmobilierDTO dto) {
        return service.saveCreditImmobilier(dto);
    }

    @PostMapping("/credits/professionnel")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public CreditProfessionnelDTO saveCreditProfessionnel(@RequestBody CreditProfessionnelDTO dto) {
        return service.saveCreditProfessionnel(dto);
    }

    @PostMapping("/remboursements")
    @PreAuthorize("hasAnyRole('EMPLOYE', 'ADMIN')")
    public RemboursementDTO saveRemboursement(@RequestBody RemboursementDTO dto) {
        return service.saveRemboursement(dto);
    }

    @GetMapping("/remboursements/{id}")
    @PreAuthorize("hasAuthority(SCOPE_ADMIN)")
    public RemboursementDTO getRemboursementById(@PathVariable Long id) {
        return service.getRemboursementById(id);
    }

    @GetMapping("/remboursements")
    @PreAuthorize("hasAnyRole('CLIENT', 'EMPLOYE', 'ADMIN')")
    public List<RemboursementDTO> getAllRemboursements() {
        return service.getAllRemboursements();
    }

    @GetMapping("/credits/{creditId}/remboursements")
    @PreAuthorize("hasAnyRole('CLIENT', 'EMPLOYE', 'ADMIN')")
    public List<RemboursementDTO> getRemboursementsByCreditId(@PathVariable Long creditId) {
        return service.getRemboursementsByCreditId(creditId);
    }

    @PutMapping("/remboursements/{id}")
    @PreAuthorize("hasAnyRole('EMPLOYE', 'ADMIN')")
    public RemboursementDTO updateRemboursement(@PathVariable Long id, @RequestBody RemboursementDTO dto) {
        return service.updateRemboursement(id, dto);
    }

    @DeleteMapping("/remboursements/{id}")
    @PreAuthorize("hasAnyRole('EMPLOYE', 'ADMIN')")
    public void deleteRemboursement(@PathVariable Long id) {
        service.deleteRemboursement(id);
    }
}
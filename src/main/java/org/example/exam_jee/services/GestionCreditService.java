package org.example.exam_jee.services;

import org.example.exam_jee.dtos.*;

import java.util.List;

public interface GestionCreditService {
    ClientDTO saveClient(ClientDTO dto);
    ClientDTO getClientById(Long id);
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(Long id, ClientDTO dto);
    void deleteClient(Long id);
    CreditDTO getCreditById(Long id);
    List<CreditDTO> getAllCredits();
    void deleteCredit(Long id);
    CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO dto);
    CreditPersonnelDTO updateCreditPersonnel(Long id, CreditPersonnelDTO dto);
    CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO dto);
    CreditImmobilierDTO updateCreditImmobilier(Long id, CreditImmobilierDTO dto);
    CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO dto);
    CreditProfessionnelDTO updateCreditProfessionnel(Long id, CreditProfessionnelDTO dto);
    RemboursementDTO saveRemboursement(RemboursementDTO dto);
    RemboursementDTO getRemboursementById(Long id);
    List<RemboursementDTO> getAllRemboursements();
    RemboursementDTO updateRemboursement(Long id, RemboursementDTO dto);
    void deleteRemboursement(Long id);
    List<RemboursementDTO> getRemboursementsByCreditId(Long creditId);
    List<CreditDTO> getCreditsByClientId(Long clientId);
}

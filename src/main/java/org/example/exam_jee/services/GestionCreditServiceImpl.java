package org.example.exam_jee.services;
import lombok.AllArgsConstructor;
import org.example.exam_jee.dtos.*;
import org.example.exam_jee.entities.*;
import org.example.exam_jee.enums.StatutCredit;
import org.example.exam_jee.mappers.*;
import org.example.exam_jee.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    @AllArgsConstructor
    public class GestionCreditServiceImpl implements GestionCreditService {

        private final ClientRepository clientRepository;
        private final CreditRepository creditRepository;
        private final CreditPersonnelRepository creditPersonnelRepository;
        private final CreditImmobilierRepository creditImmobilierRepository;
        private final CreditProfessionnelRepository creditProfessionnelRepository;
        private final RemboursementRepository remboursementRepository;

        private final ClientMapper clientMapper;
        private final CreditMapper creditMapper;
        private final CreditPersonnelMapper creditPersonnelMapper;
        private final CreditImmobilierMapper creditImmobilierMapper;
        private final CreditProfessionnelMapper creditProfessionnelMapper;
        private final RemboursementMapper remboursementMapper;
        @Override
        public ClientDTO saveClient(ClientDTO dto) {
            Client client = clientMapper.toEntity(dto);
            return clientMapper.toDTO(clientRepository.save(client));
        }

        @Override
        public ClientDTO getClientById(Long id) {
            return clientRepository.findById(id)
                    .map(clientMapper::toDTO)
                    .orElseThrow(() -> new RuntimeException("Client not found"));
        }

        @Override
        public List<ClientDTO> getAllClients() {
            return clientRepository.findAll().stream()
                    .map(clientMapper::toDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public ClientDTO updateClient(Long id, ClientDTO dto) {
            Client existing = clientRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            Client updated = clientMapper.toEntity(dto);
            updated.setId(existing.getId());
            return clientMapper.toDTO(clientRepository.save(updated));
        }

        @Override
        public void deleteClient(Long id) {
            clientRepository.deleteById(id);
        }

        @Override
        public CreditDTO getCreditById(Long id) {
            return creditRepository.findById(id)
                    .map(creditMapper::toDTO)
                    .orElseThrow(() -> new RuntimeException("Credit not found"));
        }

        @Override
        public List<CreditDTO> getAllCredits() {
            return creditRepository.findAll().stream()
                    .map(creditMapper::toDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public void deleteCredit(Long id) {
            creditRepository.deleteById(id);
        }
        @Override
        public CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO dto) {
            CreditPersonnel credit = creditPersonnelMapper.toEntity(dto);
            credit.setStatut(StatutCredit.EN_COURS); // par défaut
            return creditPersonnelMapper.toDTO(creditPersonnelRepository.save(credit));
        }

        @Override
        public CreditPersonnelDTO updateCreditPersonnel(Long id, CreditPersonnelDTO dto) {
            CreditPersonnel existing = creditPersonnelRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Credit personnel not found"));
            CreditPersonnel updated = creditPersonnelMapper.toEntity(dto);
            updated.setId(existing.getId());
            return creditPersonnelMapper.toDTO(creditPersonnelRepository.save(updated));
        }

        @Override
        public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO dto) {
            CreditImmobilier credit = creditImmobilierMapper.toEntity(dto);
            credit.setStatut(StatutCredit.EN_COURS);
            return creditImmobilierMapper.toDTO(creditImmobilierRepository.save(credit));
        }

        @Override
        public CreditImmobilierDTO updateCreditImmobilier(Long id, CreditImmobilierDTO dto) {
            CreditImmobilier existing = creditImmobilierRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Credit immobilier not found"));
            CreditImmobilier updated = creditImmobilierMapper.toEntity(dto);
            updated.setId(existing.getId());
            return creditImmobilierMapper.toDTO(creditImmobilierRepository.save(updated));
        }
        @Override
        public CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO dto) {
            CreditProfessionnel credit = creditProfessionnelMapper.toEntity(dto);
            credit.setStatut(StatutCredit.EN_COURS);
            return creditProfessionnelMapper.toDTO(creditProfessionnelRepository.save(credit));
        }

        @Override
        public CreditProfessionnelDTO updateCreditProfessionnel(Long id, CreditProfessionnelDTO dto) {
            CreditProfessionnel existing = creditProfessionnelRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Credit professionnel not found"));
            CreditProfessionnel updated = creditProfessionnelMapper.toEntity(dto);
            updated.setId(existing.getId());
            return creditProfessionnelMapper.toDTO(creditProfessionnelRepository.save(updated));
        }
        @Override
        public RemboursementDTO saveRemboursement(RemboursementDTO dto) {
            Remboursement remboursement = remboursementMapper.toEntity(dto);
            return remboursementMapper.toDTO(remboursementRepository.save(remboursement));
        }

        @Override
        public RemboursementDTO getRemboursementById(Long id) {
            return remboursementRepository.findById(id)
                    .map(remboursementMapper::toDTO)
                    .orElseThrow(() -> new RuntimeException("Remboursement not found"));
        }

        @Override
        public List<RemboursementDTO> getAllRemboursements() {
            return remboursementRepository.findAll().stream()
                    .map(remboursementMapper::toDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public RemboursementDTO updateRemboursement(Long id, RemboursementDTO dto) {
            Remboursement existing = remboursementRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Remboursement not found"));
            Remboursement updated = remboursementMapper.toEntity(dto);
            updated.setId(existing.getId());
            return remboursementMapper.toDTO(remboursementRepository.save(updated));
        }

        @Override
        public void deleteRemboursement(Long id) {
            remboursementRepository.deleteById(id);
        }

        @Override
        public List<RemboursementDTO> getRemboursementsByCreditId(Long creditId) {
            return remboursementRepository.findByCreditId(creditId).stream()
                    .map(remboursementMapper::toDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public List<CreditDTO> getCreditsByClientId(Long clientId) {
            return creditRepository.findByClientId(clientId).stream()
                    .map(creditMapper::toDTO)
                    .collect(Collectors.toList());
        }
    }



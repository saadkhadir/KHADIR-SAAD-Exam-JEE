package org.example.exam_jee;

import org.example.exam_jee.dtos.*;
import org.example.exam_jee.entities.*;
import org.example.exam_jee.enums.StatutCredit;
import org.example.exam_jee.enums.TypeBien;
import org.example.exam_jee.enums.TypeRemboursement;
import org.example.exam_jee.repositories.ClientRepository;
import org.example.exam_jee.repositories.CreditRepository;
import org.example.exam_jee.repositories.RemboursementRepository;
import org.example.exam_jee.services.GestionCreditService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ExamJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamJeeApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(GestionCreditService service) {
        return args -> {
            // Création des clients
            List<ClientDTO> clients = Stream.of("Ali", "Sana", "Youssef").map(name -> {
                ClientDTO client = new ClientDTO();
                client.setNom(name);
                client.setEmail(name.toLowerCase() + "@bank.com");
                return service.saveClient(client);
            }).toList();

            // Création des crédits (1 de chaque type pour chaque client)
            List<CreditDTO> credits = new ArrayList<>();
            for (ClientDTO client : clients) {
                // Crédit Personnel
                CreditPersonnelDTO cp = new CreditPersonnelDTO();
                cp.setMontant(10000.0);
                cp.setDuree(12);
                cp.setMotif("Achat électroménager");
                cp.setClientId(client.getId());
                credits.add(service.saveCreditPersonnel(cp));

                // Crédit Immobilier
                CreditImmobilierDTO ci = new CreditImmobilierDTO();
                ci.setMontant(250000.0);
                ci.setDuree(240);
                ci.setClientId(client.getId());
                credits.add(service.saveCreditImmobilier(ci));

                // Crédit Professionnel
                CreditProfessionnelDTO cpro = new CreditProfessionnelDTO();
                cpro.setMontant(50000.0);
                cpro.setDuree(36);
                cpro.setClientId(client.getId());
                credits.add(service.saveCreditProfessionnel(cpro));
            }

            // Création des remboursements pour chaque crédit
            for (CreditDTO credit : credits) {
                for (int i = 1; i <= 3; i++) {
                    RemboursementDTO r = new RemboursementDTO();
                    r.setMontant(credit.getMontant() / credit.getDuree()); // montant mensuel
                    r.setDate(LocalDate.now().minusMonths(3 - i));
                    r.setCreditId(credit.getId());
                    service.saveRemboursement(r);
                }
            }
        };
    }


    //@Bean
    CommandLineRunner start(
            ClientRepository clientRepository,
            CreditRepository creditRepository,
            RemboursementRepository remboursementRepository) {
        return args -> {
            // Ajouter des clients
            Stream.of("Ali", "Sofia", "Yassine").forEach(nom -> {
                Client client = new Client();
                client.setNom(nom);
                client.setEmail(nom.toLowerCase() + "@banque.com");
                clientRepository.save(client);
            });

            List<Client> clients = clientRepository.findAll();

            // Ajouter des crédits (personnel, immobilier, professionnel)
            for (int i = 0; i < 6; i++) {
                Credit credit;
                if (i % 3 == 0) {
                    CreditPersonnel cp = new CreditPersonnel();
                    cp.setMotif("Achat voiture");
                    credit = cp;
                } else if (i % 3 == 1) {
                    CreditImmobilier ci = new CreditImmobilier();
                    ci.setTypeBien(TypeBien.Maison);
                    credit = ci;
                } else {
                    CreditProfessionnel cp = new CreditProfessionnel();
                    cp.setMotif("Achat matériel");
                    cp.setRaisonSociale("Entreprise " + (char) ('A' + i));
                    credit = cp;
                }

                credit.setDateDemande(LocalDate.now().minusDays(i * 3));
                credit.setStatut(StatutCredit.EN_COURS);
                credit.setMontant(100000 + i * 10000);
                credit.setDureeRemboursement(12 + i);
                credit.setTauxInteret(3.5f + i);
                credit.setClient(clients.get(i % clients.size()));

                creditRepository.save(credit);
            }

            List<Credit> credits = creditRepository.findAll();

            // Ajouter des remboursements
            for (Credit credit : credits) {
                for (int j = 1; j <= 2; j++) {
                    Remboursement remboursement = new Remboursement();
                    remboursement.setDate(LocalDate.now().minusDays(j * 10));
                    remboursement.setMontant(credit.getMontant() / (credit.getDureeRemboursement() * 1.0));
                    remboursement.setType(j % 2 == 0 ? TypeRemboursement.MENSUALITE : TypeRemboursement.REMBOURSEMENT_ANTICIPE);
                    remboursement.setCredit(credit);

                    remboursementRepository.save(remboursement);
                }
            }
        };
    }

}

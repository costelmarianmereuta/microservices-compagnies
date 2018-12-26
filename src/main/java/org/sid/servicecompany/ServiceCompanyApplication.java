package org.sid.servicecompany;

import org.sid.servicecompany.model.Company;
import org.sid.servicecompany.repository.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ServiceCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCompanyApplication.class, args);
    }

    @Bean
//on a pas besoin d'utiliser autowired car il va l'injecter l'objet companyRepository
    CommandLineRunner start(CompanyRepository companyRepository){
        return args -> {

            Stream.of("devoteam","accenture","tobania").forEach(societe->{
                companyRepository.save(new Company(societe,100+Math.random()*900));
            });

            companyRepository.findAll().forEach(company -> System.out.println(company));
        };
    }
}


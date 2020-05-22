package fr.vdelll.catservice;

import fr.vdelll.catservice.dao.ProduitRepository;
import fr.vdelll.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.prefs.Preferences;

@SpringBootApplication
public class CatserviceApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CatserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Produit.class);
        produitRepository.save(new Produit(null, "Ordinateur", 670, 3));
        produitRepository.save(new Produit(null, "Imprimante", 410, 7));
        produitRepository.save(new Produit(null, "Téléphone", 390, 15));

        produitRepository.findAll().forEach(produit -> {
            System.out.println(produit.toString());
        });
    }
}

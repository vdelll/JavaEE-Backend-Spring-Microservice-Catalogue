package fr.vdelll.catservice;

import fr.vdelll.catservice.dao.ProduitRepository;
import fr.vdelll.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestServices {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value="/listProduits")
    public List<Produit> listProduits(){
        return produitRepository.findAll();
    }

    @GetMapping(value="/listProduits/{id}")
    public Produit listProduits(@PathVariable(name="id") Long id){
        return produitRepository.findById(id).get();
    }

    @PutMapping(value="/listProduits/{id}")
    public Produit update(@PathVariable(name="id") Long id, @RequestBody Produit produit){
        produit.setId(id);
        return produitRepository.save(produit);
    }

    @PostMapping(value="/listProduits/{id}")
    public Produit save(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }

    @DeleteMapping(value="/listProduits/{id}")
    public void delete(@PathVariable(name="id") Long id){
        produitRepository.deleteById(id);
    }

}

package sn.youdev.jenkinsproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.youdev.jenkinsproject.data.ProduitList;
import sn.youdev.jenkinsproject.entity.Produit;

import java.util.List;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {
    private final ProduitList produitList;
    @GetMapping
    public ResponseEntity<List<Produit>> list (){
        return ResponseEntity.ok(produitList.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produit> findById(@PathVariable final int id){
        return ResponseEntity.ok(produitList.findById(id));
    }
    @PostMapping
    public ResponseEntity<Produit> saveProduit(@RequestBody final Produit produit){
        return ResponseEntity.ok(produitList.createProduct(produit));
    }
    @PutMapping("{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable final int id , @RequestBody final Produit produit){
        return ResponseEntity.ok(produitList.updateProduct(id,produit));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProduit(@PathVariable final int id ) {
        return ResponseEntity.ok(produitList.deleteProduit(id));
    }
}

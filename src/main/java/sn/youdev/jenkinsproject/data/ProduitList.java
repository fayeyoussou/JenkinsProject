package sn.youdev.jenkinsproject.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.springframework.stereotype.Component;
import sn.youdev.jenkinsproject.entity.Produit;

@Data
@Component
public class ProduitList {

    private List<Produit> products = new ArrayList<>();
    private int id = 0;
    public ProduitList() {
        createProducts();
    }

    private void createProducts() {
        products.add(new Produit(1, "THIEB", "Thieboudienne", 2500L, 5.0, "kg", 10.0));
        products.add(new Produit(2, "YASSA", "Yassa Poulet", 3000L, 4.0, "portions", 8.0));
        products.add(new Produit(3, "MAF", "Mafé", 2000L, 3.5, "kg", 7.0));
        products.add(new Produit(4, "DOR", "Domoda", 1800L, 2.5, "plats", 6.0));
        products.add(new Produit(5, "CEE", "Ceebu Jen", 1500L, 3.0, "kg", 5.0));
        products.add(new Produit(6, "BISSAP", "Bissap Juice", 500L, 10.0, "litres", 15.0));
        products.add(new Produit(7, "BOUN", "Bouye Juice", 600L, 8.0, "litres", 12.0));
        products.add(new Produit(8, "DIB", "Dibi", 4500L, 1.5, "kg", 3.0));
        products.add(new Produit(9, "NGALAM", "Ngalakh", 1000L, 5.0, "pots", 10.0));
        products.add(new Produit(10, "MBOUR", "Thiebou Mboure", 3500L, 4.0, "kg", 8.0));
        products.add(new Produit(11, "COFF", "Cafe Maxwell House", 3500L, 10.0, "boite", 8.0));
        id = products.size();

    }
    public List<Produit> list (){
        return products;
    }
    public Produit createProduct(Produit produit){
        produit.setId(id);
        id++;
        products.add(produit);
        return produit;

    }
    public Produit updateProduct(int id,Produit produit){
        products.forEach(x->{
            if(x.getId()==id){
                x.setCode(produit.getCode());
                x.setLibelle(produit.getLibelle());
                x.setQuantite(produit.getQuantite());
                x.setPrice(produit.getPrice());
                x.setStockLimite(produit.getStockLimite());
                x.setUnite(produit.getUnite());
                produit.setId(id);

            }
        });
        return produit;
    }
    public boolean deleteProduit(int id){
        boolean found =false;
        for (int i = 0; i < products.size() ; i++) {
            Produit product = products.get(i);
            if (product.getId() == id) {
                products.remove(product);
                found = true;
                break;
            }
        }
        return found;
    }
    public Produit findById(int id){
        Produit found =null;
        for (int i = 0; i < products.size() ; i++) {
            Produit product = products.get(i);
            if (product.getId() == id) {
                found = product;
                   break;
            }
        }
        return found;
    }
}
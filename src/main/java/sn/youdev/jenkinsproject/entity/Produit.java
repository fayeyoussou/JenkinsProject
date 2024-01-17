package sn.youdev.jenkinsproject.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    private Integer id;
    private String code;
    private String libelle;
    private Long price;
    private double quantite;
    private String unite;
    private double stockLimite;

}

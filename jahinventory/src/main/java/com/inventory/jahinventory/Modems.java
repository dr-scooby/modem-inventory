package com.inventory.jahinventory;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Modems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String modelnumber;
    private String type;
    private String versionnumber; // v1, v1.1, etc...


    @Override
    public String toString() {
        return "Modems{" +
                "name='" + name + '\'' +
                ", modelnumber='" + modelnumber + '\'' +
                ", type='" + type + '\'' +
                ", versionnumber='" + versionnumber + '\'' +
                '}';
    }
}

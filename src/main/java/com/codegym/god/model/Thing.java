package com.codegym.god.model;

import javax.persistence.*;

@Entity
@Table(name="Thing")
public class Thing {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;
   private String description;

   public Thing(){}

   public Thing(String name,String description){
       this.name = name;
       this.description = description;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   @Override
    public String toString(){
       return String.format("Thing[id=%d, name='%s', description='%s']",id,name,description);
   }

}

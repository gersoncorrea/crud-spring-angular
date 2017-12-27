package com.app.server.model;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="categories")

public class Category{
    @Id
    private String id;
    @NotBlank
    @Size(max=100)
    private String name;

    public Category(){
        super();
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return String.format(
                "Category[id=%s, name='%s']",
                id, name);
    }
}
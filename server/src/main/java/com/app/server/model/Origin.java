package com.app.server.model;

import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="origins")

public class Origin{
    @Id
    private String id;
    @NotBlank
    @Size(max=100)
    private String name;

    public Origin(){
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
                "Origin[id=%s, name='%s', description='%s', image='%s']",
                id, name);
    }
}
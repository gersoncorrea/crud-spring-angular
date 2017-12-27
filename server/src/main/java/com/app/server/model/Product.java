package com.app.server.model;

import java.util.Date;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")

// annotation used to ignore createdAt field during deserialization
@JsonIgnoreProperties(value={"createdAt"}, allowGetters=true)
public class Product{
    @Id
    private String id;
    @NotBlank
    @Size(max=100)
    private String title;
    @Size(max=100)
    private String description;
    private Double price;
    private String image;
    private String origin;
    private String category;


    private Date createdAt = new Date();
    

    public Product(){
        super();
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }

    public String getOrigin(){
        return origin;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Double price(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }


    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }


    @Override
    public String toString() {
        return String.format(
                "Product[id=%s, title='%s', description='%s', image='%s']",
                id, title, description, image);
    }
}
package com.app.server.repositories;

import com.app.server.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository to access data from database
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
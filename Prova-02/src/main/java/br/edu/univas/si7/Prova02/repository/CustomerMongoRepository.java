package br.edu.univas.si7.Prova02.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.Prova02.model.Customer;


@Repository
public interface CustomerMongoRepository extends MongoRepository<Customer, String> {

}

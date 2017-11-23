package edu.cornell.haulers.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.cornell.haulers.constants.DatabaseMappings;

@Document(collection = DatabaseMappings.DB_CUSTOMERS)
public class CustomerEntity extends UserEntity {

}

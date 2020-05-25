package com.johnbryce.mymongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@Builder

public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private String owner;

    @PersistenceConstructor
    public Product(String id, String name, String description,@Value("#root.owner ?: 'Unassigned'") String owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
    }


}

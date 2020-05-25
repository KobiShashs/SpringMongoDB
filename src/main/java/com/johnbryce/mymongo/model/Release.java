package com.johnbryce.mymongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Release {

    @Id
    private String id;
    private String name;
    private String description;

    @Field("assigned_tickets")
    private List<Ticket> tickets;

   // private LocalDate releaseDate;
    private ZonedDateTime releaseDate;
    @Transient
    private Double estimateCosts;


    public Double getEstimateCosts() {
        return tickets.size() * 15.50;
    }

}

package com.voting.votingapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


// 1.JPA requires NoArgsConstructor to instantiate entity object.
// 2.If AllArgsConstructor is defined ( simply any parameterized constructor is there), then default constructor is not made by java.
@Entity
@Data
@NoArgsConstructor
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    //@ElementCollection---> will create a diff table with pk and on the field it is. Helping us not to make a separate entity class.
    @ElementCollection
    private List<String> options= new ArrayList<>();

    @ElementCollection
    private List<Long> votes= new ArrayList<>();





}

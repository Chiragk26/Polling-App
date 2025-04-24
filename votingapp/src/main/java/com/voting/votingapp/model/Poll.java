package com.voting.votingapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


// 1.JPA requires NoArgsConstructor to instantiate entity object.
// 2.If AllArgsConstructor(a constructor will all parameters) is defined ( or simply any parameterized constructor is there), then default constructor is not made by java.
// 3.database is connected to backend via this entity class.
// 4.each field in entity class acts like a column and each of its object act like a row in the table.
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
    private List<OptionVote> options= new ArrayList<>();

}

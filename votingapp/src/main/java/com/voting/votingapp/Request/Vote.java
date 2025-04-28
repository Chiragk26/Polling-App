package com.voting.votingapp.Request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vote {
    Long pollId;
    int optionIndex;
}

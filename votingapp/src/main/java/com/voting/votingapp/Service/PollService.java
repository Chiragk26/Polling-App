package com.voting.votingapp.Service;

import com.voting.votingapp.Repositories.PollRepository;
import com.voting.votingapp.model.Poll;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {
private final PollRepository pollRepository;

public PollService( PollRepository pollRepository){
    this.pollRepository=pollRepository;
}


    public  Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls(){
     return pollRepository.findAll();
    }
}

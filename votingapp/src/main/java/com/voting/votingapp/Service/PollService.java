package com.voting.votingapp.Service;

import com.voting.votingapp.Repositories.PollRepository;
import com.voting.votingapp.model.OptionVote;
import com.voting.votingapp.model.Poll;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
//The Optional class is a container object in Java that may or may not contain a value.
// It's often used to avoid NullPointerExceptions
    public Optional<Poll> getPollById(Long id){
    return pollRepository.findById(id);

    }

    public void recordVote(Long pollId,int optionIndex){
    Poll poll= pollRepository.findById(pollId)
            .orElseThrow(()-> new RuntimeException("Poll not found"));

   List<OptionVote> pollOptions= poll.getOptions();

   if(optionIndex<=0 || optionIndex > pollOptions.size()){
       throw new IllegalArgumentException("invalid option index");
   }

   OptionVote selectedOption=pollOptions.get(optionIndex-1);

   selectedOption.setVoteCount(selectedOption.getVoteCount() +1);

   pollRepository.save(poll);

    }
}

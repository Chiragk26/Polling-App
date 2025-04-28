package com.voting.votingapp.PollController;

import com.voting.votingapp.Request.Vote;
import com.voting.votingapp.Service.PollService;
import com.voting.votingapp.model.Poll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
public class PollController {
private final PollService pollService;

  public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }

    @GetMapping
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long id){
      return pollService.getPollById(id)
              .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/vote")
    public void recordVote(@RequestBody Vote vote){
     pollService.recordVote( vote.getPollId(), vote.getOptionIndex());
    }


}

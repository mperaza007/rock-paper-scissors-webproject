package mygroup.rockpaperscissorsweb;


import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin //Allows the API to be invoked by resorces that are not hosted on the same domain
public class ScoreController {

    static Score score = new Score();

    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score newScore){
        score = newScore;
        return score;
    }

    @PatchMapping("/score/{updatedWinLossOrTie}")
    public Score updateWinsLossesOrTies(@PathVariable String updatedWinLossOrTie,@RequestParam(name="new-value") int newValue){
        if (updatedWinLossOrTie.equalsIgnoreCase("wins")){
            score.wins = newValue;
            return score;
        }
        if (updatedWinLossOrTie.equalsIgnoreCase("losses")){
            score.losses = newValue;
            return score;
        }
        score.ties = newValue;
        return score;

    }

    @PostMapping("/score/{increaseWinsLossOrTie}")
    public Score incresedWinsLossesOrTies(@PathVariable String increaseWinsLossOrTie){
        if (increaseWinsLossOrTie.equalsIgnoreCase("wins")){
            score.wins ++;
            return score;
        }
        if (increaseWinsLossOrTie.equalsIgnoreCase("losses")){
            score.losses++;
            return score;
        }
        score.ties++;
        return score;
    }


    @GetMapping("/score")
    public Score getScore(){
        return score;
    }

    @GetMapping("/score/{winsLossesOrTies}")
    public int getWinsLossesOrTies(@PathVariable String winsLossesOrTies){
        if(winsLossesOrTies.equalsIgnoreCase("wins")){
            return score.wins;
        }
        if(winsLossesOrTies.equalsIgnoreCase("ties")){
            return score.ties;
        }
        return score.losses;
    }
}

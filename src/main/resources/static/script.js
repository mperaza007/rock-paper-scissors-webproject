playRockPaperScissors = async function(clientGesture){
    const options = ["rock", "paper", "scissors"];
    var computerChoice = options[Math.floor(Math.random() * options.length)];
    if ((clientGesture=="rock" && computerChoice=="paper") || (clientGesture=="paper" && computerChoice=="scissors") || (clientGesture=="scissors" && computerChoice=="rock")){
        result="loss";
        url="http://localhost:8080/score/losses";
    }
    if((clientGesture=="rock" && computerChoice=="rock" ) || (clientGesture=="paper" && computerChoice=="paper") ||(clientGesture=="scissors" && computerChoice=="scissors")){
        result = "tie";
        url = "http://localhost:8080/score/ties";
    }
    if ((clientGesture=="rock" && computerChoice=="scissors") || (clientGesture=="paper" && computerChoice=="rock") || (clientGesture=="scissors" && computerChoice=="paper")){
        result = "win";
        url = "http://localhost:8080/score/wins";

    }

    try{
        const response = await fetch(url, {method: "POST"});
        const theScore = await response.json();

        document.getElementById("wins").innerHTML="<b>Wins: </b> " + theScore.wins;
        document.getElementById("losses").innerHTML="<b>Losses: </b> " + theScore.losses;
        document.getElementById("ties").innerHTML="<b>Ties: </b> " + theScore.ties;
        document.getElementById("results").innerHTML="The result was a: " + result;

    }catch(error){
        console.log(error.message);
    }
    document.getElementById("results").innerHTML="Computer choice: " + computerChoice +". The result was a: " + result;

}
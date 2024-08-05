const choices = document.querySelectorAll('.choice');
const resultDiv = document.getElementById('result');
const playerScoreDiv = document.getElementById('player-score');
const computerScoreDiv = document.getElementById('computer-score');

let playerScore = 0;
let computerScore = 0;

choices.forEach(choice => {
    choice.addEventListener('click', () => {
        const playerChoice = choice.id;
        const computerChoice = getComputerChoice();
        const winner = getWinner(playerChoice, computerChoice);

        displayResult(winner, playerChoice, computerChoice);
        updateScore(winner);
    });
});

function getComputerChoice() {
    const choices = ['rock', 'paper', 'scissors'];
    return choices[Math.floor(Math.random() * 3)];
}

function getWinner(player, computer) {
    if (player === computer) {
        return 'tie';
    }
    if (
        (player === 'rock' && computer === 'scissors') ||
        (player === 'paper' && computer === 'rock') ||
        (player === 'scissors' && computer === 'paper')
    ) {
        return 'player';
    }
    return 'computer';
}

function displayResult(winner, playerChoice, computerChoice) {
    if (winner === 'tie') {
        resultDiv.textContent = `It's a tie! You both chose ${playerChoice}.`;
    } else if (winner === 'player') {
        resultDiv.textContent = `You win! ${playerChoice} beats ${computerChoice}.`;
    } else {
        resultDiv.textContent = `You lose! ${computerChoice} beats ${playerChoice}.`;
    }
}

function updateScore(winner)

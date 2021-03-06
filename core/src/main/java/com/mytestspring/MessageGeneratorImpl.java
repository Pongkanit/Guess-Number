package com.mytestspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);


    private Game game;

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()){
            return "You guessed it! The number was " + game.getNumber();
        } else if (game.isGamelost()){
            return "You lost. The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()){
            return "Invalid number range!";
        } else if (game.getRemainingGuesses() == game.getGuessCount()){
            return "what is your first guess?";
        } else {
            String direction = "Lower";

            if (game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
        }

    }

    @PostConstruct
    public void deleteAll(){
        log.info("game = {}", game);
    }
}

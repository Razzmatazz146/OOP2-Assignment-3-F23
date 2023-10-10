package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class DeckController {
    @FXML
    private TextArea aDeckTextArea;

    @FXML
    private TextArea aHandTextArea;

    @FXML
    private Label aScoreLabel;

    private final Deck aDeck = new Deck();

    private final Hand aHand = new Hand();

    public void initialize() {
        this.displayCardCollections();
    }

    @FXML
    protected void onShuffleButtonClick() {
        this.aDeck.shuffle();
        this.displayCardCollections();
    }

    @FXML
    protected void onSortButtonClick() {
        aDeckTextArea.setText("This does not sort anything yet.");
    }

    @FXML
    protected void onScoreButtonClick() {
        // Create a dialog to choose the strategy
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Aces Strategy", "Aces Strategy", "Simple Count Strategy");
        dialog.setTitle("Choose Scoring Strategy");
        dialog.setHeaderText("Select the scoring strategy");
        dialog.setContentText("Strategy:");

        // Show and wait for the user's choice
        dialog.showAndWait().ifPresent(selectedStrategy -> {
            int score = 0;
            if ("Aces Strategy".equals(selectedStrategy)) {
                score = NumberOfAcesScoringStrategy.calculateScore(aHand.getCards());
            } else if ("Simple Count Strategy".equals(selectedStrategy)) {
                score = SimpleCountScoringStrategy.calculateScore(aHand.getCards());
            }

            // Display the score in the label
            aScoreLabel.setText("Score: " + score);
        });
    }

    @FXML
    protected void onDrawButtonClick() {
        if (!this.aDeck.isEmpty()) {
            this.aHand.addCard(aDeck.draw());
        }
        this.displayCardCollections();
    }

    private void displayCardCollections () {
        this.aDeckTextArea.setText(this.aDeck.toString());
        this.aHandTextArea.setText(this.aHand.toString());
    }
}
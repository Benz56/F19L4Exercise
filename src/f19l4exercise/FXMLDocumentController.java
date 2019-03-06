/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f19l4exercise;

import f19l4exercise.opg2_numberplates.NumberPlates;
import f19l4exercise.opg3_playingcards.DeckOfCards;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class FXMLDocumentController implements Initializable {

    private NumberPlates numberPlates;
    private DeckOfCards deckOfCards;

    @FXML
    private TextField npInput;

    @FXML
    private Label npResult;

    @FXML
    private TextArea cardTextArea;

    @FXML
    private ToggleGroup swapCount;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numberPlates = new NumberPlates();
        deckOfCards = new DeckOfCards();
        cardTextArea.setText(deckOfCards.toString());
    }

    @FXML
    private void onCheckClicked() {
        npResult.setText(numberPlates.validate(npInput.getText()));
    }

    @FXML
    private void onMixClicked(ActionEvent event) {
        deckOfCards.shuffle(Integer.parseInt(((RadioButton) swapCount.getSelectedToggle()).getText()));
        cardTextArea.setText(deckOfCards.toString());
    }
}

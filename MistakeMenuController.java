package fxmlGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import spellchecker.Dictionary;
import spellchecker.Suggestions;
import spellchecker.Word;

public class MistakeMenuController {

	@FXML
	private Text wrongWordPanel;
	@FXML
	private Button getSuggestionsButton;
	@FXML
	private Text suggestions;
	@FXML
	private Button skipThis;
	@FXML
	private Button skipSame;
	@FXML
	private Button addToDictionary;
	
	private JavelasApp javelasApp;
	private Word word;
	
	public MistakeMenuController() {
	}
	
	@FXML
	public void getSuggestions(ActionEvent event) {
		suggestions.setText(new Suggestions(word).toString());
	}
	
	@FXML
	public void clickSkipThis(ActionEvent event) {
		//javelasApp.getPrimaryStage().hide();
		wrongWordPanel.setText(null);
		suggestions.setText(null);
		javelasApp.showEmptyScene();
	}

	@FXML
	public void clickSkipSame(ActionEvent event) {
		Dictionary.dictionaries.get(0).addWord(word);
	}
	
	@FXML
	public void clickAddToDictionary(ActionEvent event) {
		Dictionary.dictionaries.get(0).addWordPermanently(word);
	}
	
	public void setJavelasApp(JavelasApp javelasApp) {
		this.javelasApp = javelasApp;
	}
	
	public void setWrongWordPanel(Word word) {
		this.word = word;
		wrongWordPanel.setText("The word \"" + word.getWordStr() + "\" doesn't exist");
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	} 
}

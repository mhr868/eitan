package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Word;

public class WordValidator {

	public static List<String> validate(Word w) {
		List<String> errors = new ArrayList<>();

		String word_error = _validateWord(w.getWord());
		if(!word_error.equals("")) {
			errors.add(word_error);
		}
		String mean_error = _validateWord(w.getMean());
		if(!mean_error.equals("")) {
			errors.add(mean_error);
		}
		return errors;
	}

	private static String _validateWord(String word) {
		if(word == null || word.equals("")) {
			return "単語を入力してください。";
		}
		return "";
	}

	private static String _validateMean(String mean) {
		if(mean == null || mean.equals("")) {
			return "意味を入力してください。";
		}
		return "";
	}
}

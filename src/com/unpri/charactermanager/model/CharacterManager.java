package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {
    private ArrayList<Character> characters = new ArrayList<>();

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public ArrayList<Character> getAllCharacters() {
        return characters;
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) return 0.0;
        int totalLevel = 0;
        for (Character c : characters) {
            totalLevel += c.getLevel();
        }
        return (double) totalLevel / characters.size();
    }
}
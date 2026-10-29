package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        // Membuat 3 karakter awal
        Character c1 = new Character("Aragorn", CharacterType.WARRIOR, 5);
        Character c2 = new Character("Gandalf", CharacterType.MAGE, 8);
        Character c3 = new Character("Legolas", CharacterType.ARCHER, 4);

        manager.addCharacter(c1);
        manager.addCharacter(c2);
        manager.addCharacter(c3);

        System.out.println("=== DAFTAR KARAKTER AWAL ===");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // Demo Level Up
        System.out.println("\n=== DEMO LEVEL UP (Aragorn naik level ke 6) ===");
        c1.setLevel(6);
        System.out.println(c1);

        // Pengujian Mini-Challenge (Mana & isAlive)
        System.out.println("\n=== PENGUJIAN MINI-CHALLENGE (MANA & isAlive) ===");
        Character c4 = new Character("Merlin", CharacterType.MAGE, 3, 100, 40, 150);
        System.out.println("Karakter Baru: " + c4);
        System.out.println("Apakah " + c4.getName() + " masih hidup? " + c4.isAlive());

        // Uji validasi exception jika mana negatif
        try {
            c4.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi Exception Berhasil: " + e.getMessage());
        }
    }
}
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<Character> list = new ArrayList<>();
            
            // Menyesuaikan dengan enum standar CharacterType yang biasanya ada (MAGE, WARRIOR, ARCHER, dll.)
            list.add(new Character("Alga", CharacterType.MAGE, 10));
            list.add(new Character("Rahmat", CharacterType.WARRIOR, 12));
            list.add(new Character("Sharon", CharacterType.ARCHER, 8));
            list.add(new Character("Hendra", CharacterType.MAGE, 15)); // Ganti ke MAGE/WARRIOR jika ASSASSIN tidak ada di enum Anda
            list.add(new Character("Nicolia", CharacterType.MAGE, 9));
            list.add(new Character("Elsadai", CharacterType.WARRIOR, 14)); // Ganti ke WARRIOR jika TANK tidak ada di enum Anda
            list.add(new Character("Alfay", CharacterType.WARRIOR, 11));
            list.add(new Character("Arif", CharacterType.ARCHER, 13));

            MainWindow frame = new MainWindow(list);
            frame.setVisible(true);
        });
    }
}
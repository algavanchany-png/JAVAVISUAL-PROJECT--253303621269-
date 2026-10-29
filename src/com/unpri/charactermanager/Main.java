package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CharacterManager manager = new CharacterManager();

            // Menambahkan minimal 6 karakter dengan variasi level dan role (Bagian B)
            manager.addCharacter(new Character("Aragorn", CharacterType.WARRIOR, 6)); // Level tinggi (Gold)
            manager.addCharacter(new Character("Gandalf", CharacterType.MAGE, 8));    // Level tinggi (Gold)
            manager.addCharacter(new Character("Legolas", CharacterType.ARCHER, 4));
            manager.addCharacter(new Character("Arthas", CharacterType.WARRIOR, 7));  // Level tinggi (Gold)
            manager.addCharacter(new Character("Jaina", CharacterType.MAGE, 6));      // Level tinggi (Gold)
            manager.addCharacter(new Character("Bilbo", CharacterType.ROGUE, 1));     // Level pemula (Disabled)

            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
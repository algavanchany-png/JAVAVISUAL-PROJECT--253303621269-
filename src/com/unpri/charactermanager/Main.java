package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.view.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Bagian A: Menjalankan GUI secara aman di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            CharacterManager manager = new CharacterManager();

            // Bagian B: Menambahkan total minimal 5 karakter (3 lama + 2 baru)
            manager.addCharacter(new Character("Aragorn", CharacterType.WARRIOR, 10));
            manager.addCharacter(new Character("Gandalf", CharacterType.MAGE, 8));
            manager.addCharacter(new Character("Legolas", CharacterType.ARCHER, 4));
            
            // 2 Karakter baru (Bagian C: Alasan pemilihan tipe/level)
            // - Arthas (WARRIOR, level 9): Ditambahkan untuk memperkuat lini depan tank dengan attack tinggi.
            // - Jaina (MAGE, level 8): Ditambahkan untuk melengkapi variasi magic damage dan dukungan mana.
            manager.addCharacter(new Character("Arthas", CharacterType.WARRIOR, 7));
            manager.addCharacter(new Character("Jaina", CharacterType.MAGE, 10));

            // Inisialisasi dan tampilkan jendela MainWindow
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
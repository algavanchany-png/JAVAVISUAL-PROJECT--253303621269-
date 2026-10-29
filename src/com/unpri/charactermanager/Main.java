package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO CHARACTER MANAGER SPRINT #2 (TP5) ===");
        CharacterManager manager = new CharacterManager();

        // 1. Pengujian Add & Validasi Duplikat (Bagian A)
        System.out.println("\n--- 1. PENGUJIAN ADD & DUPLIKAT ---");
        Character c1 = new Character("Aragorn", CharacterType.WARRIOR, 5);
        Character c2 = new Character("Gandalf", CharacterType.MAGE, 8);
        Character c3 = new Character("Legolas", CharacterType.ARCHER, 4);
        Character duplicateC1 = new Character("Aragorn", CharacterType.ROGUE, 10); // Nama sama persis

        manager.addCharacter(c1);
        manager.addCharacter(c2);
        manager.addCharacter(c3);
        manager.addCharacter(duplicateC1); // Harus ditolak oleh sistem

        // 2. Pengujian Defensive Copy getAllCharacters() (Bagian A)
        System.out.println("\n--- 2. PENGUJIAN DEFENSIVE COPY ---");
        ArrayList<Character> externalList = manager.getAllCharacters();
        externalList.clear(); // Mencoba menghapus list dari luar
        System.out.println("Jumlah karakter di manager setelah list luar di-clear: " + manager.getTotalCharacters());
        System.out.println("(List asli tetap aman karena method mengembalikan salinan/copy)");

        // 3. Pengujian Mini-Challenge (Bagian B)
        System.out.println("\n--- 3. PENGUJIAN MINI-CHALLENGE (AVERAGE & BY TYPE) ---");
        System.out.println("Rata-rata Level Karakter: " + manager.getAverageLevel());
        
        System.out.println("Daftar Karakter Bertipe MAGE:");
        for (Character c : manager.findByType(CharacterType.MAGE)) {
            System.out.println(" -> " + c.getName() + " (Level " + c.getLevel() + ")");
        }

        // Edge case: test average level pada manager kosong
        CharacterManager emptyManager = new CharacterManager();
        System.out.println("Rata-rata level pada manager kosong: " + emptyManager.getAverageLevel());

        // 4. Pengujian Fitur Analitik Mandiri (Bagian C: findStrongestCharacter)
        System.out.println("\n--- 4. PENGUJIAN FITUR ANALITIK MANDIRI ---");
        Character strongest = manager.findStrongestCharacter();
        if (strongest != null) {
            System.out.println("Karakter Terkuat: " + strongest.getName() + 
                               " (" + strongest.getType() + ") dengan Attack = " + strongest.getAttack());
        }

        // 5. Pengujian Reference & Static Counter (Bagian D Preview)
        System.out.println("\n--- 5. PENGUJIAN REFERENCE & STATIC ---");
        Character a = new Character("Frodo", CharacterType.ROGUE, 2);
        Character b = a;
        b.setLevel(8);
        System.out.println("Nilai a.getLevel() setelah b diubah: " + a.getLevel()); // Mencetak 8
        System.out.println("Apakah a == b? " + (a == b)); // true (mereferensikan objek yang sama di memory)
        System.out.println("Total Karakter Yang Dibuat (Static Counter): " + Character.getTotalCharacterCreated());
    }
}
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {
    private ArrayList<Character> characters = new ArrayList<>();

    /**
     * Menambahkan karakter baru dengan validasi penolakan nama duplikat (Bagian A).
     */
    public boolean addCharacter(Character character) {
        if (findByName(character.getName()) != null) {
            System.out.println("[-] Gagal menambah: Karakter dengan nama '" + character.getName() + "' sudah ada!");
            return false;
        }
        characters.add(character);
        System.out.println("[+] Sukses menambahkan karakter: " + character.getName());
        return true;
    }

    /**
     * Mencari karakter berdasarkan nama (Bagian A).
     */
    public Character findByName(String name) {
        for (Character c : characters) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Menghapus karakter berdasarkan nama (Bagian A).
     */
    public boolean removeCharacter(String name) {
        Character c = findByName(name);
        if (c != null) {
            characters.remove(c);
            return true;
        }
        return false;
    }

    /**
     * Mengembalikan jumlah total karakter (Bagian A).
     */
    public int getTotalCharacters() {
        return characters.size();
    }

    /**
     * Bagian A: Mengembalikan salinan (defensive copy) dari ArrayList 
     * agar struktur list asli di dalam manager aman dari manipulasi luar.
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    /**
     * Bagian B: Menghitung rata-rata level karakter dengan pengaman edge case list kosong.
     */
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }
        int totalLevel = 0;
        for (Character c : characters) {
            totalLevel += c.getLevel();
        }
        return (double) totalLevel / characters.size();
    }

    /**
     * Bagian B: Mengembalikan ArrayList berisi semua karakter yang sesuai dengan tipe tertentu.
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();
        for (Character c : characters) {
            if (c.getType() == type) {
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Bagian C (Fitur Analitik Mandiri): Mencari karakter dengan Attack tertinggi.
     * @return Objek Character terkuat atau null jika list kosong.
     */
    public Character findStrongestCharacter() {
        if (characters.isEmpty()) {
            return null;
        }
        Character strongest = characters.get(0);
        for (Character c : characters) {
            if (c.getAttack() > strongest.getAttack()) {
                strongest = c;
            }
        }
        return strongest;
    }
}
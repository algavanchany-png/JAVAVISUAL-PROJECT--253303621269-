package com.unpri.charactermanager.model;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana; // Atribut tambahan untuk Mini-Challenge

    // Constructor 1: Sederhana (Nama, Tipe, Level)
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = level * 20;
        this.attack = level * 10;
        this.mana = 50; // Default mana
    }

    // Constructor 2: Lengkap
    public Character(String name, CharacterType type, int level, int hitPoints, int attack, int mana) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attack = attack;
        setMana(mana); // Menggunakan setter agar tervalidasi
    }

    // Getter dan Setter standar
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        this.hitPoints = level * 20;
        this.attack = level * 10;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    // Getter dan Setter Mana dengan Validasi Exception (Mini-Challenge)
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh bernilai negatif!");
        }
        this.mana = mana;
    }

    // Method isAlive (Mini-Challenge)
    public boolean isAlive() {
        return this.hitPoints > 0;
    }

    // toString diperbarui menampilkan atribut mana
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}
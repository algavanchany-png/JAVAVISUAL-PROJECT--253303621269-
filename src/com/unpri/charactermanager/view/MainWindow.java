package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final CharacterManager characterManager;
    private JLabel lblAverageLevel;
    private JPanel panelCharacterList;

    // Konstanta batas level untuk highlight teks emas dan tebal (Mini-Challenge Bagian B)
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    public MainWindow(CharacterManager manager) {
        this.characterManager = manager;
        
        setTitle("Character Manager - Sprint #4 (TP10) | NIM: 253303621269");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Menerapkan warna latar dari AppTheme (Tanpa hardcode)
        getContentPane().setBackground(AppTheme.BG_COLOR);
        setLayout(new BorderLayout(10, 10));

        // Header Title
        JLabel lblTitle = new JLabel("DAFTAR KARAKTER GAME (THEMED v0.4)", JLabel.CENTER);
        lblTitle.setFont(AppTheme.FONT_TITLE);
        lblTitle.setForeground(AppTheme.TEXT_PRIMARY);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        add(lblTitle, BorderLayout.NORTH);

        // Panel Daftar Karakter
        panelCharacterList = new JPanel();
        panelCharacterList.setLayout(new BoxLayout(panelCharacterList, BoxLayout.Y_AXIS));
        panelCharacterList.setBackground(AppTheme.BG_COLOR);
        panelCharacterList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        refreshCharacterList();

        JScrollPane scrollPane = new JScrollPane(panelCharacterList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        // Footer Statistik Rata-rata Level
        JPanel panelFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFooter.setBackground(AppTheme.BG_COLOR);
        lblAverageLevel = new JLabel();
        updateStatistics();
        panelFooter.add(lblAverageLevel);
        panelFooter.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        add(panelFooter, BorderLayout.SOUTH);

        // Menggunakan pack() sesuai ketentuan Bagian A & D
        pack();
        setSize(500, getHeight() < 550 ? 550 : getHeight());
    }

    public void refreshCharacterList() {
        panelCharacterList.removeAll();
        for (Character c : characterManager.getAllCharacters()) {
            JPanel card = new JPanel(new GridLayout(2, 1));
            card.setOpaque(true); // Wajib setOpaque(true) agar warna background kartu tampil
            card.setBackground(AppTheme.CARD_BG);
            card.setBorder(AppTheme.CARD_BORDER);

            // Properti Tambahan #1: Tooltip detail informasi HP, Attack, dan Mana
            card.setToolTipText("Detail -> [HP: " + c.getHitPoints() + ", Attack: " + c.getAttack() + ", Mana: " + c.getMana() + "]");

            // Properti Tambahan #2: Menonaktifkan kartu (setEnabled(false)) untuk karakter level dasar (Level <= 1)
            if (c.getLevel() <= 1) {
                card.setEnabled(false);
            }

            // Label Nama & Role dengan warna dari AppTheme
            JLabel lblInfo = new JLabel("  Nama: " + c.getName() + " | Tipe: " + c.getType() + " | Level: " + c.getLevel());
            lblInfo.setForeground(AppTheme.colorFor(c.getType()));
            
            // Mini-Challenge: Level >= 5 tampil dengan teks emas dan tebal
            if (c.getLevel() >= HIGH_LEVEL_THRESHOLD) {
                lblInfo.setFont(AppTheme.FONT_HIGHLIGHT);
                lblInfo.setForeground(AppTheme.HIGHLIGHT_GOLD);
            } else {
                lblInfo.setFont(AppTheme.FONT_CARD_TITLE);
            }

            JLabel lblStats = new JLabel("  HP: " + c.getHitPoints() + " | Attack: " + c.getAttack() + " | Mana: " + c.getMana() + " | Hidup: " + c.isAlive());
            lblStats.setFont(AppTheme.FONT_BODY);
            lblStats.setForeground(AppTheme.TEXT_MUTED);

            card.add(lblInfo);
            card.add(lblStats);
            panelCharacterList.add(card);
        }
        panelCharacterList.revalidate();
        panelCharacterList.repaint();
    }

    public void updateStatistics() {
        double avg = characterManager.getAverageLevel();
        lblAverageLevel.setText(" Rata-rata Level Karakter: " + String.format("%.2f", avg));
        lblAverageLevel.setFont(AppTheme.FONT_CARD_TITLE);
        lblAverageLevel.setForeground(AppTheme.TEXT_PRIMARY);
    }
}
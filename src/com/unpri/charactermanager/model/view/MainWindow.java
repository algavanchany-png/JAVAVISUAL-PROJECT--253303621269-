package com.unpri.charactermanager.model.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
    private CharacterManager characterManager;
    private JLabel lblAverageLevel;
    private JPanel panelCharacterList;

    public MainWindow(CharacterManager manager) {
        this.characterManager = manager;
        
        // Konfigurasi Dasar Jendela (Bagian A)
        setTitle("Character Manager - Sprint #3 (TP8) | NIM: 253303621269");
        setSize(480, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Header Title
        JLabel lblTitle = new JLabel("DAFTAR KARAKTER GAME (GUI SPRINT #2)", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblTitle, BorderLayout.NORTH);

        // Panel Daftar Karakter dengan Dynamic Loop (Bagian A)
        panelCharacterList = new JPanel();
        panelCharacterList.setLayout(new BoxLayout(panelCharacterList, BoxLayout.Y_AXIS));
        panelCharacterList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        refreshCharacterList();

        JScrollPane scrollPane = new JScrollPane(panelCharacterList);
        add(scrollPane, BorderLayout.CENTER);

        // Footer untuk Statistik Rata-rata Level (Mini-Challenge Bagian B)
        JPanel panelFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblAverageLevel = new JLabel();
        updateStatistics();
        panelFooter.add(lblAverageLevel);
        panelFooter.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        add(panelFooter, BorderLayout.SOUTH);
    }

    /**
     * Melakukan render ulang daftar karakter secara dinamis dari CharacterManager.
     */
    public void refreshCharacterList() {
        panelCharacterList.removeAll();
        for (Character c : characterManager.getAllCharacters()) {
            JPanel card = new JPanel(new GridLayout(2, 1));
            card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 0, 5, 0),
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1)
            ));
            card.setBackground(new Color(248, 249, 250));

            JLabel lblInfo = new JLabel("  Nama: " + c.getName() + " | Tipe: " + c.getType() + " | Level: " + c.getLevel());
            lblInfo.setFont(new Font("Arial", Font.BOLD, 12));
            
            JLabel lblStats = new JLabel("  HP: " + c.getHitPoints() + " | Attack: " + c.getAttack() + " | Mana: " + c.getMana() + " | Hidup: " + c.isAlive());
            lblStats.setFont(new Font("Arial", Font.PLAIN, 11));
            lblStats.setForeground(new Color(100, 100, 100));

            card.add(lblInfo);
            card.add(lblStats);
            panelCharacterList.add(card);
        }
        panelCharacterList.revalidate();
        panelCharacterList.repaint();
    }

    /**
     * Memperbarui label statistik rata-rata level (Mini-Challenge Bagian B).
     */
    public void updateStatistics() {
        double avg = characterManager.getAverageLevel();
        lblAverageLevel.setText(" Rata-rata Level Karakter: " + String.format("%.2f", avg));
        lblAverageLevel.setFont(new Font("Arial", Font.BOLD, 13));
        lblAverageLevel.setForeground(new Color(0, 102, 204));
    }
}
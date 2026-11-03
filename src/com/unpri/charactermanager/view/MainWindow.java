package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private JPanel cardsPanel;
    private JLabel statusLabel;

    public MainWindow(List<Character> characters) {
        setTitle("Character Manager v0.5");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 1. BorderLayout Utama
        setLayout(new BorderLayout());

        // NORTH: Header Panel
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        headerPanel.setBackground(new Color(5, 6, 47)); // #05062f
        JLabel titleLabel = new JLabel("Character Manager Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // CENTER: Daftar Kartu Karakter dengan JScrollPane
        cardsPanel = new JPanel();
        cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.Y_AXIS));
        cardsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        populateCharacters(characters);

        JScrollPane scrollPane = new JScrollPane(cardsPanel);
        scrollPane.setPreferredSize(new Dimension(550, 400));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        // EAST: Panel Legenda menggunakan BoxLayout (Y_AXIS)
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(new BoxLayout(legendPanel, BoxLayout.Y_AXIS));
        legendPanel.setBorder(BorderFactory.createTitledBorder("Character Type Legend"));
        legendPanel.setPreferredSize(new Dimension(220, 0));

        legendPanel.add(Box.createVerticalStrut(10));
        for (CharacterType type : CharacterType.values()) {
            JLabel typeLabel = new JLabel("• " + type.name());
            typeLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
            legendPanel.add(typeLabel);
        }
        legendPanel.add(Box.createVerticalGlue());
        add(legendPanel, BorderLayout.EAST);

        // SOUTH: Bar Status (Teks di kiri, "v0.5" di kanan)
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
        statusPanel.setBackground(new Color(245, 245, 245));

        statusLabel = new JLabel("Status: Ready (" + characters.size() + " characters loaded)");
        JLabel versionLabel = new JLabel("v0.5");
        versionLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));

        statusPanel.add(statusLabel, BorderLayout.WEST);
        statusPanel.add(versionLabel, BorderLayout.EAST);
        add(statusPanel, BorderLayout.SOUTH);
    }

    private void populateCharacters(List<Character> characters) {
        cardsPanel.removeAll();
        for (Character c : characters) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(5, 5, 5, 5),
                    BorderFactory.createLineBorder(new Color(27, 38, 68), 1, true)
            ));
            card.setBackground(Color.WHITE);
            card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

            JLabel infoLabel = new JLabel("  " + c.getName() + " | Role: " + c.getType() + " | Level: " + c.getLevel());
            infoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            card.add(infoLabel, BorderLayout.CENTER);

            cardsPanel.add(card);
            cardsPanel.add(Box.createVerticalStrut(5));
        }
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
}
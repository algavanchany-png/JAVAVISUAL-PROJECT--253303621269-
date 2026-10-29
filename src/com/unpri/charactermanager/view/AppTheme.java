package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AppTheme {
    // Minimal 3 Warna Utama
    public static final Color BG_COLOR = new Color(245, 247, 250);
    public static final Color CARD_BG = Color.WHITE;
    public static final Color TEXT_PRIMARY = new Color(33, 37, 41);
    public static final Color TEXT_MUTED = new Color(108, 117, 125);
    public static final Color HIGHLIGHT_GOLD = new Color(212, 175, 55);

    // Warna Berdasarkan Role (Karakter)
    public static final Color COLOR_WARRIOR = new Color(231, 76, 60);
    public static final Color COLOR_MAGE = new Color(52, 152, 219);
    public static final Color COLOR_ARCHER = new Color(46, 204, 113);
    public static final Color COLOR_ROGUE = new Color(155, 89, 182);

    // Minimal 3 Font (Menggunakan Logical Font yang aman)
    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 16);
    public static final Font FONT_CARD_TITLE = new Font("SansSerif", Font.BOLD, 13);
    public static final Font FONT_BODY = new Font("SansSerif", Font.PLAIN, 12);
    public static final Font FONT_HIGHLIGHT = new Font("SansSerif", Font.BOLD, 13);

    // Minimal 1 Border Kustom
    public static final Border CARD_BORDER = BorderFactory.createCompoundBorder(
        BorderFactory.createEmptyBorder(4, 8, 4, 8),
        BorderFactory.createLineBorder(new Color(220, 224, 230), 1, true)
    );

    /**
     * Memetakan tipe karakter ke warna khusus tema (Bagian A).
     */
    public static Color colorFor(CharacterType type) {
        if (type == null) return TEXT_PRIMARY;
        switch (type) {
            case WARRIOR: return COLOR_WARRIOR;
            case MAGE: return COLOR_MAGE;
            case ARCHER: return COLOR_ARCHER;
            case ROGUE: return COLOR_ROGUE;
            default: return TEXT_PRIMARY;
        }
    }
}
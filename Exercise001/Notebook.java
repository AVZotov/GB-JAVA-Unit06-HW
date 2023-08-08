package ru.geekbrains.api.Seminar006.HW.Exercise001;

public class Notebook {
    private final int RAM;
    private final int HDD;
    private final String OsInstalled;
    private final String Color;

    public Notebook(int RAM, int HDD, String osInstalled, String color) {
        this.RAM = RAM;
        this.HDD = HDD;
        OsInstalled = osInstalled;
        Color = color;
    }

    public int getHDD() {
        return HDD;
    }

    public int getRAM() {
        return RAM;
    }

    public String getOsInstalled() {
        return OsInstalled;
    }

    public String getColor() {
        return Color;
    }

    /**
     * @return Formatted string with Notebook details
     */
    @Override
    public String toString() {
        return String.format("RAM: %d MB\nHDD size: %d GB\nOperating System: %s\nColor: %s\n", RAM, HDD, OsInstalled, Color);
    }
}

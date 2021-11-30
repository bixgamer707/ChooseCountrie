package me.bixgamer707.choosecountrie.enums;

public enum Color {

    RED_DARK("\u001b[31m"),
    BLUE_DARK("\u001b[34m"),
    WHITE("\u001b[37m"),
    BLACK("\u001b[30m"),
    GREEN_DARK("\u001b[32m"),
    ORANGE("\u001b[33m"),
    YELLOW("\u001b[33;1m"),
    MAGENTA_DARK("\u001b[35m"),
    MAGENTA("\u001b[35;1m"),
    CYAN("\u001b[36m"),
    GRAY("\u001b[30;1m"),
    AQUA("\u001b[36;1m"),
    BLUE("\u001b[34;1m"),
    RED("\u001b[31;1m"),
    GREEN("\u001b[32;1m"),
    RESET("\u001b[0m");

    private final String value;

    Color(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
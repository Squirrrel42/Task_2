package ru.aston.hometask.task3.adapter;

public class ScrollAdapter implements Castable{
    private final Scroll scroll;

    public ScrollAdapter(Scroll scroll) {
        this.scroll = scroll;
    }

    @Override
    public void cast() {
        scroll.read();
    }

    @Override
    public String getName() {
        return scroll.getName();
    }

    @Override
    public int getDamage() {
        return scroll.getDamage();
    }

    @Override
    public int getManaCost() {
        return scroll.getManaCost();
    }
}

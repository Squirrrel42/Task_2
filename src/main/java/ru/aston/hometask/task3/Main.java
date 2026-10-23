package ru.aston.hometask.task3;

import ru.aston.hometask.task3.builder.CharacterCreator;
import ru.aston.hometask.task3.builder.RPGCharacter;
import ru.aston.hometask.task3.chainOfResponsibility.ChainApp;
import ru.aston.hometask.task3.strategy.StrategyApp;

public class Main {
    public static void main(String[] args) {
//        StrategyApp.execute();
//        ChainApp.execute();
        RPGCharacter rpgCharacter = CharacterCreator.makeCharacter();
    }
}
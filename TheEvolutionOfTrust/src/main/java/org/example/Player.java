package org.example;

public interface Player {

    public Choice playChoice();

    default void gain(){}
    default void invest(){}

}

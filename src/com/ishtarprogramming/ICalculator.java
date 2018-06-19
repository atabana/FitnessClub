package com.ishtarprogramming;

@FunctionalInterface
public interface ICalculator <T extends Number>{

    double calclateFees(T clubID);
}

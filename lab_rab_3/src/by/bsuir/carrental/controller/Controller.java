package by.bsuir.carrental.controller;

import by.bsuir.carrental.exceptions.WrongInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Controller {
    public static int chooseFromMenu(int min, int max, Scanner in) throws WrongInputException {
        boolean fl = true;
        int buff = 0;
        while (fl)
        {
            try {
                buff = in.nextInt();
            } catch (InputMismatchException ex) {
                throw new WrongInputException();
            }
            if (buff <= max && buff >= min)
                fl = false;
        }
        return buff;
    }
}
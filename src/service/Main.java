package service;

import entity.Option;
import entity.Needy;
import entity.Donation;
import service.HelpOnNeedies;
import service.impl.HelpOnNeediesImpl;

import java.util.Set;

public class Main {

    private final static String NAME_OF_NEEDY="Юлия Мирная";

    public static void main(String[] args) {

        HelpOnNeedies helpOnNeedies=new HelpOnNeediesImpl();

        // Все нуждающиеся
        Set<Needy> needies = helpOnNeedies.getAllDonations();
        System.out.println("Все нуждающиеся");
        for (Needy needy:
             needies) {
            System.out.println(needy.toString());
        }

        //Все опции для одного нуждающегося
        Set<Option> optionsForNeedy =helpOnNeedies.getOptionForNeedy(NAME_OF_NEEDY);
        System.out.println("\nВсе опции для ["+NAME_OF_NEEDY+"]");
        for (Option option:
             optionsForNeedy) {
            System.out.println(option.toString());

        }

        //Сделать пожертвование
        //Изменение переменной
        System.out.println("\nСделать пожертвование для ["+NAME_OF_NEEDY+"]");
        Donation donation=helpOnNeedies.payForOption(NAME_OF_NEEDY,1);

        //Моделирование исключения
        System.out.println("\nМоделирование исключения");
        helpOnNeedies.payForOption(NAME_OF_NEEDY, 8);


    }
}

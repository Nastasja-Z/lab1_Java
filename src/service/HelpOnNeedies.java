package service;

import entity.Needy;
import entity.Option;
import entity.Donation;

import java.util.Set;

public interface HelpOnNeedies {

    Set<Needy> getAllDonations();

    Set<Option> getOptionForNeedy(String nameOfNeedy);

    Donation payForOption(String nameOFNeedy, int idOfOption);

}

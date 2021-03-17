package service.impl;

import entity.Needy;
import entity.Option;
import entity.Donation;
import service.HelpOnNeedies;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class HelpOnNeediesImpl implements HelpOnNeedies {

    @Override
    public Set<Needy> getAllDonations() {
        return getAllNeediesData();
    }

    @Override
    public Set<Option> getOptionForNeedy(String nameOfNeedy) {
        Set<Needy> needies=getAllNeediesData();
        Needy needy =needies.stream()
                .filter(n -> n.getNameOfNeedy().equals(nameOfNeedy)).findFirst().orElse(null);

        assert needy != null;
        return needy.getOptions();

    }

    Integer id=0;
    @Override
    public Donation payForOption(String nameOFNeedy, int idOfOption) {
        Donation donations= new Donation();
        donations.setId(id+1);
        Set<Needy> mainNeedy=getAllNeediesData();
        Needy needy=mainNeedy.stream().filter(name -> name.getNameOfNeedy().equals(nameOFNeedy)).findFirst().orElse(null);
        Set<Option> needies=getOptionForNeedy(nameOFNeedy);
        Option option=needies.stream().filter(value -> value.getId().equals(idOfOption) && needy!=null).findFirst().orElse(null);
        Map<Needy, Option> newDonationMap=new HashMap<>();

         if(needy==null) {
            throw new IllegalArgumentException("There is no needy such ["+nameOFNeedy+"]");
        }
        else if(option==null) {
            throw new RuntimeException("There is no option with ID like ["+idOfOption+"]");
        } else {
             newDonationMap.put(needy, option);
             donations.setDonatMap(newDonationMap);
             System.out.println("Name= "+needy.getNameOfNeedy()+ " "+option);
             needies.remove(option);
             System.out.println("\nИзмененный список нужд ["+needy.getNameOfNeedy()+"]");
             for (Option o:
                  needies) {
                 System.out.println(o.toString());
             }
             return donations;
        }

    }

    private List<Option> getAllOptionsData() {
        Option option1=new Option();
        option1.setId(1);
        option1.setNameOfOption("стандартный набор еды");
        option1.setPrice(250);

        Option option2=new Option();
        option2.setId(2);
        option2.setNameOfOption("улучшеный набор еды");
        option2.setPrice(500);

        Option option3=new Option();
        option3.setId(3);
        option3.setNameOfOption("осмотр у врача");
        option3.setPrice(300);

        return Arrays.asList(option1,option2,option3);

    }

    private Set<Needy> getAllNeediesData() {
        Set needies = new HashSet();
        List<Option> options=getAllOptionsData();

        Needy needy1 =new Needy();
        needy1.setId(1);
        needy1.setNameOfNeedy("Юлия Мирная");
        needy1.setStatus("беженка");
        Set<Option> julia= options.stream().filter(value-> value.getId().equals(1) || value.getId().equals(2)).collect(Collectors.toSet());
        needy1.setOptions(julia);

        Needy needy2 =new Needy();
        needy2.setId(2);
        needy2.setNameOfNeedy("Матвей Лесовой");
        needy2.setStatus("пенсиоер");
        Set<Option> mathew= options.stream().filter(value-> value.getId().equals(3) || value.getId().equals(2)).collect(Collectors.toSet());
        needy2.setOptions(mathew);

        Needy needy3 =new Needy();
        needy3.setId(3);
        needy3.setNameOfNeedy("Гарик Маликов");
        needy3.setStatus("инвалид 3й степени");
        Set<Option> garik= options.stream().filter(value-> value.getId().equals(1)).collect(Collectors.toSet());
        needy3.setOptions(garik);

        needies.add(needy1);
        needies.add(needy2);
        needies.add(needy3);

        return needies;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.subs;

import java.util.ArrayList;
import java.util.List;
import ru.vist.stat.forms.precept.PreceptView;

/**
 *
 * @author chernov
 */
public class Subs {

    private static final List<Subscribe> list = new ArrayList<>();
    private static final List<String> codes = new ArrayList<>();

    private static void init() {
        list.clear();
        codes.clear();
        list.add(new Subscribe("Precepts", "Предписания", PreceptView.class));
        list.add(new Subscribe("Precepts", "Предписания", PreceptView.class));
        list.add(new Subscribe("Precepts", "Предписания", PreceptView.class));
        list.add(new Subscribe("Precepts", "Предписания", PreceptView.class));
        for(Subscribe s : list){
            codes.add(s.getCode());
        }
    }

    public static List<Subscribe> getList() {
        if (list.isEmpty())
            init();
        return list;
    }

    public static String getSubCode(String name) {
        for (Subscribe s : list)
            if (s.getName().equals(name))
                return s.getCode();
        System.out.println(" Подписка по имени [" + name + "] не найдена");
        return "";
    }
    
    
    
    public static Subscribe getSubscribe(String code){
        for (Subscribe s : list)
            if (s.getCode().equals(code))
                return s;
        System.out.println(" Подписка по кодом [" + code + "] не найдена");
        return null;        
    }

    public static List<String> getCodes() {
        return codes;
    }

}

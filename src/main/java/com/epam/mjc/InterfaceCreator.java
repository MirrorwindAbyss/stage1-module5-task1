package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (String s : strings) {
                char[] ch = s.toCharArray();
                return Character.isUpperCase(ch[0]);
            }
            return false;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            int size = integers.size();
            for (int i = 0; i < size; i++) {
                if (integers.get(i) % 2 == 0) {
                    integers.add(integers.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return  () -> {
            List<String> list = new LinkedList<>();
            for (String line : values) {
                String[] strings = line.split(" ");
                if (strings.length > 3) {
                    char[] chars = line.toCharArray();
                    if (Character.isUpperCase(chars[0]) && chars[chars.length - 1] == '.')
                        list.add(line);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x->{
            Map<String,Integer> map=new HashMap<>();
            for (String str : x) {
                map.put(str,str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1,list2)->{
            List<Integer> list=new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}

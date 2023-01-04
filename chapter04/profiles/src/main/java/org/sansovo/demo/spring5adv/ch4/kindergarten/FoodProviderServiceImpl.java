package org.sansovo.demo.spring5adv.ch4.kindergarten;


import org.sansovo.demo.spring5adv.ch4.Food;
import org.sansovo.demo.spring5adv.ch4.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));

        return lunchSet;
    }
}

package com.mojo.learn_spring_framework.excercise1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// @Component
@Qualifier("MySqlDataService")
@Repository
public class MySqlDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}

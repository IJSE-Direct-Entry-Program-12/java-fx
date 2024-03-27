package lk.ijse.dep12.fx.validation;

import java.time.LocalDate;
import java.time.Period;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate dob = LocalDate.of(2000, 1, 5);
        LocalDate today = LocalDate.now();
        Period between = Period.between(today, dob);
        System.out.println(between);
    }
}

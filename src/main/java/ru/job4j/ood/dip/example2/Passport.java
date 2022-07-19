package ru.job4j.ood.dip.example2;

public interface Passport {
}

class ForeignPassportRussia implements Passport {
    private RussianCitizen russianCitizen;
}

class PassportRussia implements Passport {
    private RussianCitizen russianCitizen;
}

class RussianCitizen {

}

/**
 * классу RussianCitizen надо дать абстракцию - класс Citizen. А интерфейс
 * Passport раскидать ниже еще на 2 интерфейса - для внутреннего паспорта и заграника.
 * Может ещё и над странами подумать. И тогда программа для любого миграционного центра подойдёт.
 * А не только для военкомата)))
 */
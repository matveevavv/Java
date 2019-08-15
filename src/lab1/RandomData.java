package lab1;

import java.util.Random;

public class RandomData {


    String[] nameCaps = {"Восьмиклинка", "Уточка", "Аэродром", "Немка", "Гаврош", "Фуражка", "Клош", "Снепбэк"};
    String[] nameFirm = {"Adidas", "Asics", "Puma", "Reebok", "New Balance", "Parajumpers", "Shock Doctor", "Nike"};
    String[] nameShorts = {"Майка", "Поло", "Лонгслив", "Борцовка", "Кроп-топ", "Боди", "Спортивная футболка", "Утягивающая футболка"};

    String randNameCaps() {
        Random rand = new Random();
        return nameCaps[rand.nextInt(8)];
    }

    String randNameFirm() {
        Random rand = new Random();
        return nameFirm[rand.nextInt(8)];
    }

    String randNameShorts() {
        Random rand = new Random();
        return nameShorts[rand.nextInt(8)];
    }


    int randPrice() {
        Random rand = new Random();
        int num = 100 + Math.abs(rand.nextInt());
        return num;
    }

}
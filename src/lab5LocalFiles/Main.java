package lab5LocalFiles;

import lab1.Caps;
import lab1.Clothes;
import lab1.Shorts;
import lab23CollectionsGenerics.Credentials;
import lab23CollectionsGenerics.ShoppingCart;
import lab23CollectionsGenerics.Order;
import lab4Potoki.Orders;

import java.io.IOException;
import java.util.*;


public class Main {
    public static int countObj;

        public static void main(String[] args) throws IOException, ClassNotFoundException {

//            //Credentials user = new Credentials();
//            //        System.out.println("Зарегистрируйтесь, чтобы совершить покупку");
//            //        user.update();
//
//                    Scanner in = new Scanner(System.in);
//                    System.out.println("Выберите интересующую Вас одежду: кепки(caps) или футболки(shorts)");
//                    String form = in.nextLine();
//
//                    switch (form){
//                        case ("caps"):
//                            LinkedList<Order> list;
//                            HashMap<Date, Order> map;
//                        {
//                            System.out.println("Введите количество");
//                            countObj = in.nextInt();
//                            Caps[] arrayCaps = new Caps[countObj];
//                            for (int i = 0; i < countObj; i++) {
//                                arrayCaps[i] = new lab1.Caps();
//                                arrayCaps[i].create();
//                              //  arrayCaps[i].read();
//                            }
//                            ShoppingCart<Caps> cart = new ShoppingCart<Caps>();
//                            for (int i=0; i<countObj; i++){
//                                cart.add(arrayCaps[i]);
//                            }
//                            System.out.println("Оформить заказ (yes/no)");
//                            in.nextLine();
//                            String choice = in.nextLine();
//                            switch (choice) {
//                                case ("yes"):{
//                                    Orders orders = new Orders(list, map);
//                                    orders.offer(cart, user);
////                                }
//                                case("no"):{
//                                    return;
//                                }
//                            }
//                        }
//                        case ("shorts"):{
//                            System.out.println("Введите количество");
//                            int countObj = in.nextInt();
//                            Shorts[] arrayShorts = new Shorts[countObj];
//                            for (int i = 0; i < countObj; i++) {
//                                arrayShorts[i] = new lab1.Shorts();
//                                arrayShorts[i].create();
//                            //    arrayShorts[i].read();
//                            }
//                            ShoppingCart<Shorts> cart = new lab23CollectionsGenerics.ShoppingCart<>();
//                            for (int i=0; i<countObj; i++){
//                                cart.add(arrayShorts[i]);
//                            }
//                            System.out.println("Оформить заказ (yes/no)");
//                            in.nextLine();
//                            String choice = in.nextLine();
//                            switch (choice) {
//                                case ("yes"):{
//                                    Orders orders = new Orders(list, map);
//                                    orders.offer(cart, user);
//                                    orders.show();
////                                    orders.checkTime();
////                                    System.out.println(cart.isExistsUUID(arrayShorts[0].getUUID()));
//                                }
//                                case("no"):{
//                                    return;
//                                }
//                            }
//                        }
//                    }

            Orders<Order> orders = new Orders<>();
            Credentials user = new Credentials("Иванов", "Иван", "Иваныч", "ivanov@mail.ru");
            ShoppingCart<Clothes> cart = new ShoppingCart<>();
            Shorts[] arrayShorts = new Shorts[2];
            Caps[] arrayCaps = new Caps[2];
            for (int i = 0; i < 2; i++) {
                arrayCaps[i] = new Caps();
                arrayCaps[i].create();
                cart.add(arrayCaps[i]);

                arrayShorts[i] = new Shorts();
                arrayShorts[i].create();
                cart.add(arrayShorts[i]);
            }

            orders.offer(cart,user);
            orders.show();

            System.out.println("Как сохранить и прочитать?");
            System.out.println("1.По ID в бинарном виде");
            System.out.println("2.Все в бинарном виде");
            System.out.println("3.По ID в JSON");
            System.out.println("4.Все в JSON");

            Scanner in = new Scanner(System.in);
            String choice = in.nextLine();
            switch (choice){
                case ("1"):
                {
                    ManagerOrderFile mof = new ManagerOrderFile();
                    Order order2 = new Order(cart, user);
                    mof.saveByID(order2);
                    System.out.println("***");
                    System.out.println("Заказ из бинарного файла");
                    System.out.println("***");
                    Order example2 = mof.readByID(order2.getUUID());
                    example2.show();
                    break;
                }
                case ("2"):
                {
                    ManagerOrderFile mof = new ManagerOrderFile();
                    mof.saveAll(orders);
                    Orders example1 = mof.readAll();
                    System.out.println("***");
                    System.out.println("Все заказы из бинарного файла");
                    System.out.println("***");
                    example1.show();
                    break;
                }
                case ("3"):
                {
                    ManagerOrderJSON moj = new ManagerOrderJSON();
                    Order order3 = new Order(cart, user);
                    moj.saveByID(order3);
                    Order example3 = moj.readByID(order3.getUUID());
                    System.out.println("***");
                    System.out.println("Заказы из JSON");
                    System.out.println("***");
                    example3.show();
                    break;
                }
                case ("4"):
                {
                    ManagerOrderJSON moj = new ManagerOrderJSON();
                    moj.saveAll(orders);
                    Orders example = moj.readAll();
                    System.out.println("***");
                    System.out.println("Все заказы из JSON");
                    System.out.println("***");
                    example.show();
                    break;
                }
            }
    }
}



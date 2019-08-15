package lab5LocalFiles;

import lab1.Caps;
import lab1.Shorts;
import lab23CollectionsGenerics.Credentials;
import lab23CollectionsGenerics.Order;
import lab23CollectionsGenerics.ShoppingCart;
import lab4Potoki.CheckDone;
import lab4Potoki.CheckTime;
import lab4Potoki.Generator;
import lab4Potoki.Orders;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static int countObj;

        public static void main(String[] args) throws IOException, ClassNotFoundException {

            //Credentials user = new Credentials();
            //        System.out.println("Зарегистрируйтесь, чтобы совершить покупку");
            //        user.update();

            Credentials user = new Credentials("Иванов", "Иван", "Иваныч", "ivanov@mail.ru");

                    Scanner in = new Scanner(System.in);
                    System.out.println("Выберите интересующую Вас одежду: кепки(caps) или футболки(shorts)");
                    String form = in.nextLine();

                    switch (form){
                        case ("caps"):{
                            System.out.println("Введите количество");
                            countObj = in.nextInt();
                            Caps[] arrayCaps = new Caps[countObj];
                            for (int i = 0; i < countObj; i++) {
                                arrayCaps[i] = new lab1.Caps();
                                arrayCaps[i].create();
                              //  arrayCaps[i].read();
                            }
                            ShoppingCart cart = new ShoppingCart();
                            for (int i=0; i<countObj; i++){
                                cart.add(arrayCaps[i]);
                            }
                            System.out.println("Оформить заказ (yes/no)");
                            in.nextLine();
                            String choice = in.nextLine();
                            switch (choice) {
                                case ("yes"):{
                                    Orders orders = new Orders();
                                    orders.offer(cart, user);

//                                    ManagerOrderFile mof = new ManagerOrderFile();
//                                    mof.saveAll(orders);
//                                    Orders readall = (Orders) mof.readAll();
//                                    readall.show();

//                                    Order orderB = new Order(cart, user);
//                                    mof.saveByID(orderB);
//                                    Order readbyid = mof.readByID(orderB.getUUID());
//                                    readbyid.show();
//
                                    ManagerOrderJSON moj = new ManagerOrderJSON();
                                    moj.saveAll(orders);
                                    Orders readalljson = (Orders) moj.readAll();
                                    readalljson.show();
//
//                                    Order orderJ = new Order(cart, user);
//                                    moj.saveByID(orderJ);
//                                    Order readbyidjson = mof.readByID(orderJ.getUUID());
//                                    readalljson.show();


                                }
                                case("no"):{
                                    return;
                                }
                            }
                        }
                        case ("shorts"):{
                            System.out.println("Введите количество");
                            int countObj = in.nextInt();
                            Shorts[] arrayShorts = new Shorts[countObj];
                            for (int i = 0; i < countObj; i++) {
                                arrayShorts[i] = new lab1.Shorts();
                                arrayShorts[i].create();
                            //    arrayShorts[i].read();
                            }
                            lab23CollectionsGenerics.ShoppingCart cart = new lab23CollectionsGenerics.ShoppingCart();
                            for (int i=0; i<countObj; i++){
                                cart.add(arrayShorts[i]);
                            }
                            System.out.println("Оформить заказ (yes/no)");
                            in.nextLine();
                            String choice = in.nextLine();
                            switch (choice) {
                                case ("yes"):{
                                    Orders orders = new Orders();
                                    orders.offer(cart, user);
                                    orders.show();
                                    orders.checkTime();
                                    System.out.println(cart.isExistsUUID(arrayShorts[0].getUUID()));
                                }
                                case("no"):{
                                    return;
                                }
                            }
                        }
                    }



//            Orders orders = new Orders();
//
//            Thread gen1 = new Thread(new Generator(orders));
//            Thread gen2 = new Thread(new Generator(orders));
//            gen1.start();
//            gen2.start();
//
//            Thread checkTime = new Thread(new CheckTime(orders, 1000));
//            Thread checkDone = new Thread(new CheckDone(orders, 1000));
//            checkTime.start();
//            checkDone.start();

        }}



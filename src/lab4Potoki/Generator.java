package lab4Potoki;

import lab1.Shorts;
import lab23CollectionsGenerics.Credentials;
import lab1.Caps;
import lab23CollectionsGenerics.ShoppingCart;

public class Generator extends ACheck {

    Generator (Orders orders){
        super(orders);
    }

    @Override
    public void run(){
        while (fRun) {
        Orders orders = getOrders();
        ShoppingCart cart = new ShoppingCart();
            Shorts[] arrayShorts = new Shorts[3];
            Caps[] arrayCaps = new Caps[3];
            for (int i = 0; i < 3; i++) {
                arrayCaps[i] = new Caps();
                arrayCaps[i].create();
//                arrayCaps[i].read();
                cart.add(arrayCaps[i]);

                arrayShorts[i] = new Shorts();
                arrayShorts[i].create();
//                arrayShorts[i].read();
                cart.add(arrayShorts[i]);

            }

            Credentials user = new Credentials("Иванов", "Иван", "Иваныч", "ivanov@mail.ru");
            synchronized (orders){
                orders.offer(cart, user);
            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Main {

        public static void main(String[] args) {

    //        lab23CollectionsGenerics.Credentials user = new lab23CollectionsGenerics.Credentials();
    //        System.out.println("Зарегистрируйтесь, чтобы совершить покупку");
    //        user.update();

    //       lab23CollectionsGenerics.Credentials user = new lab23CollectionsGenerics.Credentials("Иванов", "Иван", "Иваныч", "ivanov@mail.ru");
    //
    //        Scanner in = new Scanner(System.in);
    //        System.out.println("Выберите интересующую Вас одежду: кепки(caps) или футболки(shorts)");
    //        String form = in.nextLine();
    //
    //        switch (form){
    //            case ("caps"):{
    //                System.out.println("Введите количество");
    //                int countObj = in.nextInt();
    //                lab1.Caps[] arrayCaps = new lab1.Caps[countObj];
    //                for (int i = 0; i < countObj; i++) {
    //                    arrayCaps[i] = new lab1.Caps();
    //                    arrayCaps[i].create();
    //                    arrayCaps[i].read();
    //                }
    //                lab23CollectionsGenerics.ShoppingCart cart = new lab23CollectionsGenerics.ShoppingCart();
    //                for (int i=0; i<countObj; i++){
    //                    cart.add(arrayCaps[i]);
    //                }
    //                System.out.println("Оформить заказ (yes/no)");
    //                in.nextLine();
    //                String choice = in.nextLine();
    //                switch (choice) {
    //                    case ("yes"):{
    //                        lab4Potoki.Orders orders = new lab4Potoki.Orders();
    //                        orders.offer(cart, user);
    //                        orders.show();
    //                        orders.checkTime();
    //                        System.out.println(cart.isExistsUUID(arrayCaps[0].getUUID()));
    //                    }
    //                    case("no"):{
    //                        return;
    //                    }
    //                }
    //            }
    //            case ("shorts"):{
    //                System.out.println("Введите количество");
    //                int countObj = in.nextInt();
    //                lab1.Shorts[] arrayShorts = new lab1.Shorts[countObj];
    //                for (int i = 0; i < countObj; i++) {
    //                    arrayShorts[i] = new lab1.Shorts();
    //                    arrayShorts[i].create();
    //                    arrayShorts[i].read();
    //                }
    //                lab23CollectionsGenerics.ShoppingCart cart = new lab23CollectionsGenerics.ShoppingCart();
    //                for (int i=0; i<countObj; i++){
    //                    cart.add(arrayShorts[i]);
    //                }
    //                System.out.println("Оформить заказ (yes/no)");
    //                in.nextLine();
    //                String choice = in.nextLine();
    //                switch (choice) {
    //                    case ("yes"):{
    //                        lab4Potoki.Orders orders = new lab4Potoki.Orders();
    //                        orders.offer(cart, user);
    //                        orders.show();
    //                        orders.checkTime();
    //                        System.out.println(cart.isExistsUUID(arrayShorts[0].getUUID()));
    //                    }
    //                    case("no"):{
    //                        return;
    //                    }
    //                }
    //            }
    //        }



        Orders orders = new Orders();

        Thread gen1 = new Thread(new Generator(orders));
        Thread gen2 = new Thread(new Generator(orders));
            gen1.start();
            gen2.start();

        Thread checkTime = new Thread(new CheckTime(orders, 1000));
        Thread checkDone = new Thread(new CheckDone(orders, 1000));
            checkTime.start();
            checkDone.start();

    }}
}

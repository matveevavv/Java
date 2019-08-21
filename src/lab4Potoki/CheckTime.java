//package lab4Potoki;
//
//import lab4Potoki.ACheck;
//
//import java.io.Serializable;
//
//public class CheckTime extends ACheck implements Serializable {
//
//        CheckTime(Orders orders, long pause) {
//            super(orders);
//            this.pause = pause;
//        }
//
//        @Override
//        public void run() {
//            while (fRun){
//                getOrders().checkTime();
//                try {
//                    Thread.sleep(pause);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//

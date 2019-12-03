package homework2.first;

import java.util.Calendar;

public class TestMilkTeaSold {
        public static void main(String[] args) {
            Shop teaShop=new TeaShop();
            teaShop.stock(new Bubble("bubble", Calendar.getInstance()));
            teaShop.stock(new Coconut("coconut", Calendar.getInstance()));
            teaShop.stock(new Bubble("bubble", Calendar.getInstance()));

            teaShop.sell("milktea1","Bubble");
            teaShop.sell("milktea2","Bubble");
            teaShop.sell("milktea3","Coconut");
            teaShop.sell("milktea4","Coconut");

            Calendar calendar=Calendar.getInstance();
            calendar.add(Calendar.DATE,0);
            teaShop.stock(new Coconut("c2",calendar));
            teaShop.sell("milktea4","Coconut");

        }
}

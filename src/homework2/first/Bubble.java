package homework2.first;

import java.util.Calendar;

public class Bubble extends Ingredient{
    public Bubble(String name, Calendar productionDate) {
        super(name, productionDate, 7);      //覆盖重写父类信息
    }

    public String toString() {
        return "Bubble{"+super.toString()+"}";   //返回当前信息和父类信息
    }

}

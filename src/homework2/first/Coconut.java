package homework2.first;

import java.util.Calendar;

public class Coconut extends Ingredient{
    public Coconut(String name, Calendar productionDate) {
        super(name,productionDate,5);      //覆盖重写父类信息
    }

    public String toString() {
        return "Coconut{"+super.toString()+"}";   //返回当前信息和父类信息
    }
}

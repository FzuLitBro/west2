package homework2.first;

import java.util.Calendar;

public abstract class Ingredient {
    protected String name;
    protected Calendar productionDate;
    protected int EXP;

    public Ingredient() {
    }

    public Ingredient(String name, Calendar productionDate, int EXP) {
        this.name = name;
        this.productionDate = productionDate;
        this.EXP = EXP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    @Override
    public String toString() {              //输出信息
        return "配料信息{" +
                "配料名称：'" + name + '\'' +
                ", 生产日期：" + productionDate.getTime() +
                ", 保质期：" + EXP + "天" +
                '}';
    }

    public Calendar getLeaveTime(){        //异常分析
        Calendar expireTime=(Calendar) productionDate.clone();
        expireTime.add(Calendar.DATE,EXP);
        return expireTime;
    }
}

package homework2.first;

public class MilkTea {
    private String name;
    private Ingredient ingredient;  //创建一个配料类成员变量

    public MilkTea() {
    }

    public MilkTea(String name, Ingredient ingredient) {
        this.name = name;
        this.ingredient = ingredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {          //通过创建的ingredient访问当前奶茶信息
        return "奶茶信息{" +
                "奶茶名称：'" + name + '\'' +
                ", 配料：" + ingredient +
                '}';
    }

}

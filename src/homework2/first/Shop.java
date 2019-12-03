package homework2.first;

public interface Shop {             //TeaShop的接口
    public void stock(Ingredient ingredient);   //通过配料名称进货
    public void sell(String teaName, String ingredientName);    //通过传入奶茶名称和配料名称卖奶茶
}


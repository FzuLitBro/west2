package homework2.first;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TeaShop implements Shop {
    List<Bubble> BubbleList;
    List<Coconut> CoconutList;

    public TeaShop() {  //无参进行构造两个数组存储Bubble&Coconut数据
        BubbleList = new ArrayList<Bubble>();
        CoconutList =new ArrayList<Coconut>();
    }
    private void addBubble(Bubble bubble){  //在进货时将数据加入到Arraylist中去
        BubbleList.add(bubble);
    }
    private void addCoconut(Coconut coconut){   //在进货时将数据加入到Arraylist中去
        CoconutList.add(coconut);
    }
    public List<Bubble> getBubbleList() {
        return BubbleList;
    }

    public List<Coconut> getCoconutList() {
        return CoconutList;
    }

    //进货
    public void stock(Ingredient ingredient) {
        if(ingredient instanceof Bubble) {
            addBubble((Bubble) ingredient);            //向下转型
        }
        else if(ingredient instanceof Coconut){
            addCoconut((Coconut) ingredient);
        }
    }

    //卖奶茶（需要考虑到奶茶过期问题）,在每次卖奶茶前将把过期奶茶移除，考虑到进货时间是按顺序的，可保证数组前面元素日期早于后面元素
    public void sell(String teaName, String ingredientName){

        while(!BubbleList.isEmpty()){
            Bubble headB=BubbleList.get(0);
            if(headB.getLeaveTime().compareTo(Calendar.getInstance())<0){
                BubbleList.remove(0);
            }
            else
                break;
        }
        while(!CoconutList.isEmpty()){
            Coconut headC = CoconutList.get(0);
            if(headC.getLeaveTime().compareTo(Calendar.getInstance())<0){
                CoconutList.remove(0);
            }
            else
                break;
        }

        //判断是否卖完了。catch掉异常
        try{
            if(ingredientName.equals("Bubble")){
                if(BubbleList.isEmpty())
                    throw new SoldOut("Bubble");
                else {
                    MilkTea milkTea=new MilkTea(teaName,BubbleList.get(0));
                    BubbleList.remove(0);
                    System.out.println(milkTea+"\n"+"珍珠奶茶，欢迎品用");
                }
            }
            else if(ingredientName.equals("Coconut")){
                if(CoconutList.isEmpty())
                    throw new SoldOut("Coconut");
                else{
                    MilkTea milkTea=new MilkTea(teaName,CoconutList.get(0));
                    CoconutList.remove(0);
                    System.out.println(milkTea+"\n"+"椰果奶茶，欢迎品用");
                }
            }
        }catch (SoldOut e){
            e.printStackTrace();
        }
    }
}

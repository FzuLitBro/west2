package homework2.first;

public class SoldOut extends Exception{
    public SoldOut(String m) {
        super(m);
    }
    //重写返回异常信息方法
    @Override
    public void printStackTrace() {
        System.err.println("对不起，你要的奶茶： "+super.getMessage()+" 已经售完");
    }
}

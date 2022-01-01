import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRepository implements Iterator<Order> {
    List<Order> orders = new ArrayList<>();

    private Iterator<Order> OrderIterator;

    public OrderRepository(){
        OrderIterator = orders.iterator();
    }

    public void add(Order o){
        orders.add(o);
        OrderIterator = orders.iterator();
    }

    @Override
    public boolean hasNext() { return OrderIterator.hasNext(); }

    @Override
    public Order next() {
        Order o = orders.get(0);
        orders.remove(0);
        return o;
    }

    @Override
    public String toString(){
        String OrderOutput = "--- 주문 관리자 화면 ---\n";
        OrderOutput += "현재 주문수는 총 " + orders.size() + " 입니다.\n\n";
        OrderOutput += "< 주문 내역 >\n";
        for (Order o : orders){
            OrderOutput += o;
        }
        return OrderOutput;
    }
}
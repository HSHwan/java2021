import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();

    private static int orderCounter = 1;
    private int orderNo ;

    private Order.PickUp delivery;

    public static interface PickUp {
        public abstract void handle(Order o);
    }

    public Order(){
        orderNo = orderCounter;
        orderCounter++;
    }

    public void addItem(OrderItem orderItem){
        items.add(orderItem);
    }

    public void setPickUp(Order.PickUp pickup){
        delivery = pickup;
    }

    public int getOrderNo(){
        return orderNo;
    }

    public void completed(){
        delivery.handle(this);
    }

    @Override
    public String toString(){
        String OrderList = String.format("주문번호: %d - [",orderNo);
        for (int i = 0; i < items.size()-1; i++){
            OrderList += items.get(i) + ", " ;
        }
        OrderList += items.get(items.size()-1) + "]\n";
        return OrderList;
    }
}
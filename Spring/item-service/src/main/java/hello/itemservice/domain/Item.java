package hello.itemservice.domain;

import lombok.Data;

@Data //Domain 객체에는 Data를 사용하는 것이 좋지 않음(getter, setter, RequiredArgsConstructor, toString 등 모든 메서드가 생성되기 때문). 예제의 단순성을 위하여 사용함
public class Item {
    private Long id;
    private String itemName;
    private Integer price; //Integer는 int의 값 + Null값을 가질 수 있음
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

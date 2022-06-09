package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); //HashMap은 Thread-safe하지 않기에, 멀티 쓰레드 환경에서 위험함. 프로젝트의 단순성 때문에 그냥 사용함. 실제 서비스에서는 ConcurrentHashMap 같은 클래스로 사용해야함.
    private static Long sequence = 0L; // Long 또한 Thread-safe 하지 않음. 실제 Service 환경에서는 AtomicLong을 사용해야함.

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}

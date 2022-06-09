package hello.itemservice.web.basic;

import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // final 붙은 필드를 가지고 생성자를 자동 작성해준다.
public class BasicItemController {

    private final ItemRepository itemRepository;

/**    @Autowired // 생성자가 하나이면 @Autowired 생략가능
 +    public BasicItemController(ItemRepository itemRepository){ //@RequiredArgsConstructor가 눈에 보이지 않아도 자동 작성해주기 때문에 생략가능
 +        this.itemRepository = itemRepository;
 +    }
 */

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

    //@PostMapping("/add")
    public String addItemV1(@RequestParam String itemName, @RequestParam int price, @RequestParam Integer quantity, Model model){
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item", item);
        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model){
        itemRepository.save(item);
//        model.addAttribute("item", item); // 자동 추가, 생략 가능. ModelAttribute에 전달한 이름으로 model에 자동 추가됨.

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item, Model model){
        itemRepository.save(item);
//        model.addAttribute("item", item); // ModelAttribute에 이름을 따로 지어주지 않으면, parameter로 전달받는 객체 클래스명의 첫글자를 소문자로하여 자동으로 model에 추가해줌. ex) HelloData -> helloData로 등록.

        return "basic/item";
    }

    //@PostMapping("/add")
    public String addItemV4(/*@ModelAttribute*/Item item){ //단순 data 타입이 아니면 @ModelAttribute가 붙은걸로 간주하고, 단순 data 타입이면 @RequestParam이 붙은걸로 Spring이 자동으로 지정함.
        itemRepository.save(item);
        return "basic/item";
    }

    //@PostMapping("/add")
    public String addItemV5(Item item){
        itemRepository.save(item);
        return "redirect:/basic/items/" + item.getId();
    }

    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes){
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", item.getId());
        redirectAttributes.addAttribute("status", true); //return에 사용되지 않는 attribute들은 Query Parameter 형식으로 들어가게 된다. /basic/items/1?status=true
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item){
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }
    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}

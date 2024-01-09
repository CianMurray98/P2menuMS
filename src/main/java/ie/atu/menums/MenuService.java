package ie.atu.menums;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    private final Map<String, MenuItems > menuData = new HashMap<>();

    public MenuService() {
        // Add some dummy menu items as initial data
        MenuItems dummyItem1 = new MenuItems();
        dummyItem1.setItemId("ITEM001");
        dummyItem1.setName("Margherita Pizza");
        dummyItem1.setDescription("Classic pizza with tomato sauce and mozzarella cheese");
        dummyItem1.setPrice(new BigDecimal("10.99"));

        MenuItems dummyItem2 = new MenuItems();
        dummyItem2.setItemId("ITEM002");
        dummyItem2.setName("Chicken Alfredo Pasta");
        dummyItem2.setDescription("Creamy Alfredo pasta with grilled chicken");
        dummyItem2.setPrice(new BigDecimal("12.99"));

        menuData.put(dummyItem1.getItemId(), dummyItem1);
        menuData.put(dummyItem2.getItemId(), dummyItem2);
    }

    public List<MenuItems> getAllMenuItems() {
        return new ArrayList<>(menuData.values());
    }

    public MenuItems getMenuItemsById(String itemId) {
        return menuData.get(itemId);
    }

    public void saveMenuItems(MenuItems menuItem) {
        menuData.put(menuItem.getItemId(), menuItem);
        System.out.println("Menu item saved: " + menuItem);
    }

    // Additional methods for updating or deleting menu items
}
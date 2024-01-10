package ie.atu.menums;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MenuDataInitializer implements CommandLineRunner {

    private final MenuService menuService;

    public MenuDataInitializer(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public void run(String... args) {
        // Add dummy menu items on startup
        MenuItems dummyItem1 = new MenuItems();
        dummyItem1.setItemId("I0001");
        dummyItem1.setName("Margherita Pizza");
        dummyItem1.setDescription("Classic pizza with tomato sauce and mozzarella cheese");
        dummyItem1.setPrice(new BigDecimal("10.99"));

        MenuItems dummyItem2 = new MenuItems();
        dummyItem2.setItemId("I0002");
        dummyItem2.setName("Chicken Alfredo Pasta");
        dummyItem2.setDescription("Creamy Alfredo pasta sauce with grilled chicken");
        dummyItem2.setPrice(new BigDecimal("12.99"));

        menuService.saveMenuItems(dummyItem1);
        menuService.saveMenuItems(dummyItem2);
    }
}
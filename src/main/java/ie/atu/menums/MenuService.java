package ie.atu.menums;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepo;

    public MenuService(MenuRepository menuRepo) {
        this.menuRepo = menuRepo;
    }

    public void saveMenuItems(MenuItems menuItem) {
        menuRepo.save(menuItem);
    }

    public List<MenuItems> getAllMenuItems() {
        return menuRepo.findAll();
    }

    public Optional<MenuItems> getMenuItemsById(@NotBlank(message = "Item ID cannot be blank") Long itemId) {
        return menuRepo.findById(itemId);
    }

    public void updateMenuItems(MenuItems menuItem) {
        menuRepo.save(menuItem);
    }

    public void deleteMenuItemsById(Long itemId) {
        menuRepo.deleteById(itemId);
    }
}
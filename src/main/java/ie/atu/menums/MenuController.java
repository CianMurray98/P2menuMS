package ie.atu.menums;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RequestMapping("/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/all")
    public ResponseEntity<List<MenuItems>> getAllMenuItems() {
        List<MenuItems> menuItems = menuService.getAllMenuItems();
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<MenuItems> getMenuItemsById(
            @PathVariable @NotBlank(message = "Item ID cannot be blank") Long itemId) {
        Optional<MenuItems> optionalMenuItems = menuService.getMenuItemsById(itemId);

        return optionalMenuItems.map(menuItems ->
                        new ResponseEntity<>(menuItems, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createMenuItem")
    public ResponseEntity<String> createMenuItem(@RequestBody @Valid MenuItems menuItem) {
        menuService.saveMenuItems(menuItem);
        return new ResponseEntity<>("Menu item created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/updateMenuItem")
    public ResponseEntity<String> updateMenuItem(@RequestBody @Valid MenuItems menuItem) {
        menuService.updateMenuItems(menuItem);
        return new ResponseEntity<>("Menu item updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteMenuItem/{itemId}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable @NotBlank(message = "Item ID cannot be blank") Long itemId) {
        menuService.deleteMenuItemsById(itemId);
        return new ResponseEntity<>("Menu item deleted successfully", HttpStatus.OK);
    }
}

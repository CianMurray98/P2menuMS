package ie.atu.menums;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuItems {

    @NotBlank(message = "Item ID cannot be blank")
    @Size(min = 5, max = 10, message = "Item ID must be between 5 and 10 characters")
    private String itemId;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 5, max = 200, message = "Description must be between 5 and 200 characters")
    private String description;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    // Add other attributes as needed

}
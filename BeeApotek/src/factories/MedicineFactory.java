package factories;

import models.Medicine;

public interface MedicineFactory {
	Medicine createMedicine(String name, String id, int quantity, String category, String type, int price);
}

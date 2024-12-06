package factories;

import models.Headache;
import models.Medicine;

public class HeadacheFactory implements MedicineFactory {

	@Override
	public Medicine createMedicine(String name, String id, int quantity, String category, String type, int price) {
		Headache headache = new Headache(name,id,quantity,category,type,price);
		return headache;
	}

}

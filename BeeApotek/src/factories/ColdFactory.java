package factories;

import models.Cold;
import models.Medicine;

public class ColdFactory implements MedicineFactory{

	@Override
	public Medicine createMedicine(String name, String id, int quantity, String category, String type, int price) {
		Cold cold = new Cold(name,id,quantity,category,type,price);
		return cold;
	}

}

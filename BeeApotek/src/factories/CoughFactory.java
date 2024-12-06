package factories;

import models.Cough;
import models.Medicine;

public class CoughFactory implements MedicineFactory {

	@Override
	public Medicine createMedicine(String name, String id, int quantity, String category, String type, int price) {
		Cough cough = new Cough(name,id,quantity,category,type,price);
		return cough;
	}

}

package factories;

import models.Flu;
import models.Medicine;

public class FluFactory implements MedicineFactory{

	@Override
	public Medicine createMedicine(String name, String id, int quantity, String category, String type, int price) {
		Flu flu = new Flu(name,id,quantity,category,type,price);
		return flu;
	}

}

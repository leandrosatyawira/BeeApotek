package adapters;

import models.Medicine;

public class RupiahAdapter {
	private Rupiah rupiah;
	public RupiahAdapter(Rupiah rupiah) {
		this.rupiah = rupiah;
	}
	public int calculateRupiahPrice(Medicine medicine) {
		int price = medicine.getPrice();
		return rupiah.Rupiah(price);
	}
}

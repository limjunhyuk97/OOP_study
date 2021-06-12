package car;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

import parkingLot.parkingLotTemplate.LeaveTicket;

// �ڵ��� . �¿��� > ����
public class ElectronicCar extends Car{

	private final int FULLBATTERY = 60;
	private final double INITBATTERY;
	private double battery;
	
	// ������ ������ ElectronicCar constructor
	public ElectronicCar(String carType, int carNum, int year, int month, int day, int hour, int minute, double curBattery){
		super(carType, carNum, year, month, day, hour, minute);
		this.INITBATTERY = curBattery;
		this.battery = curBattery;
	}
	
	// ������ ���͸� Battery 
	public void setBattery() {
		if(((int)this.getParkingTime() * 0.5) + INITBATTERY < FULLBATTERY) {
			this.battery += (this.getParkingTime() * 0.5);
		}
		else {
			this.battery = this.FULLBATTERY;
		}
	}
	public double getBattery() {
		return this.battery;
	}
	
	// ������ �������� showData
	public String showData(LocalDateTime t) {
		
		setCarCur(t);
		setParkingTime(this.getCarIn(), this.getCarCur());
		setBattery();
		
		DecimalFormat form = new DecimalFormat("#.#");
		return this.getCarType() + " " + this.getCarNum() + "�� \n�����ð�:" + this.getCarIn().getYear() + "-" + this.getCarIn().getMonthValue() + "-" + this.getCarIn().getDayOfMonth() + " " + this.getCarIn().getHour() + ":" + this.getCarIn().getMinute() + " \n����: " + form.format(this.getBattery()) + "KW";
	}
	
	// ������ ���� ���� showLeave
	public LeaveTicket showLeave(LocalDateTime t) {
		
		setCarCur(t);
		setParkingTime(this.getCarIn(), this.getCarCur());
		setBattery();
		
		DecimalFormat form = new DecimalFormat("#.#");
		
		return new LeaveTicket(Fee() + FeeElectric(), "�ѿ��(" + this.getCarNum() + "): " + (this.Fee() + this.FeeElectric()) + "��\n"
				+ " - ������� : " + this.Fee() + "��(�����ð�: " + ((int)this.getParkingTime() / 60) + "�ð� " + ((int)this.getParkingTime() % 60) + "��)\n"
						+ " - ������� : " + this.FeeElectric() + "��(������: " + form.format(this.getBattery() - this.INITBATTERY) + "KW)");
	}
	
	// ������ ��� Fee
	public int Fee() {
		return 500 + (int)Math.ceil(((double)(this.getParkingTime() - 30)/10)) * 100;
	}
	
	public int FeeElectric() {
		return (int)((this.battery - this.INITBATTERY) * 400);
	}
	
}
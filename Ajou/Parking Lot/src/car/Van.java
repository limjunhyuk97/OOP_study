package car;

import java.time.LocalDateTime;

import parkingLot.parkingLotTemplate.LeaveTicket;

public class Van extends Car{
	
	private VanSize carSize;
	
	// �� ������ van constructor
	public Van(String carType, int carNum, int year, int month, int day, int hour, int minute, int carSize) {
		super(carType, carNum, year, month, day, hour, minute);
		this.carSize = VanSize.values()[carSize-1];
	}
	
	// �� ũ��
	public VanSize getVanSize() { return carSize; }
	public void setVanSize(int carSize) { this.carSize = VanSize.values()[carSize]; }
	
	// �� �������� showData
	public String showData(LocalDateTime t) {
		return this.getCarType() + " " + this.getCarNum() + "�� \n�����ð�:" + this.getCarIn().getYear() + "-" + this.getCarIn().getMonthValue() + "-" + this.getCarIn().getDayOfMonth() + " " + this.getCarIn().getHour() + ":" + this.getCarIn().getMinute() + " \n�� ũ��: " + this.getVanSize();
	}
	
	// �� �������� showLeave
	public LeaveTicket showLeave(LocalDateTime t) {
		
		setCarCur(t);
		setParkingTime(this.getCarIn(), this.getCarCur());

		return new LeaveTicket(this.Fee(), "�������(" + this.getCarNum() + "��) : " + this.Fee() + "�� \n(�����ð� " + ((int)this.getParkingTime() / 60) + "�ð� " + ((int)this.getParkingTime() % 60) + "��)");
	}
	
	// �� ��� Fee
	public int Fee() {
		switch(this.carSize) {
		case A:
			return (int)Math.ceil(((double)(this.getParkingTime())/10)) * 500;
			
		case B:
			return (int)Math.ceil(((double)(this.getParkingTime())/10)) * 300;
		
		case C:
			return (int)Math.ceil(((double)(this.getParkingTime())/10)) * 200;
			
		default:
			return 0;
		}
	}
	
}
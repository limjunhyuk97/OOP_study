package car;

import java.time.LocalDateTime;

import parkingLot.parkingLotTemplate.LeaveTicket;

// �ڵ��� . �¿��� > ���ָ� > ����
public class MidsizeGasolineCar extends GasolineCar{

	// ���� ������
	public MidsizeGasolineCar(String carType, int carNum, int year, int month, int day, int hour, int minute, int engineDisplacement) {
		super(carType, carNum, year, month, day, hour, minute, engineDisplacement);
	}
	
	// ���� �������� showData
	public String showData(LocalDateTime t) {
		return this.getCarType() + " " + this.getCarNum() + "�� \n�����ð�:" + this.getCarIn().getYear() + "-" + this.getCarIn().getMonthValue() + "-" + this.getCarIn().getDayOfMonth() + " " + this.getCarIn().getHour() + ":" + this.getCarIn().getMinute() + " \n��ⷮ: " + this.getEngineDisplacement();
	}
	
	// ���� �������� showLeave
	public LeaveTicket showLeave(LocalDateTime t) {

		setCarCur(t);
		setParkingTime(this.getCarIn(), this.getCarCur());
		
		return new LeaveTicket(this.Fee(), "�������(" + this.getCarNum() + "��) : " + this.Fee() + "�� \n(�����ð� " + ((int)this.getParkingTime() / 60) + "�ð� " + ((int)this.getParkingTime() % 60) + "��)");
	}
	
	// ���� ��� Fee
	public int Fee() {
		return ( (500 + (int)Math.ceil(((double)(this.getParkingTime() - 30)/10)) * 100) / 2 );
	}
	
}

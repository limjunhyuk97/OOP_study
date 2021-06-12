package car;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import parkingLot.parkingLotTemplate.LeaveTicket;

// �ڵ���
public abstract class Car {
	
	private String carType;
	private int carNum;
	private LocalDateTime in = null;
	private LocalDateTime cur = null;
	private long parkingTime = 0;
	
	// Car Constructor
	public Car(String carType, int carNum, int year, int month, int day, int hour, int minute) {
		
		if(carType.equals("g")) this.carType = "�¿���";
		else if(carType.equals("e")) this.carType = "������";
		else if(carType.equals("v")) this.carType = "��";
		else {}
		
		this.carNum = carNum;
		in = LocalDateTime.of(year, month, day, hour, minute);
	}
	
	// �������� carType
	public String getCarType() {return this.carType;}
	public void setCarType(String carType) {this.carType = carType;}
	
	// ������ȣ carNum
	public int getCarNum(){return this.carNum;}
	public void setCarNum(int carNum) {this.carNum = carNum;}
	
	// �����ð� carIn
	public LocalDateTime getCarIn() {
		if(in == null)
			return null;
		return in;
	}
	public void setCarIn(LocalDateTime t) {
		this.in = t;
	}
	
	// ��ɽð�+�����ð� carCur
	public LocalDateTime getCarCur() {
		if(cur == null)
			return null;
		else
			return cur;
	}
	public void setCarCur(LocalDateTime t) {
		this.cur = t;
	}
	
	// �����ð� parkingTime(��)
	public long getParkingTime() { return this.parkingTime; }
	public void setParkingTime(LocalDateTime t1, LocalDateTime t2) {
		this.parkingTime = ( ChronoUnit.MINUTES.between(t1, t2) );
	}
	
	// ��������
	public abstract String showData(LocalDateTime t);
	
	// ����
	public abstract LeaveTicket showLeave(LocalDateTime t);

	// ���
	public abstract int Fee();
		
}
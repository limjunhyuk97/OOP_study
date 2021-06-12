package car;

import java.time.LocalDateTime;

import parkingLot.parkingLotTemplate.LeaveTicket;

// �ڵ��� . �¿��� > ���ָ�
public abstract class GasolineCar extends Car{
	
	private int engineDisplacement;
	
	// ���ָ� ������ GasolineCar constructor
	public GasolineCar(String carType, int carNum, int year, int month, int day, int hour, int minute, int engineDisplacement){
		super(carType, carNum, year, month, day, hour, minute);
		this.engineDisplacement = engineDisplacement;
	}
	
	// ���ָ� ��ⷮ engineDisplacement
	public void setEngineDisplacement(int engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}
	public int getEngineDisplacement() {
		return this.engineDisplacement;
	}
	
	// ���ָ� ��������
	public abstract String showData(LocalDateTime t);
	
	// ���ָ� ��������
	public abstract LeaveTicket showLeave(LocalDateTime t);
	
	// ���ָ� ���
	public abstract int Fee();
	
}

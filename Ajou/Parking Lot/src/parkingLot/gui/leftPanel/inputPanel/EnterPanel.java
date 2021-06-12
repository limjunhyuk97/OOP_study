package parkingLot.gui.leftPanel.inputPanel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import parkingLot.gui.MainFrame;
import parkingLot.gui.leftPanel.InputPanel;
import parkingLot.parkingLotTemplate.CarData;

public class EnterPanel extends JPanel{
	
	// Layout
	private GridBagLayout gb;
	private GridBagConstraints gbc;
	
	private MainFrame parent;
	private InputPanel rootPanel;
	
	private String carType;
	private int carNum, additionalInfo;
	
	private JPanel carTypePanel, carNumPanel, additionalInfoPanel;
	private JLabel carTypeLabel, carNumLabel, additionalInfoLabel;
	private ButtonGroup cartypeButtonGroup;
	private JTextField carNumTextField;
	private JTextField additionalInfoTextField;
	private JButton inputButton;
	
	private static final int DEFAULT_TYPE = 1;
	private static final String DEFAULT_NAME = "g";
	
	public EnterPanel(MainFrame parent, InputPanel rootPanel) {
		
		this.parent = parent;
		this.rootPanel = rootPanel;
		
		// Layout
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		setLayout(fl);
		gb = new GridBagLayout();
        setLayout(gb);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
		
		// Label
		carTypeLabel = new JLabel("���� �Է� (g/e/v) :");
		carTypeLabel.setFont(new Font("���� ���", Font.BOLD, 13));
		carNumLabel = new JLabel("���� ��ȣ :");
		carNumLabel.setFont(new Font("���� ���", Font.BOLD, 13));
		additionalInfoLabel = new JLabel("�ΰ� ���� :");
		additionalInfoLabel.setFont(new Font("���� ���", Font.BOLD, 13));
		
		// Panel
		carTypePanel = new JPanel(); carTypePanel.setLayout(fl);
		carNumPanel = new JPanel(); carNumPanel.setLayout(fl);
		additionalInfoPanel = new JPanel(); additionalInfoPanel.setLayout(fl);
		
		// carType
		carTypePanel.add(carTypeLabel);
		cartypeButtonGroup = new ButtonGroup();
		addRadioButton("g", 1);
		addRadioButton("e", 2);
		addRadioButton("v", 3);
		
		// carNum
		carNumPanel.add(carNumLabel);
		carNumTextField = new JTextField(5);
		carNumPanel.add(carNumTextField);
		
		// AdditionalInfo
		additionalInfoPanel.add(additionalInfoLabel);
		additionalInfoTextField = new JTextField(5);
		additionalInfoTextField.addActionListener(event->{
			EnterPanel.this.carNum = Integer.parseInt(carNumTextField.getText());
			EnterPanel.this.additionalInfo = Integer.parseInt(additionalInfoTextField.getText());
			
			// �ùٸ� ������ ���Դٸ�
			if(carDataFilter(carType, carNum, additionalInfo)) {
				EnterPanel.this.parent.setCarType(carType);
				EnterPanel.this.parent.setCarNum(carNum);
				EnterPanel.this.parent.setAdditionalInfo(additionalInfo);
				EnterPanel.this.parent.setCmdType("enter");
				EnterPanel.this.parent.setCmdInput(true);
				if(EnterPanel.this.parent.commandCheck()) {
					// ��� �Է� �ֽ�ȭ, time ���̴� �� ����
					int year = EnterPanel.this.parent.getTimeLine().getYear();
					int month = EnterPanel.this.parent.getTimeLine().getMonthValue();
					int date = EnterPanel.this.parent.getTimeLine().getDayOfMonth();
					int hour = EnterPanel.this.parent.getTimeLine().getHour();
					int minute = EnterPanel.this.parent.getTimeLine().getMinute();
					EnterPanel.this.rootPanel.getCommandStackPanel().appendCommandTime(year, month, date, hour, minute, EnterPanel.this.parent.getCmdType());
					EnterPanel.this.rootPanel.getTimePanel().setOutputTimeLabel("");
					EnterPanel.this.rootPanel.updateInterfacePanel();
				}
			}
			
			// �ƴϸ� ���� �߻�
			else {
				
			}
		});
		additionalInfoPanel.add(additionalInfoTextField);
		
		// InputButton
		inputButton = new JButton("�Է�");
		inputButton.addActionListener(event->{
			EnterPanel.this.carNum = Integer.parseInt(carNumTextField.getText());
			EnterPanel.this.additionalInfo = Integer.parseInt(additionalInfoTextField.getText());
			
			// �ùٸ� ������ ���Դٸ�
			if(carDataFilter(carType, carNum, additionalInfo)) {
				EnterPanel.this.parent.setCarType(carType);
				EnterPanel.this.parent.setCarNum(carNum);
				EnterPanel.this.parent.setAdditionalInfo(additionalInfo);
				EnterPanel.this.parent.setCmdType("enter");
				EnterPanel.this.parent.setCmdInput(true);
				if(EnterPanel.this.parent.commandCheck()) {
					// ��� �Է� �ֽ�ȭ, time ���̴� �� ����
					int year = EnterPanel.this.parent.getTimeLine().getYear();
					int month = EnterPanel.this.parent.getTimeLine().getMonthValue();
					int date = EnterPanel.this.parent.getTimeLine().getDayOfMonth();
					int hour = EnterPanel.this.parent.getTimeLine().getHour();
					int minute = EnterPanel.this.parent.getTimeLine().getMinute();
					EnterPanel.this.rootPanel.getCommandStackPanel().appendCommandTime(year, month, date, hour, minute, EnterPanel.this.parent.getCmdType());
					EnterPanel.this.rootPanel.getTimePanel().setOutputTimeLabel("");
					EnterPanel.this.rootPanel.updateInterfacePanel();
					EnterPanel.this.parent.command();
				}
			}
			
			// �ƴϸ� ���� �߻�
			else {
				
			}
		});
		
		// Layout
		gbAdd(carTypePanel, 0, 0, 1, 1, 0, 0);
		gbAdd(carNumPanel, 0, 1, 1, 1, 0, 0);
		gbAdd(additionalInfoPanel, 0, 2, 1, 1, 0, 0);
		gbAdd(inputButton, 0, 3, 1, 1, 0, 0);
		
	}
	
	public void addRadioButton(String name, int type) {
		boolean selected = (type == DEFAULT_TYPE);
		if(name.equals(DEFAULT_NAME)) carType = name;
		JRadioButton rb = new JRadioButton(name, selected);
		rb.addActionListener(event->{
			carType = name;
		});
		cartypeButtonGroup.add(rb);
		carTypePanel.add(rb);
	}
	
	// ������ ���� ��� ���� �䱸
	public boolean carDataFilter(String type, int num, int info) {
		
		String carType = type;
		int carNum = num;
		int selec = info;
		
		// ���� ���� ���� �Է� ���� [����� ����] 
		if(!(carType.equals("g") || carType.equals("e") || carType.equals("v")))
			return false;
		
		// ������ �Ӽ��ΰ�?
		if(carNum < 1000 || carNum > 9999) {
			parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Car number invalid");
			return false;
		}
		
		if(carType.equals("g")) {
			// ������ ���ΰ�?
			if(selec <= 0) {
				parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Engine Displacement invalid");
				return false;
			}
		}
		else if(carType.equals("e")) {
			// electric : ������ ���ΰ�?
			if(selec <= 0 || selec > 60) {
				parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Battery Level invalid");
				return false;
			}
		}
		else if(carType.equals("v")) {
			// ������ ���ΰ�?
			if(selec <= 0 || selec > 3) {
				parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Van size invalid");
				return false;
			}
		}
		
		// (��ȣ ��) �̹� ������ �� �̴�.
		for(int i=0; i<parent.getMaxCar().MAXCAR; ++i) {
			if(parent.getParkingLot()[i] == null) continue;
			// �̹� ������ ���� ���� �� ��ȣ�� ���ϴ°�?
			if(parent.getParkingLot()[i].getCarNum() == carNum) {
				parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Car number (" + carNum + ") already parked!\n");
				return false;
			}
		}
		
		// (��ȣ ��) ������ �����ߴ� ���ε�, �Ӽ� ��������?
		for(int i=0; i<parent.getCarDataBook().size(); ++i) {
			CarData tmp = parent.getCarDataBook().get(i);
			// ������ ������ ���� ���� �� ��ȣ�� ���ϴµ�, �� �Ӽ��� �ٸ���?
			if(tmp.getCarNum() == carNum) {
				if(!tmp.getCarType().equals(carType)) {
					parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Wrong car type input");
					return false;
				}
				else {
					if(carType.equals("g")) {
						// gasoline : �Ӽ��� �ٸ���?
						if((tmp.getEngineDisplacement() != selec)) {
							parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Wrong engine displacement input");
							return false;
						}
					}
					else if(carType.equals("v")) {
						// van : �Ӽ��� �ٸ���?
						if((tmp.getVanSize().ordinal()+1) != selec) {
							parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Wrong van size input");
							return false;
						}
					}
				}
			}			
		}
							
		// �̿ܿ� ������ ��Ȳ�̴� (0)
		return true;
		
	} // carDataFilter method end
	
	private void gbAdd(JComponent c, int x, int y, int w, int h, double gbcw, double gbch){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.weightx = gbcw;
        gbc.weighty = gbch;
        gbc.insets = new Insets(2, 2, 2, 2);
        add(c, gbc);
    }
	
	public String toString() { return "enter"; }
}













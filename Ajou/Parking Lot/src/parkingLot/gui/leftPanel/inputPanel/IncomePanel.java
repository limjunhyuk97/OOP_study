package parkingLot.gui.leftPanel.inputPanel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import parkingLot.gui.MainFrame;
import parkingLot.gui.leftPanel.InputPanel;

public class IncomePanel extends JPanel{
	
	private int year, month, date;
	private boolean timeCheck = false;
	
	// Layout
	private GridBagLayout gb;
	private GridBagConstraints gbc;
	
	private MainFrame parent;
	private InputPanel rootPanel;
	
	private JPanel yearPanel, monthPanel, datePanel;
	private JLabel yearLabel, monthLabel, dateLabel;
	private JTextField yearTextField, monthTextField, dateTextField;
	private JButton inputButton;
	
	public IncomePanel(MainFrame parent, InputPanel rootPanel) {
		
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
		yearLabel = new JLabel("�� :");
		yearLabel.setFont(new Font("���� ���", Font.BOLD, 13));
		monthLabel = new JLabel("�� :");
		monthLabel.setFont(new Font("���� ���", Font.BOLD, 13));
		dateLabel = new JLabel("�� :");
		dateLabel.setFont(new Font("���� ���", Font.BOLD, 13));
		
		// Panel
		yearPanel = new JPanel(); yearPanel.setLayout(fl);
		monthPanel = new JPanel(); monthPanel.setLayout(fl);
		datePanel = new JPanel(); datePanel.setLayout(fl);
				
		// Year
		yearPanel.add(yearLabel);
		yearTextField = new JTextField(5);
		yearPanel.add(yearTextField);
		
		// Month
		monthPanel.add(monthLabel);
		monthTextField = new JTextField(5);
		monthPanel.add(monthTextField);
		
		// Date
		datePanel.add(dateLabel);
		dateTextField = new JTextField(5);
		dateTextField.addActionListener(event->{
			IncomePanel.this.year = Integer.parseInt(yearTextField.getText());
			IncomePanel.this.month = Integer.parseInt(monthTextField.getText());
			IncomePanel.this.date = Integer.parseInt(dateTextField.getText());
			if(IncomePanel.this.parent.getAccountingBook().size() == 0) {
				// ���� ó�� ���� OutputInterface�� ��� : ���� accountingBook�� �������� ����
				parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Income Data doesn't exist\n");
				IncomePanel.this.rootPanel.updateInterfacePanel();
			}
			else {
				if(IncomePanel.this.parent.getCmdTimeInput()) {
					for(int i = 0; i<IncomePanel.this.parent.getAccountingBook().size(); ++i) {
						// ��ġ�ϴ� ��¥�� ã�� ���
						if( IncomePanel.this.parent.getAccountingBook().get(i).getLocalDateTime().equals(LocalDateTime.of(year, month, date, 0, 0)) ) {
							IncomePanel.this.timeCheck = true;
							IncomePanel.this.parent.setIncomeYear(IncomePanel.this.year);
							IncomePanel.this.parent.setIncomeMonth(IncomePanel.this.month);
							IncomePanel.this.parent.setIncomeDate(IncomePanel.this.date);
							IncomePanel.this.parent.setCmdType("income");
							IncomePanel.this.parent.setCmdInput(true);
							// income ������ ���� ó��
							if(IncomePanel.this.parent.commandCheck()) {
								int year = IncomePanel.this.parent.getTimeLine().getYear();
								int month = IncomePanel.this.parent.getTimeLine().getMonthValue();
								int date = IncomePanel.this.parent.getTimeLine().getDayOfMonth();
								int hour = IncomePanel.this.parent.getTimeLine().getHour();
								int minute = IncomePanel.this.parent.getTimeLine().getMinute();
								IncomePanel.this.rootPanel.getCommandStackPanel().appendCommandTime(year, month, date, hour, minute, IncomePanel.this.parent.getCmdType());
								IncomePanel.this.rootPanel.getTimePanel().setOutputTimeLabel("");
								IncomePanel.this.rootPanel.updateInterfacePanel();
								IncomePanel.this.parent.command();
							}
							break;
						}
						
					}
					
					// ���� ó�� ���� OutputInterface�� ��� : �������� �ʴ� ��¥�� ���� ����
					if(!IncomePanel.this.timeCheck) {
						parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("There is no income information for that date\n");
						IncomePanel.this.rootPanel.updateInterfacePanel();
					}
					
				}
				else {
					parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Please Input ��� �ð� first\n");
					IncomePanel.this.rootPanel.updateInterfacePanel();
				}
			}
		});
		datePanel.add(dateTextField);
		
		// InputButton
		inputButton = new JButton("�Է�");
		inputButton.addActionListener(event->{
			IncomePanel.this.year = Integer.parseInt(yearTextField.getText());
			IncomePanel.this.month = Integer.parseInt(monthTextField.getText());
			IncomePanel.this.date = Integer.parseInt(dateTextField.getText());
			if(IncomePanel.this.parent.getAccountingBook().size() == 0) {
				// ���� ó�� ���� OutputInterface�� ��� : ���� accountingBook�� �������� ����
				parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Income Data doesn't exist\n");
				IncomePanel.this.rootPanel.updateInterfacePanel();
			}
			else {
				if(IncomePanel.this.parent.getCmdTimeInput()) {
					for(int i = 0; i<IncomePanel.this.parent.getAccountingBook().size(); ++i) {
						// ��ġ�ϴ� ��¥�� ã�� ���
						if( IncomePanel.this.parent.getAccountingBook().get(i).getLocalDateTime().equals(LocalDateTime.of(year, month, date, 0, 0)) ) {
							IncomePanel.this.timeCheck = true;
							IncomePanel.this.parent.setIncomeYear(IncomePanel.this.year);
							IncomePanel.this.parent.setIncomeMonth(IncomePanel.this.month);
							IncomePanel.this.parent.setIncomeDate(IncomePanel.this.date);
							IncomePanel.this.parent.setCmdType("income");
							IncomePanel.this.parent.setCmdInput(true);
							// income ������ ���� ó��
							if(IncomePanel.this.parent.commandCheck()) {
								int year = IncomePanel.this.parent.getTimeLine().getYear();
								int month = IncomePanel.this.parent.getTimeLine().getMonthValue();
								int date = IncomePanel.this.parent.getTimeLine().getDayOfMonth();
								int hour = IncomePanel.this.parent.getTimeLine().getHour();
								int minute = IncomePanel.this.parent.getTimeLine().getMinute();
								IncomePanel.this.rootPanel.getCommandStackPanel().appendCommandTime(year, month, date, hour, minute, IncomePanel.this.parent.getCmdType());
								IncomePanel.this.rootPanel.getTimePanel().setOutputTimeLabel("");
								IncomePanel.this.rootPanel.updateInterfacePanel();
								IncomePanel.this.parent.command();
							}
							break;
						}
						
					}
					
					// ���� ó�� ���� OutputInterface�� ��� : �������� �ʴ� ��¥�� ���� ����
					if(!IncomePanel.this.timeCheck) {
						parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("There is no income information for that date\n");
						IncomePanel.this.rootPanel.updateInterfacePanel();
					}
					
				}
				else {
					parent.getRightPanel().getOutputInterfacePanel().appendNewCommand("Please Input ��� �ð� first\n");
					IncomePanel.this.rootPanel.updateInterfacePanel();
				}
			}
		});
		
		// Layout
		gbAdd(yearPanel, 0, 0, 1, 1, 0, 0);
		gbAdd(monthPanel, 0, 1, 1, 1, 0, 0);
		gbAdd(datePanel, 0, 2, 1, 1, 0, 0);
		gbAdd(inputButton, 0, 3, 1, 1, 0, 0);
		
	}
	
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
	
	public String toString() {return "income";}
}















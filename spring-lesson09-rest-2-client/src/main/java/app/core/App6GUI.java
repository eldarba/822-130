package app.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.core.models.Employee;

public class App6GUI {

	private RestTemplate restTemplate = new RestTemplate();
	private String url;

	public static void main(String[] args) {

		try {

			App6GUI app = new App6GUI();

			// ============================
			JFrame fr = new JFrame("My Application");
			fr.setBounds(100, 100, 500, 300);
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// create controls
			JButton btShow = new JButton("Show");
			JTextField tfShow = new JTextField("id");
			JLabel lbShow = new JLabel();

			// add listeners
			btShow.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						lbShow.setText("");
						int id = Integer.parseInt(tfShow.getText());
						Employee theEmp = app.doGetOne(id);
						System.out.println(theEmp);
						lbShow.setText(theEmp.toString());
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(fr, "error: " + e2.getMessage());
					}

				}
			});

			// set the layout
			btShow.setBounds(20, 20, 100, 25);
			tfShow.setBounds(200, 20, 100, 25);
			lbShow.setBounds(20, 50, 300, 25);
			// add controls to main window
			fr.add(tfShow);
			fr.add(btShow);
			fr.add(lbShow);
			// main window configuration
			fr.setLayout(null);
			fr.setVisible(true);
			// ============================

//			{// get one
//				Employee emp = app.doGetOne(3);
//				System.out.println(emp);
//			}

//			{ // get all
//				List<Employee> emps = app.doGetAll();
//				for (Employee employee : emps) {
//					System.out.println(employee);
//				}
//			}

//			{
//				Employee e = app.doDeleteOne(12);
//				System.out.println(e + " deleted");
//			}

		} catch (Exception e) {
			System.out.println("Error");
			System.out.println(e);
		}

	}

	public List<Employee> doGetAll() {
		url = "http://localhost:8080/api/employees/wrapped";
		EmployeeListWrapper wrapper = restTemplate.getForObject(url, EmployeeListWrapper.class);
		return wrapper.getEmps();
	}

	public Employee doGetOne(int id) {
		url = "http://localhost:8080/api/employees/one?id={id}";
		Employee e = restTemplate.getForObject(url, Employee.class, id);
		return e;
	}

	public Employee doDeleteOne(int id) {
		url = "http://localhost:8080/api/employees?id={id}";
		ResponseEntity<Employee> re = restTemplate.exchange(url, HttpMethod.DELETE, null, Employee.class, id);
		Employee e = re.getBody();
		return e;
	}

}

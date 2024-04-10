package BaiThucHanhSo2ver2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

public class Bai5 extends JFrame implements ActionListener {
	private JPanel pnNumber, pnDisplay, pnMain;
	private JButton[] numberButtons = new JButton[10];
	private JButton btPlus, btMinus, btMul, btDiv, btRes, btPoint, btDelete;
	private JTextField txtDisplay;
	private Stack<Double> numbers = new Stack<>();
	private Stack<Character> operators = new Stack<>();

	public Bai5() {
		this.setTitle("Calculator");
		this.setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		txtDisplay = new JTextField();
		txtDisplay.setPreferredSize(new Dimension(300, 50));
		txtDisplay.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtDisplay.setHorizontalAlignment(JTextField.RIGHT);

		pnNumber = new JPanel();
		pnNumber.setLayout(new GridLayout(4, 4, 5, 5));

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
		}

		btPlus = new JButton("+");
		btMinus = new JButton("-");
		btMul = new JButton("*");
		btDiv = new JButton("/");
		btRes = new JButton("=");
		btPoint = new JButton(".");
		btDelete = new JButton("C");

		btPlus.addActionListener(this);
		btMinus.addActionListener(this);
		btMul.addActionListener(this);
		btDiv.addActionListener(this);
		btRes.addActionListener(this);
		btPoint.addActionListener(this);
		btDelete.addActionListener(this);

		pnNumber.add(numberButtons[1]);
		pnNumber.add(numberButtons[2]);
		pnNumber.add(numberButtons[3]);
		pnNumber.add(btPlus);
		pnNumber.add(numberButtons[4]);
		pnNumber.add(numberButtons[5]);
		pnNumber.add(numberButtons[6]);
		pnNumber.add(btMinus);
		pnNumber.add(numberButtons[7]);
		pnNumber.add(numberButtons[8]);
		pnNumber.add(numberButtons[9]);
		pnNumber.add(btMul);
		pnNumber.add(btPoint);
		pnNumber.add(numberButtons[0]);
		pnNumber.add(btDelete);
		pnNumber.add(btDiv);

		pnDisplay = new JPanel(new BorderLayout());
		pnDisplay.add(txtDisplay, BorderLayout.NORTH);

		this.add(pnDisplay, BorderLayout.NORTH);
		this.add(pnNumber, BorderLayout.CENTER);
		this.add(btRes, BorderLayout.EAST);
	}


	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				txtDisplay.setText(txtDisplay.getText() + i);
				return;
			}
		}

		if (e.getSource() == btPoint) { 
			{
				txtDisplay.setText(txtDisplay.getText() + ".");
			}
		} else if (e.getSource() == btDelete) {
			txtDisplay.setText("");
		} else if (e.getSource() == btRes) {
			txtDisplay.setText(calculate(txtDisplay.getText()));
		} else { // cac nut + - * /
			JButton operator = (JButton) e.getSource();
			if (!txtDisplay.getText().isEmpty()) {
				txtDisplay.setText(txtDisplay.getText() + " " + operator.getText() + " ");
			}
		}
	}

	
      
    public static String calculate(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;
                numbers.push(Double.parseDouble(sb.toString()));
            }
            
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
                    double second = numbers.pop();
                    double first = numbers.pop();
                    char op = operations.pop();
                    numbers.push(applyOp(op, first, second));
                } 
                operations.push(c);
            }
        }

        
        while (!operations.isEmpty()) {
            double second = numbers.pop();
            double first = numbers.pop();
            char op = operations.pop();
            // thêm kết quả sau khi thực hiện phép tính vào stack sô
            numbers.push(applyOp(op, first, second));
        }

        return String.valueOf(numbers.pop());
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    private static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new IllegalArgumentException("Cannot divide by zero.");
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Bai5().setVisible(true);
            }
        });
    }
}
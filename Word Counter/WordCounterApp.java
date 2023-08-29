package FinalVersion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class WordCounterApp {
	public static int countWords(String text) {
	    Pattern pattern = Pattern.compile("\\b\\w+\\b");
	    Matcher matcher = pattern.matcher(text);
	    int count = 0;
	    while (matcher.find()) {
	        count++;
	    }
	    return count;
	}

	public static String readFile(String filePath) throws IOException {
	    StringBuilder fileContent = new StringBuilder();
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            fileContent.append(line).append("\n");
	        }
	    }
	    return fileContent.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Word Count");
		JLabel l1;
		JLabel l2, l3, l4;
		JTextArea text;
		JButton submit, clear, addfile;
		
		text = new JTextArea("");
		submit = new JButton("SUBMIT");
		clear = new JButton("CLEAR");
		addfile = new JButton("Add File");
		
		l1 = new JLabel("Enter Your string Here : ");
		l2 = new JLabel("Character with Spaces : ");
		l3 = new JLabel("Character Without Spaces : ");
		l4 = new JLabel("Words : ");
		
		Font txtFont = new Font(Font.SERIF, Font.PLAIN, 16);
		l1.setFont(txtFont);
		l2.setFont(txtFont);
		l3.setFont(txtFont);
		l4.setFont(txtFont);
		
		l1.setBounds(10, 25, 200, 30);
		text.setBounds(18, 60, 450, 300);
		l2.setBounds(10, 370, 400, 30);
		l3.setBounds(10, 400, 400, 30);
		l4.setBounds(10, 430, 400, 30);
		
		submit.setBounds(10, 470, 120, 50);
		clear.setBounds(180, 470, 120, 50);
		addfile.setBounds(350, 470, 120, 50);
		
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = text.getText().strip();
				int count = 0, i, word = 0;
				l2.setText("Character with Spaces : " + str.length());
				for (i = 0; i < str.length(); i++) {
					if (str.charAt(i) != ' ')
						count++;
					else
						System.out.println("Invalid word");
						word++;
				}
				l3.setText("Character Without Spaces : " + count);
				l4.setText("Words : " + (word +1));
			}
		});
		
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				l2.setText("Character with Spaces : ");
				l3.setText("Character Without Spaces : ");
				l4.setText("Words : ");
			}
		});
		
		addfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser fileChooser = new JFileChooser();
				    int returnVal = fileChooser.showOpenDialog(fileChooser);
				    if (returnVal == JFileChooser.APPROVE_OPTION) {
				        try {
				            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
				            String fileText = readFile(filePath);
				            text.setText(fileText);
				            int wordCount = countWords(fileText);
				            l4.setText("Total words: " + wordCount);
			         	} 
				        catch (IOException ex) {
				        JOptionPane.showMessageDialog(fileChooser, "Error reading file: " + ex.getMessage(),
				        "File Error", JOptionPane.ERROR_MESSAGE);
				    }
				}
				
			}
		});
		
		f.add(l1);
		f.add(text);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(submit);
		f.add(clear);
		f.add(addfile);
		f.setSize(500, 570);
		f.setResizable(false);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}

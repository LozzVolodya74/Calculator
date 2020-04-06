package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Service
public class Service {
	protected final Logger LOGGER = LoggerFactory.getLogger(Service.class);

	private List<String> allDataList = new ArrayList<>(); // put ALL data
	private String write = "";
	private int basePriority = 0;
	private String result = "";
	private String userInput = "";
	private Storage storage = new Storage();
	private ArrayList<Operand> list_operands = new ArrayList<>();
	Deque<String> uno = new LinkedList<>();

	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String data) {
		switch (data) {
		case "s":
			userInput = userInput + "/";
			break;
		case "p":
			userInput = userInput + ".";
			break;
		case "u":
			if(userInput.length()!=0) {
			uno.addLast(userInput.substring(userInput.length()-1));
			userInput = userInput.substring(0, userInput.length()-1);
			} else {
				userInput = "0";
			}
			break;
		case "r":
			if(uno.size()>0) {
				userInput = userInput + uno.pollLast();
			}
			break;
		case "=":
			userInput = userInput + "=";
			for (int i = 0; i < userInput.length(); i++) {
				String s = userInput.substring(i, i + 1);
				try{
					pars(s); 
				} catch (Exception e) {
					LOGGER.info("NOT CORRECT INPUT SIGN");
				}
			}
			break;
		default:
			userInput = userInput + data;
			break;
		}
	}
	
	public String getResult() {
		allDataList.clear();
		list_operands.clear();
		storage.clear();
		userInput = "";
		return result;
	}

	private void pars(String str) {
		if (str.equals("=")) {
			allDataList.add(write);
			write = "";
			basePriority = 0;
			result = calculate();
		}
		if (str.matches("[0-9]") || str.matches("p")) {
			if (str.equals("p")) {
				write = write + ".";
			} else {
				write = write + str;
			}
		} else {
			if (write != "") {
				allDataList.add(write);
				write = "";
			}
			if (str.equals("s")) {
				str = "/";
			}
			allDataList.add(str);
		}
	}

	private String calculate() {
		for (String s : allDataList) { // add priority operation and save in class Storage
			Node node = new Node();
			if (s.equals("+") || s.equals("-")) {
				node.setData(s);
				node.setPriority(basePriority + 1);
				storage.addNode(node);
			}
			if (s.equals("*") || s.equals("/")) {
				node.setData(s);
				node.setPriority(basePriority + 2);
				storage.addNode(node);
			}
			if (s.equals("(")) {
				basePriority += 2;
			}
			if (s.equals(")")) {
				basePriority -= 2;
			}
			if (isNumeric(s)) {
				node.setData(s);
				storage.addNode(node);
			}
		}

		if (basePriority != 0) {
			return "ERROR INPUT BRACKET !!!!";
		}

		for (int i = 0; i < storage.getSize(); i++) {
			Operand operand = new Operand();
			Node node = storage.getNode(i);
			if (node.getPriority() > 0) {
				operand.indexOperation = i;
				operand.priority = node.getPriority();
				list_operands.add(operand); // add ALL operands AND NOT DIGIT!!!
			}
		}

		Collections.sort(list_operands, new Comparator<Operand>() {
			@Override
			public int compare(Operand o1, Operand o2) {
				return o1.priority < o2.priority ? 1 : (o1.priority > o2.priority) ? -1 : 0;
			}
		});

		for (int i = 0; i < list_operands.size(); i++) {
			Operand operand = list_operands.get(i);
			int op = operand.indexOperation;
			storage.processOperation(op);
		}
		return storage.getNode(list_operands.get(list_operands.size() - 1).indexOperation).getData();
	}

	private boolean isNumeric(String strNum) {
		return strNum.matches("-?\\d+(\\.\\d+)?");
	}

	private class Operand {
		int indexOperation;
		int priority;
	}

}

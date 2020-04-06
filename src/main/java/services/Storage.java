package services;

import java.util.ArrayList;
import java.util.List;

public class Storage {

	private List<Node> nodeList = new ArrayList<>();

	public void addNode(Node node) {
		nodeList.add(node);
	}

	public Node getNode(int index) {
		return nodeList.get(index);
	}

	public int getSize() {
		return nodeList.size();
	}

	void processOperation(int i) throws NumberFormatException{ // i - index operation in allDataList 

		String operator = getNode(i).getData();
												
		String rez = "";
		int prev = getPrev(i);
		int next = getNext(i);
		// ERROR if not-correct data
		Float prevNum = Float.valueOf(nodeList.get(prev).getData());
		Float nextNum = Float.valueOf(nodeList.get(next).getData());
		
		Node prevNod = nodeList.get(prev);
		prevNod.setEnable(false);
		Node nextNod = nodeList.get(next);
		nextNod.setEnable(false);

		if (operator.equals("+")) {
			Float t = prevNum + nextNum;
			rez = t.toString();
		}
		if (operator.equals("-")) {
			Float t = prevNum - nextNum;
			rez = t.toString();
		}
		if (operator.equals("*")) {
			Float t = prevNum * nextNum;
			rez = t.toString();
		}
		if (operator.equals("/")) {
			Float t = prevNum / nextNum;
			rez = t.toString();
		}

		Node num = nodeList.get(i);    
		num.setData(rez); 
		num.setEnable(true);
		nodeList.set(i, num); // put intermediate result instead executed sign 
	}

	public int getPrev(int i) {
		for (int k = i - 1; k >= 0; --k) {
			if (nodeList.get(k).isEnable()) { 
				return k;
			}
		}
		return 0;
	}

	public int getNext(int i) {
		for (int k = i + 1; k < nodeList.size(); ++k) {
			if (nodeList.get(k).isEnable()) { 
				return k;
			}
		}
		return 0;
	}

	public void clear() {
		nodeList.clear();
	}

}

package electricPotAnimation;

import acquisitionOfAstahDiagram.DecisionController;

public class CheckMethodFinder {
	
	DecisionController dc = new DecisionController();
	
	/**
	 * もし、現在の状態名と前の状態名が一致したら、現在の状態名のラベルを設定する 合っていなかったら、空欄を設定する
	 * 
	 * @param current_vertex
	 *            現在の状態名
	 * @param pre_vertex
	 *            前の状態の名前
	 * 
	 * @return ラベル名
	 */
	public String setLabelChar(String current_vertex, String pre_vertex) {
		if (dc.checkPreVertex(current_vertex, pre_vertex)) {
			return current_vertex;
		}
		return "";
	}

	/**
	 * 開始疑似状態→off→onかつonトリガだったら
	 * 
	 * @return boolean
	 */
	public boolean checkOnFlow() {
		if (dc.checkPreVertex("off", "開始疑似状態0") && dc.checkPreVertex("on", "off") && dc.checkIncoming("on", "ON")) {
			return true;
		}
		return false;
	}

}

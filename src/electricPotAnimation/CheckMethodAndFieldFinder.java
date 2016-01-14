package electricPotAnimation;

import acquisitionOfAstahDiagram.DecisionController;

public class CheckMethodAndFieldFinder {

	// 状態フォルダー
	public static boolean is_on_clicked = false;// ONがクリックされたかどうか
	public static boolean is_boiling = false;// 加熱中かどうか
	public static boolean is_keep_warm = false;// 保温中かどうか

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
	public boolean checkStartToOff(){
		if(dc.checkPreVertex("off", "開始疑似状態0")){
			return true;
		}
		return false;
	}

	/**
	 * 開始疑似状態→off→onかつonトリガだったら
	 * 
	 * @return boolean
	 */
	public boolean checkOnFlow() {
		if (dc.checkPreVertex("off", "開始疑似状態0") && dc.checkPreVertex("on", "off")
				&& dc.checkVertexIncoming("on", "ON")) {
			return true;
		}
		return false;
	}

	/**
	 * on→off←開始疑似状態かつoffトリガーだったら
	 * 
	 * @return boolean
	 */
	public boolean checkOffFlow() {
		if (dc.checkPreVertex("off", "on") && dc.checkPreVertex("off", "開始疑似状態0")
				&& dc.checkVertexIncoming("off", "OFF")) {
			return true;
		}
		return false;
	}

	/**
	 * 開始疑似状態→off→onかつonトリガかつ, on入れ子開始疑似状態、かつon入れ子加熱中、かつ開始疑似状態→加熱中
	 */
	public boolean checkHeatingFlow() {
		if (checkOnFlow() && dc.checkPreSubVertex("on", "加熱中", "開始疑似状態1")) {
			return true;
		}
		return false;
	}

	/**
	 * 沸騰中かつ開始疑似状態→加熱中かつ加熱中→保温中かつ沸騰トリガがあったら(入れ子が前提条件となっている)
	 */
	public boolean checkBoilingToKeepWarmFlow() {
		if (is_boiling && dc.checkPreSubVertex("on", "加熱中", "開始疑似状態1") && dc.checkPreSubVertex("on", "保温中", "加熱中")
				&& dc.checkSubVertexIncoming("on", "保温中", "沸騰")) {
			return true;
		}
		return false;
	}

	/**
	 * 保温中 かつ 保温状態→加熱状態 かつ 沸騰ボタンを押すトリガ
	 */
	public boolean checkKeepWarmToBoilingFlow() {
		if (is_keep_warm && dc.checkPreSubVertex("on", "加熱中", "保温中")
				&& dc.checkSubVertexIncoming("on", "加熱中", "沸騰ボタンを押す")) {
			return true;
		}
		return false;
	}

}

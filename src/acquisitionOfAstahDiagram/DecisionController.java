package acquisitionOfAstahDiagram;

import com.change_vision.jude.api.inf.model.ITransition;
import com.change_vision.jude.api.inf.model.IVertex;

public class DecisionController {

	Vertex vertex = new Vertex();

	/**
	 * 指定した状態の前の状態を調べる。指定した状態の名前と一緒だったらtrue
	 * 
	 * @param current_vertex
	 *            指定した現在の状態
	 * @param check_vertex
	 *            前の状態の名前を指定
	 * @return boolean
	 */
	public boolean checkPreVertex(String current_vertex, String check_vertex) {
		IVertex[] ivx = new IVertex[4];
		ivx = vertex.getPreVertex(current_vertex);
		
		for (int i = 0; i < ivx.length; i++) {// 全ての状態でループを回す
			if (ivx[i].toString().equals(check_vertex)) {
				return true;
			}
		}
		return false;
	}
	//
	// /**
	// * 指定した状態の前の状態を調べる.これは、前の状態が２つあるとき
	// *
	// * @param current_vertex
	// * 指定した現在の状態
	// * @param check_vertex1
	// * 前の状態の名前を指定
	// * @return boolean
	// */
	// public boolean checkPreVertex(String current_vertex, String
	// check_vertex1, String check_vertex2) {
	// IVertex[] ivx = new IVertex[4];
	// ivx = vertex.getPreVertex(current_vertex);
	// for (int i = 0; i < ivx.length; i++) {// 全ての状態でループを回す
	// if (ivx[i].toString().equals(check_vertex1) ||
	// ivx[i].toString().equals(check_vertex2)) {
	// if (ivx[i + 1].toString().equals(check_vertex1) || ivx[i +
	// 1].toString().equals(check_vertex2)) {
	// return true;
	// }
	//
	// }
	// }
	// return false;
	// }
	//
	// /**
	// * 指定した状態の前の状態を調べる.これは、前の状態が3つあるとき
	// *
	// * @param current_vertex
	// * 指定した現在の状態
	// * @param check_vertex1
	// * 前の状態の名前を指定
	// * @return boolean
	// */
	// public boolean checkPreVertex(String current_vertex, String
	// check_vertex1, String check_vertex2,
	// String check_vertex3) {
	// IVertex[] ivx = new IVertex[4];
	// ivx = vertex.getPreVertex(current_vertex);
	// for (int i = 0; i < ivx.length; i++) {// 全ての状態でループを回す
	//
	// if (ivx[i].toString().equals(check_vertex1) ||
	// ivx[i].toString().equals(check_vertex2)
	// || ivx[i].toString().equals(check_vertex3)) {
	// if (ivx[i + 1].toString().equals(check_vertex1) || ivx[i +
	// 1].toString().equals(check_vertex2)
	// || ivx[i + 1].toString().equals(check_vertex3)) {
	// if (ivx[i + 2].toString().equals(check_vertex1) || ivx[i +
	// 2].toString().equals(check_vertex2)
	// || ivx[i + 2].toString().equals(check_vertex3)) {
	// return true;
	// }
	// }
	//
	// }
	// }
	// return false;
	// }

	/**
	 * 指定した状態に入ってくるトリガーを調べる。引数に指定したトリガーと同じなら,trueを返す。
	 * 
	 * @param state_name
	 *            任意の状態名
	 * @param check_tri
	 *            指定する、チェックしたいトリガー名
	 * @return boolean
	 */
	public boolean checkIncoming(String state_name, String check_tri) {
		ITransition[] it = new ITransition[4];
		it = vertex.getIncoming(state_name);
		for (int i = 0; i < it.length; i++) {
			if (it[i].toString().equals(check_tri)) {
				return true;
			}
		}
		return false;
	}

	// /**
	// * 指定した状態に入ってくるトリガーを調べる。引数に指定したトリガーと同じなら,trueを返す。
	// *
	// * @param state_name
	// * 任意の状態名
	// * @param check_tri
	// * 指定する、チェックしたいトリガー名
	// * @return boolean
	// */
	// public boolean checkIncoming(String state_name, String check_tri, String
	// check_tri1) {
	// ITransition[] it = new ITransition[4];
	// it = vertex.getIncoming(state_name);
	// for (int i = 0; i < it.length; i++) {
	// if (it[i].toString().equals(check_tri) &&
	// it[i].toString().equals(check_tri1)) {
	// return true;
	// }
	// }
	// return false;
	// }
}

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
	public boolean checkPreVertex(String current_vertex, String check_pre_vertex) {
		IVertex[] ivx = new IVertex[4];// 仮配列
		ivx = vertex.getPreVertex(current_vertex);

		for (int i = 0; i < ivx.length; i++) {// 全ての状態でループを回す
			if (ivx[i].toString().equals(check_pre_vertex)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 指定した状態に入ってくるトリガーを調べる。引数に指定したトリガーと同じなら,trueを返す。
	 * 
	 * @param state_name
	 *            任意の状態名
	 * @param check_tri
	 *            指定する、チェックしたいトリガー名
	 * @return boolean
	 */
	public boolean checkIncoming(String state_name, String checking_tri) {
		ITransition[] it = new ITransition[4];// 仮配列
		it = vertex.getIncoming(state_name);
		for (int i = 0; i < it.length; i++) {
			if (it[i].toString().equals(checking_tri)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 指定した状態に入っている、任意の入れ子があるか調べる。引数に指定した入れ子名があれば、trueを返す
	 */
	public boolean checkSubVertex(String state_name, String check_sub_vertex) {
		IVertex[] iv = new IVertex[4];// 仮配列
		iv = vertex.getSubVertexes(state_name);
		for (int i = 0; i < iv.length; i++) {
			if (iv[i].toString().equals(check_sub_vertex)) {
				return true;
			}
		}
		return false;
	}
}

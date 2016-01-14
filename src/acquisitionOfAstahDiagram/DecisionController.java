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
	public boolean checkVertexIncoming(String state_name, String checking_tri) {
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
	 * 指定した入れ子状態に入ってくるトリガーを調べる。引数に指定したトリガーと同じなら,trueを返す。
	 * 
	 * @param parent_v_name
	 *            指定した親状態名
	 * @param sub_v_name
	 *            指定した入れ子状態名
	 * @param checking_tri
	 *            指定したトリガー名
	 * @return 指定したトリガーだったら,true
	 */
	public boolean checkSubVertexIncoming(String parent_v_name, String sub_v_name, String checking_tri) {
		ITransition[] it = new ITransition[4];// 仮配列
		it = vertex.getSubIncoming(parent_v_name, sub_v_name);
		for (int i = 0; i < it.length; i++) {
			if (it[i].toString().equals(checking_tri)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 指定した入れ子状態の、前の状態を調べる。引数に指定したものと前の状態が一緒だったらtrue
	 * 
	 * @param parent_state_name
	 *            指定した親状態名
	 * @param sub_vertex
	 *            指定した入れ子状態名
	 * @param sub_pre_vertex
	 *            指定した,前の入れ子状態名
	 * @return boolean
	 */
	public boolean checkPreSubVertex(String parent_state_name, String sub_vertex, String sub_pre_vertex) {
		IVertex[] pre_subVertexes = new IVertex[4];// 仮配列
		pre_subVertexes = vertex.getSubVertexes(parent_state_name, sub_vertex);
		for (int i = 0; i < pre_subVertexes.length; i++) {
			if (pre_subVertexes[i].toString().equals(sub_pre_vertex)) {
				return true;
			}
		}
		return false;
	}
}

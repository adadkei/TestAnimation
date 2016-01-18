package acquisitionOfAstahDiagram;

import com.change_vision.jude.api.inf.model.ITransition;
import com.change_vision.jude.api.inf.model.IVertex;

import JP.co.esm.caddies.jomt.jview.in;

public class Vertex {

	IVertex[] iVertexes;
	IVertex[] subVertexes;
	// IVertex[] test;

	ITransition[] trasitions;
	ITransition[] incomings;
	StateDiagramFinder sdf = new StateDiagramFinder();

	public Vertex() {// コンストラクタ

		iVertexes = StateMachineDiagram.istate.getVertexes();// 全ての状態を取得。ただし、入れ子の状態は取得できていない
		for (int i = 0; i < iVertexes.length; i++) {
			System.out.println((i + 1) + "個目の状態は" + iVertexes[i]);
		}
		makeSubVertexes();
		makeTrasitions();
		makeIncomings(iVertexes[1]);
		// test = getPreVertex("off");
		// for (int i = 0; i < test.length; i++) {
		// System.out.println("offの前の状態は" + test[i]);
		// }

	}

	/**
	 * 入れ子の状態(vertex)を全て配列で取得し、subVertexes配列に入れる
	 */
	void makeSubVertexes() {
		for (int i = 0; i < iVertexes.length; i++)
			subVertexes = sdf.getSubVertexes(iVertexes[i]);

		for (int i = 0; i < subVertexes.length; i++) {
			System.out.println((i + 1) + "個目の入れ子の状態は" + subVertexes[i]);
		}
	}

	/**
	 * 全ての遷移、つまりトリガーを取得し、配列に入れる
	 */
	void makeTrasitions() {
		trasitions = StateMachineDiagram.istate.getTransitions();
		for (int i = 0; i < trasitions.length; i++) {
			System.out.println((i + 1) + "個目のトリガーは" + trasitions[i]);
		}
	}

	/**
	 * ivはIVertexの型で指定。ある状態に入ってくるトリガーをincomingに入れるメソッド。
	 */
	void makeIncomings(IVertex iv) {
		incomings = sdf.getIncomings(iv);
		for (int i = 0; i < incomings.length; i++) {
			System.out.println((i + 1) + "個目のincomingは" + incomings[i]);
		}
	}

	/**
	 * ある状態に入ってくるトリガーを、配列で返すメソッド
	 * 
	 * @param s
	 *            ある状態の名前
	 * @return ITransition[] ある状態に入ってくるトリガーの配列
	 */
	ITransition[] getIncoming(String s) {
		ITransition[] it = new ITransition[4];
		for (int i = 0; i < iVertexes.length; i++) {// 全ての状態でループを回す
			if (iVertexes[i].toString().equals(s)) {// ある状態名sの時
				it = iVertexes[i].getIncomings();
				break;
			}
		}
		for (int i = 0; i < it.length; i++) {// nullを消すために
			if (it[i] == null) {
				it[i] = it[0];
			}
		}
		return it;
	}

	/**
	 * ある入れ子状態に入ってくるトリガーを、配列で返すメソッド
	 * 
	 * @param parent_v_name
	 *            指定した親状態名
	 * @param sub_v_name
	 *            指定した入れ子状態名
	 * @return ある入れ子状態に入ってくるトリガーの配列
	 */
	ITransition[] getSubIncoming(String parent_v_name, String sub_v_name) {
		ITransition[] it = new ITransition[4];
		IVertex[] sub_vertexes = new IVertex[4];

		for (int i = 0; i < iVertexes.length; i++) {// 全ての状態でループを回す
			if (iVertexes[i].toString().equals(parent_v_name)) {// ある状態名
				sub_vertexes = sdf.getSubVertexes(iVertexes[i]);// その親状態の,入れ子状態達をゲット
				for (int j = 0; j < sub_vertexes.length; j++) {// 入れ子状態配列ループ
					if (sub_vertexes[j].toString().equals(sub_v_name)) {// 指定の入れ子状態と一致したら
						it = sub_vertexes[j].getIncomings();
						break;
					}
				}
			}
		}
		for (int i = 0; i < it.length; i++) {// nullを消すために
			if (it[i] == null) {
				it[i] = it[0];
			}
		}
		return it;
	}

	/**
	 * 任意のある状態の一個前の状態を取得し、それをIVertex配列に格納し、これを返す
	 * 
	 * @param s
	 *            指定したいある状態の名前
	 * @return IVertex配列
	 */
	IVertex[] getPreVertex(String s) {
		IVertex[] ivx = new IVertex[5];
		for (int i = 0; i < iVertexes.length; i++) {// 全ての状態でループを回す

			if (iVertexes[i].toString().equals(s)) {// ある状態名sの時
				ITransition[] it = iVertexes[i].getIncomings();
				for (int j = 0; j < it.length; j++) {
					ivx[j] = it[j].getSource();
				}
				break;
			}
		}
		for (int i = 0; i < ivx.length; i++) {// nullを消すために
			if (ivx[i] == null) {
				ivx[i] = ivx[0];
			}
		}

		return ivx;
	}

	/**
	 * 入れ子のある状態の、前の状態達を配列にして返す
	 * 
	 * @param parent_state_name
	 *            指定した親状態名
	 * @param sub_vertex_name
	 *            指定した入れ子状態名
	 * @return 指定した入れ子状態の、前の状態達の配列を返却
	 */
	IVertex[] getSubVertexes(String parent_state_name, String sub_vertex_name) {
		IVertex[] iv = new IVertex[5];
		IVertex[] pre_sub_v = new IVertex[4];

		for (int i = 0; i < iVertexes.length; i++) {
			if (iVertexes[i].toString().equals(parent_state_name)) {// 指定した親の状態名と同じだったら
				iv = sdf.getSubVertexes(iVertexes[i]);// その親状態の,入れ子状態達をゲット

				for (int j = 0; j < iv.length; j++) {// 入れ子状態配列でループ
					if (iv[j].toString().equals(sub_vertex_name)) {// 指定した入れ子の名前と同じだったら
						ITransition[] it = iv[j].getIncomings();
						for (int k = 0; k < it.length; k++) {
							pre_sub_v[k] = it[k].getSource();
						}
						break;
					}
				}
			}
		}
		for (int i = 0; i < pre_sub_v.length; i++) {// nullを消すために
			if (pre_sub_v[i] == null) {
				pre_sub_v[i] = iv[0];
			}
		}
		return pre_sub_v;
	}

	/**
	 * 全ての入れ子状態配列を返す
	 * 
	 * @return subVertexes[]
	 */
	public IVertex[] getSubVertex() {
		return subVertexes;
	}
}

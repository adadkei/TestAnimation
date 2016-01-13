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
	 * ある状態に入っている、入れ子の状態を配列で返すメソッド
	 * @param s 任意の状態名
	 */
	IVertex[] getSubVertexes(String s){
		IVertex[] iv = new IVertex[4];
		for(int i=0; i< iVertexes.length;i++){
			if(iVertexes[i].toString().equals(s)){//任意の状態名sだったら
				iv = sdf.getSubVertexes(iVertexes[i]);
				break;
			}
		}
		for (int i = 0; i < iv.length; i++) {// nullを消すために
			if (iv[i] == null) {
				iv[i] = iv[0];
			}
		}
		return iv;
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

}

package acquisitionOfAstahDiagram;

import com.change_vision.jude.api.inf.model.ITransition;
import com.change_vision.jude.api.inf.model.IVertex;

import JP.co.esm.caddies.jomt.jview.in;

public class Vertex {

	IVertex[] iVertexes;
	IVertex[] subVertexes;
	IVertex[] test;

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
		test = getPreVertex("off");
		for (int i = 0; i < test.length; i++) {
			System.out.println("offの前の状態は" + test[i]);
		}

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
	 * ivはIVertexの型で指定。ある状態に入ってくるトリガーを取得。
	 */
	void makeIncomings(IVertex iv) {
		incomings = sdf.getIncomings(iv);
		for (int i = 0; i < incomings.length; i++) {
			System.out.println((i + 1) + "個目のincomingは" + incomings[i]);
		}
	}

	/**
	 * 任意のある状態の一個前の状態を取得し、それをIVertex配列に格納し、返す
	 * 
	 * @param s
	 *            指定したいある状態の名前
	 * @return IVertex配列
	 */
	IVertex[] getPreVertex(String s) {
		IVertex[] ivx= new IVertex[5];
		for (int i = 0; i < iVertexes.length; i++) {// 全ての状態でループを回す
			if (iVertexes[i].toString().equals(s)) {// ある状態名sの時
				ITransition[] it = iVertexes[i].getIncomings();
				for (int j = 0; j < it.length; j++) {
					ivx[j] = it[j].getSource();
				}
				break;
			}
		}
		for(int i = 0; i < ivx.length; i++){
			if (ivx[i]==null){
				ivx[i]=ivx[0];
			}
		}
		return ivx;
	}

}

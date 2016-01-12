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

	public Vertex() {// �R���X�g���N�^

		iVertexes = StateMachineDiagram.istate.getVertexes();// �S�Ă̏�Ԃ��擾�B�������A����q�̏�Ԃ͎擾�ł��Ă��Ȃ�
		for (int i = 0; i < iVertexes.length; i++) {
			System.out.println((i + 1) + "�ڂ̏�Ԃ�" + iVertexes[i]);
		}
		makeSubVertexes();
		makeTrasitions();
		makeIncomings(iVertexes[1]);
		test = getPreVertex("off");
		for (int i = 0; i < test.length; i++) {
			System.out.println("off�̑O�̏�Ԃ�" + test[i]);
		}

	}

	/**
	 * ����q�̏��(vertex)��S�Ĕz��Ŏ擾���AsubVertexes�z��ɓ����
	 */
	void makeSubVertexes() {
		for (int i = 0; i < iVertexes.length; i++)
			subVertexes = sdf.getSubVertexes(iVertexes[i]);

		for (int i = 0; i < subVertexes.length; i++) {
			System.out.println((i + 1) + "�ڂ̓���q�̏�Ԃ�" + subVertexes[i]);
		}
	}

	/**
	 * �S�Ă̑J�ځA�܂�g���K�[���擾���A�z��ɓ����
	 */
	void makeTrasitions() {
		trasitions = StateMachineDiagram.istate.getTransitions();
		for (int i = 0; i < trasitions.length; i++) {
			System.out.println((i + 1) + "�ڂ̃g���K�[��" + trasitions[i]);
		}
	}

	/**
	 * iv��IVertex�̌^�Ŏw��B�����Ԃɓ����Ă���g���K�[���擾�B
	 */
	void makeIncomings(IVertex iv) {
		incomings = sdf.getIncomings(iv);
		for (int i = 0; i < incomings.length; i++) {
			System.out.println((i + 1) + "�ڂ�incoming��" + incomings[i]);
		}
	}

	/**
	 * �C�ӂ̂����Ԃ̈�O�̏�Ԃ��擾���A�����IVertex�z��Ɋi�[���A�Ԃ�
	 * 
	 * @param s
	 *            �w�肵���������Ԃ̖��O
	 * @return IVertex�z��
	 */
	IVertex[] getPreVertex(String s) {
		IVertex[] ivx= new IVertex[5];
		for (int i = 0; i < iVertexes.length; i++) {// �S�Ă̏�ԂŃ��[�v����
			if (iVertexes[i].toString().equals(s)) {// �����Ԗ�s�̎�
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

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

	public Vertex() {// �R���X�g���N�^

		iVertexes = StateMachineDiagram.istate.getVertexes();// �S�Ă̏�Ԃ��擾�B�������A����q�̏�Ԃ͎擾�ł��Ă��Ȃ�
		for (int i = 0; i < iVertexes.length; i++) {
			System.out.println((i + 1) + "�ڂ̏�Ԃ�" + iVertexes[i]);
		}
		makeSubVertexes();
		makeTrasitions();
		makeIncomings(iVertexes[1]);
		// test = getPreVertex("off");
		// for (int i = 0; i < test.length; i++) {
		// System.out.println("off�̑O�̏�Ԃ�" + test[i]);
		// }

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
	 * iv��IVertex�̌^�Ŏw��B�����Ԃɓ����Ă���g���K�[��incoming�ɓ���郁�\�b�h�B
	 */
	void makeIncomings(IVertex iv) {
		incomings = sdf.getIncomings(iv);
		for (int i = 0; i < incomings.length; i++) {
			System.out.println((i + 1) + "�ڂ�incoming��" + incomings[i]);
		}
	}

	/**
	 * �����Ԃɓ����Ă���g���K�[���A�z��ŕԂ����\�b�h
	 * 
	 * @param s
	 *            �����Ԃ̖��O
	 * @return ITransition[] �����Ԃɓ����Ă���g���K�[�̔z��
	 */
	ITransition[] getIncoming(String s) {
		ITransition[] it = new ITransition[4];
		for (int i = 0; i < iVertexes.length; i++) {// �S�Ă̏�ԂŃ��[�v����
			if (iVertexes[i].toString().equals(s)) {// �����Ԗ�s�̎�
				it = iVertexes[i].getIncomings();
				break;
			}
		}
		for (int i = 0; i < it.length; i++) {// null���������߂�
			if (it[i] == null) {
				it[i] = it[0];
			}
		}
		return it;
	}

	/**
	 * �������q��Ԃɓ����Ă���g���K�[���A�z��ŕԂ����\�b�h
	 * 
	 * @param parent_v_name
	 *            �w�肵���e��Ԗ�
	 * @param sub_v_name
	 *            �w�肵������q��Ԗ�
	 * @return �������q��Ԃɓ����Ă���g���K�[�̔z��
	 */
	ITransition[] getSubIncoming(String parent_v_name, String sub_v_name) {
		ITransition[] it = new ITransition[4];
		IVertex[] sub_vertexes = new IVertex[4];

		for (int i = 0; i < iVertexes.length; i++) {// �S�Ă̏�ԂŃ��[�v����
			if (iVertexes[i].toString().equals(parent_v_name)) {// �����Ԗ�
				sub_vertexes = sdf.getSubVertexes(iVertexes[i]);// ���̐e��Ԃ�,����q��ԒB���Q�b�g
				for (int j = 0; j < sub_vertexes.length; j++) {// ����q��Ԕz�񃋁[�v
					if (sub_vertexes[j].toString().equals(sub_v_name)) {// �w��̓���q��Ԃƈ�v������
						it = sub_vertexes[j].getIncomings();
						break;
					}
				}
			}
		}
		for (int i = 0; i < it.length; i++) {// null���������߂�
			if (it[i] == null) {
				it[i] = it[0];
			}
		}
		return it;
	}

	/**
	 * �C�ӂ̂����Ԃ̈�O�̏�Ԃ��擾���A�����IVertex�z��Ɋi�[���A�����Ԃ�
	 * 
	 * @param s
	 *            �w�肵���������Ԃ̖��O
	 * @return IVertex�z��
	 */
	IVertex[] getPreVertex(String s) {
		IVertex[] ivx = new IVertex[5];
		for (int i = 0; i < iVertexes.length; i++) {// �S�Ă̏�ԂŃ��[�v����

			if (iVertexes[i].toString().equals(s)) {// �����Ԗ�s�̎�
				ITransition[] it = iVertexes[i].getIncomings();
				for (int j = 0; j < it.length; j++) {
					ivx[j] = it[j].getSource();
				}
				break;
			}
		}
		for (int i = 0; i < ivx.length; i++) {// null���������߂�
			if (ivx[i] == null) {
				ivx[i] = ivx[0];
			}
		}

		return ivx;
	}

	/**
	 * ����q�̂����Ԃ́A�O�̏�ԒB��z��ɂ��ĕԂ�
	 * 
	 * @param parent_state_name
	 *            �w�肵���e��Ԗ�
	 * @param sub_vertex_name
	 *            �w�肵������q��Ԗ�
	 * @return �w�肵������q��Ԃ́A�O�̏�ԒB�̔z���ԋp
	 */
	IVertex[] getSubVertexes(String parent_state_name, String sub_vertex_name) {
		IVertex[] iv = new IVertex[5];
		IVertex[] pre_sub_v = new IVertex[4];

		for (int i = 0; i < iVertexes.length; i++) {
			if (iVertexes[i].toString().equals(parent_state_name)) {// �w�肵���e�̏�Ԗ��Ɠ�����������
				iv = sdf.getSubVertexes(iVertexes[i]);// ���̐e��Ԃ�,����q��ԒB���Q�b�g

				for (int j = 0; j < iv.length; j++) {// ����q��Ԕz��Ń��[�v
					if (iv[j].toString().equals(sub_vertex_name)) {// �w�肵������q�̖��O�Ɠ�����������
						ITransition[] it = iv[j].getIncomings();
						for (int k = 0; k < it.length; k++) {
							pre_sub_v[k] = it[k].getSource();
						}
						break;
					}
				}
			}
		}
		for (int i = 0; i < pre_sub_v.length; i++) {// null���������߂�
			if (pre_sub_v[i] == null) {
				pre_sub_v[i] = iv[0];
			}
		}
		return pre_sub_v;
	}

	/**
	 * �S�Ă̓���q��Ԕz���Ԃ�
	 * 
	 * @return subVertexes[]
	 */
	public IVertex[] getSubVertex() {
		return subVertexes;
	}
}

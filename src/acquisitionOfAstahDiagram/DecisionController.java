package acquisitionOfAstahDiagram;

import com.change_vision.jude.api.inf.model.ITransition;
import com.change_vision.jude.api.inf.model.IVertex;

public class DecisionController {

	Vertex vertex = new Vertex();

	/**
	 * �w�肵����Ԃ̑O�̏�Ԃ𒲂ׂ�B�w�肵����Ԃ̖��O�ƈꏏ��������true
	 * 
	 * @param current_vertex
	 *            �w�肵�����݂̏��
	 * @param check_vertex
	 *            �O�̏�Ԃ̖��O���w��
	 * @return boolean
	 */
	public boolean checkPreVertex(String current_vertex, String check_pre_vertex) {
		IVertex[] ivx = new IVertex[4];// ���z��
		ivx = vertex.getPreVertex(current_vertex);

		for (int i = 0; i < ivx.length; i++) {// �S�Ă̏�ԂŃ��[�v����
			if (ivx[i].toString().equals(check_pre_vertex)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �w�肵����Ԃɓ����Ă���g���K�[�𒲂ׂ�B�����Ɏw�肵���g���K�[�Ɠ����Ȃ�,true��Ԃ��B
	 * 
	 * @param state_name
	 *            �C�ӂ̏�Ԗ�
	 * @param check_tri
	 *            �w�肷��A�`�F�b�N�������g���K�[��
	 * @return boolean
	 */
	public boolean checkIncoming(String state_name, String checking_tri) {
		ITransition[] it = new ITransition[4];// ���z��
		it = vertex.getIncoming(state_name);
		for (int i = 0; i < it.length; i++) {
			if (it[i].toString().equals(checking_tri)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �w�肵����Ԃɓ����Ă���A�C�ӂ̓���q�����邩���ׂ�B�����Ɏw�肵������q��������΁Atrue��Ԃ�
	 */
	public boolean checkSubVertex(String state_name, String check_sub_vertex) {
		IVertex[] iv = new IVertex[4];// ���z��
		iv = vertex.getSubVertexes(state_name);
		for (int i = 0; i < iv.length; i++) {
			if (iv[i].toString().equals(check_sub_vertex)) {
				return true;
			}
		}
		return false;
	}
}

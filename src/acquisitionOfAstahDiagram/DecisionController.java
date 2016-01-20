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
	 * @param check_pre_vertex
	 *            �O�̏�Ԃ̖��O���w��
	 * @return boolean
	 */
	public boolean checkPreVertex(String current_vertex, String check_pre_vertex) {
		IVertex[] ivx = new IVertex[4];// ���z��
		ivx = vertex.getPreVertex(current_vertex);
		if (ivx[0] == null) {// null������Ə�肭����Ȃ�
			return false;
		}

		for (int i = 0; i < ivx.length; i++) {// �S�Ă̏�ԂŃ��[�v����
			
			if (ivx[i].toString().equals(check_pre_vertex)) {
				return true;
			}
			// �J�n��Ԕ��ʗp�B"�J�n"�Ŏn�߂��OK�ɂ��邽�߁B
			if (check_pre_vertex.startsWith("�J�n") && ivx[i].toString().startsWith("�J�n")) {
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
	public boolean checkVertexIncoming(String state_name, String checking_tri) {
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
	 * �w�肵������q��Ԃɓ����Ă���g���K�[�𒲂ׂ�B�����Ɏw�肵���g���K�[�Ɠ����Ȃ�,true��Ԃ��B
	 * 
	 * @param parent_v_name
	 *            �w�肵���e��Ԗ�
	 * @param sub_v_name
	 *            �w�肵������q��Ԗ�
	 * @param checking_tri
	 *            �w�肵���g���K�[��
	 * @return �w�肵���g���K�[��������,true
	 */
	public boolean checkSubVertexIncoming(String parent_v_name, String sub_v_name, String checking_tri) {
		ITransition[] it = new ITransition[4];// ���z��
		it = vertex.getSubIncoming(parent_v_name, sub_v_name);
		if (it[0] == null) {
			return false;
		}
		for (int i = 0; i < it.length; i++) {
			if (it[i].toString().equals(checking_tri)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �w�肵������q��Ԃ́A�O�̏�Ԃ𒲂ׂ�B�����Ɏw�肵�����̂ƑO�̏�Ԃ��ꏏ��������true
	 * 
	 * @param parent_state_name
	 *            �w�肵���e��Ԗ�
	 * @param sub_vertex
	 *            �w�肵������q��Ԗ�
	 * @param sub_pre_vertex
	 *            �w�肵��,�O�̓���q��Ԗ�
	 * @return boolean
	 */
	public boolean checkPreSubVertex(String parent_state_name, String sub_vertex, String sub_pre_vertex) {
		IVertex[] pre_subVertexes = new IVertex[4];// ���z��
		pre_subVertexes = vertex.getSubVertexes(parent_state_name, sub_vertex);

		if (pre_subVertexes[0] == null) {// �v���O��������肭���邽��
			return false;
		}
		for (int i = 0; i < pre_subVertexes.length; i++) {
			if (pre_subVertexes[i].toString().equals(sub_pre_vertex)) {
				return true;
			}
			// �J�n��Ԕ��ʗp�B"�J�n"�Ŏn�߂��OK�ɂ��邽�߁B
			if (sub_pre_vertex.startsWith("�J�n") && pre_subVertexes[i].toString().startsWith("�J�n")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ��ԑJ�ڐ}�̒��ɁA����q�����邩�Ȃ������ׂ�. �����Ă�����ture��Ԃ�
	 */
	public boolean OrNotSubPreVertex() {
		IVertex[] pre_subVertexes = vertex.getSubVertex();
		if (!(pre_subVertexes.length == 0)) {// �z��ɉ��������Ă�����
			return true;
		}
		return false;
	}
}

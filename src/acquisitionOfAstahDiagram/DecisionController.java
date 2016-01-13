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
	public boolean checkPreVertex(String current_vertex, String check_vertex) {
		IVertex[] ivx = new IVertex[4];
		ivx = vertex.getPreVertex(current_vertex);
		
		for (int i = 0; i < ivx.length; i++) {// �S�Ă̏�ԂŃ��[�v����
			if (ivx[i].toString().equals(check_vertex)) {
				return true;
			}
		}
		return false;
	}
	//
	// /**
	// * �w�肵����Ԃ̑O�̏�Ԃ𒲂ׂ�.����́A�O�̏�Ԃ��Q����Ƃ�
	// *
	// * @param current_vertex
	// * �w�肵�����݂̏��
	// * @param check_vertex1
	// * �O�̏�Ԃ̖��O���w��
	// * @return boolean
	// */
	// public boolean checkPreVertex(String current_vertex, String
	// check_vertex1, String check_vertex2) {
	// IVertex[] ivx = new IVertex[4];
	// ivx = vertex.getPreVertex(current_vertex);
	// for (int i = 0; i < ivx.length; i++) {// �S�Ă̏�ԂŃ��[�v����
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
	// * �w�肵����Ԃ̑O�̏�Ԃ𒲂ׂ�.����́A�O�̏�Ԃ�3����Ƃ�
	// *
	// * @param current_vertex
	// * �w�肵�����݂̏��
	// * @param check_vertex1
	// * �O�̏�Ԃ̖��O���w��
	// * @return boolean
	// */
	// public boolean checkPreVertex(String current_vertex, String
	// check_vertex1, String check_vertex2,
	// String check_vertex3) {
	// IVertex[] ivx = new IVertex[4];
	// ivx = vertex.getPreVertex(current_vertex);
	// for (int i = 0; i < ivx.length; i++) {// �S�Ă̏�ԂŃ��[�v����
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
	 * �w�肵����Ԃɓ����Ă���g���K�[�𒲂ׂ�B�����Ɏw�肵���g���K�[�Ɠ����Ȃ�,true��Ԃ��B
	 * 
	 * @param state_name
	 *            �C�ӂ̏�Ԗ�
	 * @param check_tri
	 *            �w�肷��A�`�F�b�N�������g���K�[��
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
	// * �w�肵����Ԃɓ����Ă���g���K�[�𒲂ׂ�B�����Ɏw�肵���g���K�[�Ɠ����Ȃ�,true��Ԃ��B
	// *
	// * @param state_name
	// * �C�ӂ̏�Ԗ�
	// * @param check_tri
	// * �w�肷��A�`�F�b�N�������g���K�[��
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

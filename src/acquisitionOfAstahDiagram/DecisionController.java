package acquisitionOfAstahDiagram;

import com.change_vision.jude.api.inf.model.IVertex;

public class DecisionController {
	Vertex vertex = new Vertex();

	public boolean checkOff() {
		IVertex[] ivx = new IVertex[4];
		ivx = vertex.getPreVertex("off");
		for (int i = 0; i < ivx.length; i++) {// �S�Ă̏�ԂŃ��[�v����
			if (ivx[i].toString().equals("�J�n�^�����0")) {
				return true;
			}
		}
		return false;
	}
}

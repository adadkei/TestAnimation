package acquisitionOfAstahDiagram;

import java.io.IOException;
import java.util.List;

import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.model.IState;
import com.change_vision.jude.api.inf.model.IStateMachine;
import com.change_vision.jude.api.inf.model.IStateMachineDiagram;
import com.change_vision.jude.api.inf.model.ITransition;
import com.change_vision.jude.api.inf.model.IVertex;

public class StateMachineDiagram {

	static public List stateContents;
	static public IStateMachine istate;
	
	public StateMachineDiagram() throws ClassNotFoundException, LicenseNotFoundException, ProjectNotFoundException,
			NonCompatibleException, IOException, ProjectLockedException, Throwable {
		

		StateDiagramFinder sdf = new StateDiagramFinder("electric_pot.asta");
		System.out.println("�v���W�F�N�g�擾����\r\n");

		/*
		 * �X�e�[�g�}�V���}���擾
		 */
		stateContents = sdf.getIStateMachines(sdf.getiModel());
		
		System.out.println("��ԑJ�ڐ}�v�f����" + stateContents.size() + "�ł�");
		for (int i = 0; i < stateContents.size(); i++) {
			System.out.println((i + 1) + "�ڂ̏�ԑJ�ڐ}�̗v�f��" + stateContents.get(i));
		}
		System.out.println("project����" + sdf.iModel + "�ł�\r\n");

		/*
		 * �}����A�X�e�[�g�}�V�����擾
		 */
		istate = sdf.get((IStateMachineDiagram) stateContents.get(0));
		System.out.println("is��" + istate + "�ł�\r\n");
		
		//new Vertex();
		
	}
	

}

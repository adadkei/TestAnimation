package acquisitionOfAstahDiagram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IModel;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.model.IPackage;
import com.change_vision.jude.api.inf.model.IState;
import com.change_vision.jude.api.inf.model.IStateMachine;
import com.change_vision.jude.api.inf.model.IStateMachineDiagram;
import com.change_vision.jude.api.inf.model.ITransition;
import com.change_vision.jude.api.inf.model.IVertex;
import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class StateDiagramFinder {
	private static final String EMPTY_COLUMN = "";
	ProjectAccessor prjAccessor;
	String inputFile;
	IModel iModel;
	INamedElement[] iNamedElements;

	public StateDiagramFinder() {
	};

	/**
	 * @param inputFile
	 *            File to input
	 */
	public StateDiagramFinder(String inputFile) throws LicenseNotFoundException, ProjectNotFoundException,
			NonCompatibleException, IOException, ClassNotFoundException, ProjectLockedException, Throwable {
		this.inputFile = inputFile;
		// Open a project. And get the model.
		ProjectAccessor prjAccessor = AstahAPI.getAstahAPI().getProjectAccessor();
		prjAccessor.open(inputFile);
		iModel = prjAccessor.getProject();
		prjAccessor.close();
	}

	/**
	 * Get states in selected package.
	 * 
	 * @param iPackage
	 *            Selected package
	 * @return List of all stored classes
	 */
	public List getIStateMachines(INamedElement in) {
		List iStateMachines = new ArrayList();
		iNamedElements = ((IPackage) in).getDiagrams();
		for (int i = 0; i < iNamedElements.length; i++) {
			INamedElement iNamedElement = iNamedElements[i];
			if (iNamedElement instanceof IStateMachineDiagram) {
				iStateMachines.add(iNamedElement);
			}
		}
		return iStateMachines;
	}

	/**
	 * 状態を取得、それをリストで返却
	 */
	public List getVertexes(INamedElement in) {
		List vertexes = new ArrayList();

		if (in instanceof IPackage) {
			IVertex[] iv = ((IStateMachine) in).getVertexes();
			for (int i = 0; i < iv.length; i++) {
				vertexes.add(iv[i]);
			}
		}

		return vertexes;
	}

	/**
	 * ステートマシン図取得
	 */
	public IStateMachine get(IStateMachineDiagram is) {
		IStateMachine iStates;
		iStates = is.getStateMachine();
		return iStates;
	}

	/**
	 * get 内部遷移配列
	 * 
	 * @return List 内部遷移
	 */
	public List getIternalTrasitions(IVertex iv) {
		List lists = new ArrayList();
		ITransition[] ivs;
		ivs = ((IState) iv).getInternalTransitions();
		for (int i = 0; i < ivs.length; i++) {
			lists.add(ivs[i]);
		}
		return lists;
	}

	/**
	 * get 子のvertex配列
	 * 
	 * @return IVertex[]
	 */
	public IVertex[] getSubVertexes(IVertex iv) {
		IVertex[] ivs = null;
		if (iv instanceof IState)
			ivs = ((IState) iv).getSubvertexes();
		return ivs;
	}

	/**
	 * get 入ってくる遷移配列
	 * 
	 * @return ある状態に入ってくるトリガー配列
	 */
	ITransition[] getIncomings(IVertex iv) {
		ITransition[] ivs;
		ivs = iv.getIncomings();
		return ivs;
	}

	public IModel getiModel() {
		return iModel;
	}
}

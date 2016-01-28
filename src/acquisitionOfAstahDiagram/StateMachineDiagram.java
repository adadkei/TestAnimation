package acquisitionOfAstahDiagram;

import java.io.IOException;
import java.util.List;

import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IStateMachine;
import com.change_vision.jude.api.inf.model.IStateMachineDiagram;

public class StateMachineDiagram {

    static public List stateContents;
    static public IStateMachine istate;

    public StateMachineDiagram() throws ClassNotFoundException, LicenseNotFoundException,
            ProjectNotFoundException, NonCompatibleException, IOException, ProjectLockedException,
            Throwable {

        StateDiagramFinder sdf = new StateDiagramFinder("game2.asta");
        System.out.println("プロジェクト取得完了\r\n");

        /*
         * ステートマシン図を取得
         */
        stateContents = sdf.getIStateMachines(sdf.getiModel());

        System.out.println("状態遷移図要素数は" + stateContents.size() + "個です");
        for (int i = 0; i < stateContents.size(); i++) {
            System.out.println((i + 1) + "個目の状態遷移図の要素は" + stateContents.get(i));
        }
        System.out.println("project名は" + sdf.iModel + "です\r\n");

        /*
         * 図から、ステートマシンを取得
         */
        istate = sdf.get((IStateMachineDiagram) stateContents.get(0));
        System.out.println("isは" + istate + "です\r\n");

        new Vertex();// コンソールに表示させるためのお試し用

    }

}

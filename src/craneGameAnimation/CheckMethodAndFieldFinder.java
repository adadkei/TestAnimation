package craneGameAnimation;

import acquisitionOfAstahDiagram.DecisionController;

public class CheckMethodAndFieldFinder {

    DecisionController dc = new DecisionController();

    // 文字
    String kara = "";
    String c_state = "状態";
    String c_trigger = "トリガー";

    String idle = "アイドリング中";
    String wait_right = "右移動指示待ち";
    String wait_back = "奥移動指示待ち";
    String move_right = "右移動中";
    String move_back = "奥移動中";
    String crane_action = "クレーン動作中";
    String move_return = "復帰移動中";
    String move_left = "左移動中";
    String move_this_side = "手前移動中";
    String prize_action = "景品投下動作中";

    String tri_coin = "コイン投入";
    String tri_right_button = "右ボタン押し";
    String tri_right_switch = "右端スイッチON";
    String tri_right_release = "右ボタン放し";
    String tri_back_button = "奥ボタン押し";
    String tri_back_switch = "奥スイッチON";
    String tri_back_release = "奥ボタン放し";
    String tri_thirty = "30秒経過";
    String tri_left_switch = "左端スイッチON";
    String tri_this_side_switch = "手前端スイッチON";
    String tri_crane_up = "クレーン上昇";
    String tri_this_and_left_switch = "手前端・左端スイッチON";

    // 状態フォルダー
    public static boolean is_idle = false;
    public static boolean is_wait_right = false;
    public static boolean is_wait_back = false;
    public static boolean is_move_right = false;
    public static boolean is_move_back = false;
    public static boolean is_crane_action = false;
    public static boolean is_move_return = false;
    public static boolean is_move_left = false;
    public static boolean is_move_this_side = false;
    public static boolean is_prize_action = false;

    /************************************************************************
     * 
     * ここからは、それぞれの状態,トリガーの判別メソッド
     * 
     *************************************************************************/

    // ////////////////////////////////////////////////////////
    // 状態
    // ///////////////////////////////////////////////////////

    /**
     * 開始状態→アイドリング中
     * 
     * @return
     */
    public boolean startToidle() {
        if (dc.checkPreVertex(idle, "開始")) {
            return true;
        }
        return false;
    }

    /**
     * アイドリング中→右移動指示待ち
     * 
     * @return
     */
    public boolean idleToRightWait() {
        if (dc.checkPreVertex(wait_right, idle)) {
            return true;
        }
        return false;
    }

    /**
     * 右移動指示待ち→右移動中
     * 
     * @return
     */
    public boolean waitRightToMoveRight() {
        if (dc.checkPreVertex(move_right, wait_right)) {
            return true;
        }
        return false;
    }

    /**
     * 右移動中→奥移動指示待ち
     * 
     * @return
     */
    public boolean moveRightToWaitBack() {
        if (dc.checkPreVertex(wait_back, move_right)) {
            return true;
        }
        return false;
    }

    /**
     * 右移動指示待ち→奥移動指示待ち
     * 
     * @return
     */
    public boolean waitRightToWaitBack() {
        if (dc.checkPreVertex(wait_back, wait_right)) {
            return true;
        }
        return false;
    }

    /**
     * 奥移動指示待ち→奥移動中
     * 
     * @return
     */
    public boolean waitBackToMoveBack() {
        if (dc.checkPreVertex(move_back, wait_back)) {
            return true;
        }
        return false;
    }

    /**
     * 奥移動中→クレーン動作中
     * 
     * @return
     */
    public boolean moveBackToMoveCrane() {
        if (dc.checkPreVertex(crane_action, move_back)) {
            return true;
        }
        return false;
    }

    /**
     * 奥移動指示待ち→クレーン動作中
     * 
     * @return
     */
    public boolean waitBackToCraneAction() {
        if (dc.checkPreVertex(crane_action, wait_back)) {
            return true;
        }
        return false;
    }

    /**
     * クレーン動作中→復帰移動中
     * 
     * @return
     */
    public boolean craneActionToMoveReturn() {
        if (dc.checkPreVertex(move_return, crane_action)) {
            return true;
        }
        return false;
    }

    /**
     * 復帰移動中→景品投下動作中
     * 
     * @return
     */
    public boolean moveReturnToPrizeAction() {
        if (dc.checkPreVertex(prize_action, move_return)) {
            return true;
        }
        return false;
    }

    /**
     * 景品投下動作中→アイドリング中
     * 
     * @return
     */
    public boolean prizeActionToIdle() {
        if (dc.checkPreVertex(idle, prize_action)) {
            return true;
        }
        return false;
    }

    // ////////////////////////////////////////
    // 入れ子状態
    // ///////////////////////////////////////
    /**
     * 入れ子<br>
     * 開始→左移動中
     * 
     * @return
     */
    public boolean startToMoveLeft() {
        if (dc.checkPreSubVertex(move_return, move_left, "開始")) {
            return true;
        }
        return false;
    }

    /**
     * 入れ子<br>
     * 左移動中→終了
     * 
     * @return
     */
    public boolean moveLeftToFinish() {
        if (dc.checkPreSubVertex(move_return, "終了", move_left)) {
            return true;
        }
        return false;
    }

    /**
     * 入れ子<br>
     * 開始→手前移動中
     * 
     * @return
     */
    public boolean startToMoveThisSide() {
        if (dc.checkPreSubVertex(move_return, move_this_side, "開始")) {
            return true;
        }
        return false;
    }

    /**
     * 入れ子<br>
     * 手前移動中→終了
     * 
     * @return
     */
    public boolean MoveThisSideToFinish() {
        if (dc.checkPreSubVertex(move_return, "終了", move_this_side)) {
            return true;
        }
        return false;
    }

    // ////////////////////////////////////////
    // トリガー
    // ///////////////////////////////////////

    /**
     * 右移動指示待ちに入ってくるコイン投入トリガー
     * 
     * @return
     */
    public boolean coinTrigger() {
        if (dc.checkVertexIncoming(wait_right, tri_coin)) {
            return true;
        }
        return false;

    }

    /**
     * 右移動中に入ってくる右ボタン押しトリガー
     * 
     * @return
     */
    public boolean rightButtonTrigger() {
        if (dc.checkVertexIncoming(move_right, tri_right_button)) {
            return true;
        }
        return false;

    }

    /**
     * 奥移動指示待ちに入ってくる右端スイッチ・オントリガー
     * 
     * @return
     */
    public boolean rightSwitchTrigger() {
        if (dc.checkVertexIncoming(wait_back, tri_right_switch)) {
            return true;
        }
        return false;

    }

    /**
     * 奥移動指示待ちに入ってくる右ボタン放しトリガー
     * 
     * @return
     */
    public boolean releaseRightButtonTrigger() {
        if (dc.checkVertexIncoming(wait_back, tri_right_release)) {
            return true;
        }
        return false;

    }

    /**
     * 奥移動指示待ちに入ってくる30秒経過トリガー
     * 
     * @return
     */
    public boolean thirtyToBackTrigger() {
        if (dc.checkVertexIncoming(wait_back, tri_thirty)) {
            return true;
        }
        return false;
    }

    /**
     * 奥移動中に入ってくる奥ボタン押しトリガー
     * 
     * @return
     */
    public boolean backBottunTrigger() {
        if (dc.checkVertexIncoming(move_back, tri_back_button)) {
            return true;
        }
        return false;
    }

    /**
     * クレーン動作中に入ってくる奥スイッチ・オントリガー
     * 
     * @return
     */
    public boolean backSwitchTrigger() {
        if (dc.checkVertexIncoming(crane_action, tri_back_switch)) {
            return true;
        }
        return false;
    }

    /**
     * クレーン動作中に入ってくる奥ボタン離しトリガー
     * 
     * @return
     */
    public boolean releaseBackButtonTrigger() {
        if (dc.checkVertexIncoming(crane_action, tri_back_release)) {
            return true;
        }
        return false;
    }

    /**
     * クレーン動作中に入ってくる30秒経過トリガー
     * 
     * @return
     */
    public boolean thirtyToCraneActionTrigger() {
        if (dc.checkVertexIncoming(crane_action, tri_thirty)) {
            return true;
        }
        return false;
    }

    /**
     * 復帰移動中に入ってくるクレーン上昇トリガー
     * 
     * @return
     */
    public boolean craneUpTrigger() {
        if (dc.checkVertexIncoming(move_return, tri_crane_up)) {
            return true;
        }
        return false;
    }

    /**
     * 景品投下動作中に入ってくる手前端・左端スイッチトリガー
     * 
     * @return
     */
    public boolean thisSideAndLeftTrigger() {
        if (dc.checkVertexIncoming(prize_action, tri_this_and_left_switch)) {
            return true;
        }
        return false;
    }

    // /////////////////////////////////////////////
    // 入れ子 トリガー
    // /////////////////////////////////////////////

    /**
     * 入れ子<br>
     * 手前移動中→終了 手前端スイッチ・オントリガー
     * 
     * @return
     */
    public boolean thisSideSwitchTrigger() {
        if (dc.checkSubVertexIncoming(move_return, "終了", tri_this_side_switch)) {
            return true;
        }
        return false;

    }

    /**
     * 入れ子<br>
     * 左移動中→終了 左端スイッチ・オントリガー
     * 
     * @return
     */
    public boolean leftSwitchTrigger() {
        if (dc.checkSubVertexIncoming(move_return, "終了", tri_left_switch)) {
            return true;
        }
        return false;

    }

}

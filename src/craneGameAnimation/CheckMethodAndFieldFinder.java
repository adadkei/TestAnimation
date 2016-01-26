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
     * 開始→off
     * 
     * @return
     */
    public boolean startToOff() {
        if (dc.checkPreVertex("off", "開始")) {
            return true;
        }
        return false;
    }

    /**
     * off→on
     * 
     * @return
     */
    public boolean offToOn() {
        if (dc.checkPreVertex("on", "off")) {
            return true;
        }
        return false;
    }

    /**
     * on→off
     * 
     * @return
     */
    public boolean onToOff() {
        if (dc.checkPreVertex("off", "on")) {
            return true;
        }
        return false;
    }

    /**
     * on→加熱中
     * 
     * @return
     */
    public boolean onToBoil() {
        if (dc.checkPreVertex("加熱中", "on")) {
            return true;
        }
        return false;
    }

    /**
     * 加熱中→保温中
     * 
     * @return
     */
    public boolean boilToKeep() {
        if (dc.checkPreVertex("保温中", "加熱中")) {
            return true;
        }
        return false;
    }

    /**
     * 保温中→加熱中
     * 
     * @return
     */
    public boolean keepToBoil() {
        if (dc.checkPreVertex("加熱中", "保温中")) {
            return true;
        }
        return false;
    }

    /**
     * 加熱中→off
     * 
     * @return
     */
    public boolean boilToOff() {
        if (dc.checkPreVertex("off", "加熱中")) {
            return true;
        }
        return false;
    }

    /**
     * 保温中→off
     * 
     * @return
     */
    public boolean keepToOff() {
        if (dc.checkPreVertex("off", "保温中")) {
            return true;
        }
        return false;
    }

    // ////////////////////////////////////////
    // 入れ子状態
    // ///////////////////////////////////////
    /**
     * 入れ子<br>
     * 開始→加熱中
     * 
     * @return
     */
    public boolean subStartToBoil() {
        if (dc.checkPreSubVertex("on", "加熱中", "開始")) {
            return true;
        }
        return false;
    }

    /**
     * 入れ子<br>
     * 加熱中→保温中
     * 
     * @return
     */
    public boolean subBoilToKeep() {
        if (dc.checkPreSubVertex("on", "保温中", "加熱中")) {
            return true;
        }
        return false;
    }

    /**
     * 入れ子<br>
     * 保温中→加熱中
     * 
     * @return
     */
    public boolean subKeepToBoil() {
        if (dc.checkPreSubVertex("on", "保温中", "加熱中")) {
            return true;
        }
        return false;
    }

    // ////////////////////////////////////////
    // トリガー
    // ///////////////////////////////////////

    /**
     * onに入ってくるONトリガー
     * 
     * @return
     */
    public boolean onTrigger() {
        if (dc.checkVertexIncoming("on", "ON")) {
            return true;
        }
        return false;

    }

    /**
     * offに入ってくるOFFトリガー
     * 
     * @return
     */
    public boolean offTrigger() {
        if (dc.checkVertexIncoming("off", "OFF")) {
            return true;
        }
        return false;

    }

    /**
     * 保温に入ってくる沸騰トリガー
     * 
     * @return
     */
    public boolean boilTrigger() {
        if (dc.checkVertexIncoming("保温中", "沸騰")) {
            return true;
        }
        return false;

    }

    /**
     * 加熱中に入ってくる沸騰ボタントリガー
     * 
     * @return
     */
    public boolean boilButtonTrigger() {
        if (dc.checkVertexIncoming("加熱中", "沸騰ボタンを押す")) {
            return true;
        }
        return false;

    }

    // /////////////////////////////////////////////
    // 入れ子 トリガー
    // /////////////////////////////////////////////

    /**
     * 入れ子<br>
     * 保温に入ってくる沸騰トリガー
     * 
     * @return
     */
    public boolean subBoilTrigger() {
        if (dc.checkSubVertexIncoming("on", "保温中", "沸騰")) {
            return true;
        }
        return false;

    }

    /**
     * 入れ子<br>
     * 加熱中に入ってくる沸騰ボタントリガー
     * 
     * @return
     */
    public boolean subBoilButtonTrigger() {
        if (dc.checkSubVertexIncoming("on", "加熱中", "沸騰ボタンを押す")) {
            return true;
        }
        return false;

    }

}

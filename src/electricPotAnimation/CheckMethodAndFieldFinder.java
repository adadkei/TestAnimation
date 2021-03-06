package electricPotAnimation;

import acquisitionOfAstahDiagram.DecisionController;

public class CheckMethodAndFieldFinder {

    String startState = "開始疑似状態";

    // 状態フォルダー
    public static boolean is_on_clicked = false;// ONがクリックされたかどうか
    public static boolean is_boiling = false;// 加熱中かどうか
    public static boolean is_keep_warm = false;// 保温中かどうか

    DecisionController dc = new DecisionController();

    /**
     * もし、現在の状態名と前の状態名が一致したら、現在の状態名のラベルを設定する 合っていなかったら、空欄を設定する
     * 
     * @param current_vertex
     *            現在の状態名
     * @param pre_vertex
     *            前の状態の名前
     * 
     * @return ラベル名
     */
    public String setLabelChar(String current_vertex, String pre_vertex) {
        if (dc.checkPreVertex(current_vertex, pre_vertex)) {
            return current_vertex;
        }

        return "";
    }

    public boolean checkStartToOff() {
        if (dc.checkPreVertex("off", "開始擬似状態0")) {
            return true;
        }
        return false;

    }

    /**
     * 開始疑似状態→off→onかつonトリガだったら
     * 
     * @return boolean
     */
    public boolean checkOnFlow() {
        if (dc.checkPreVertex("off", "開始擬似状態0") && dc.checkPreVertex("on", "off")
                && dc.checkVertexIncoming("on", "ON")) {
            return true;
        }
        return false;
    }

    /**
     * on→off←開始疑似状態かつoffトリガーだったら
     * 
     * @return boolean
     */
    public boolean checkOffFlow() {
        if (dc.checkPreVertex("off", "on") && dc.checkPreVertex("off", "開始擬似状態0")
                && dc.checkVertexIncoming("off", "OFF")) {
            return true;
        }
        return false;
    }

    /**
     * 開始疑似状態→off→onかつonトリガかつ, on入れ子開始疑似状態、かつon入れ子加熱中、かつ開始疑似状態→加熱中
     */
    public boolean subCheckHeatingFlow() {
        if (checkOnFlow() && dc.checkPreSubVertex("on", "加熱中", "開始擬似状態1")) {
            return true;
        }
        return false;
    }

    /**
     * 沸騰中かつ開始疑似状態→加熱中かつ加熱中→保温中かつ沸騰トリガがあったら(入れ子が前提条件となっている)
     */
    public boolean subCheckBoilingToKeepWarmFlow() {
        if (is_boiling && dc.checkPreSubVertex("on", "加熱中", "開始擬似状態1")
                && dc.checkPreSubVertex("on", "保温中", "加熱中")
                && dc.checkSubVertexIncoming("on", "保温中", "沸騰")) {
            return true;
        }
        return false;
    }

    /**
     * 保温中 かつ 保温状態→加熱状態 かつ 沸騰ボタンを押すトリガ
     */
    public boolean subCheckKeepWarmToBoilingFlow() {
        if (is_keep_warm && dc.checkPreSubVertex("on", "加熱中", "保温中")
                && dc.checkSubVertexIncoming("on", "加熱中", "沸騰ボタンを押す")) {
            return true;
        }
        return false;
    }

    /**
     * 開始擬似状態→off→on→加熱中かつ onトリガあったら.入れ子じゃないバージョン
     */
    public boolean checkOnToBoiling() {// お試し
        if (checkOnFlow() && dc.checkPreVertex("加熱中", "on")) {
            return true;
        }
        return false;
    }

    /**
     * 入れ子じゃないバージョン 開始擬似状態→off→on→加熱中かつ onトリガ かつ 加熱→保温かつ沸騰トリガ
     */
    public boolean checkBoilingToKeepWarmFlow() {
        if (checkOnToBoiling() && dc.checkPreVertex("保温中", "加熱中")
                && dc.checkVertexIncoming("保温中", "沸騰")) {
            return true;
        }
        return false;
    }

    /**
     * 入れ子じゃないバージョン 保温中 かつ 保温状態→加熱状態 かつ 沸騰ボタンを押すトリガ
     */
    public boolean checkKeepWarmToBoilingFlow() {
        if (checkOnToBoiling() && is_keep_warm && dc.checkPreVertex("加熱中", "保温中")
                && dc.checkVertexIncoming("加熱中", "沸騰ボタンを押す")) {
            return true;
        }
        return false;
    }

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

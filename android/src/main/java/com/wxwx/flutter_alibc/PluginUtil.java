package com.wxwx.flutter_alibc;

import static com.wxwx.flutter_alibc.PluginConstants.*;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcFailModeType;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;

import java.util.Map;
import java.util.HashMap;

/**
 * @Author karedem
 * @Date 2019/9/10 11:42
 * @Description 映射返回对应值
**/
public class PluginUtil {

    public static OpenType getOpenType(String open){
        if (Auto_OpenType.equals(open)){
            return OpenType.Auto;
        }else {
           return OpenType.Native;
        }
    }

    public static String getClientType(String client){
        if (client.equals(Tmall_ClientType)){
            return "tmall";
        }else {
            return "taobao";
        }
    }

    public static AlibcFailModeType getFailModeType(String mode){
        if (JumpH5_FailMode.equals(mode)){
            return AlibcFailModeType.AlibcNativeFailModeJumpH5;
        }else if (JumpDownloadPage_FailMode.equals(mode)){
            return AlibcFailModeType.AlibcNativeFailModeJumpDOWNLOAD;
        }else {
            return AlibcFailModeType.AlibcNativeFailModeNONE;
        }
    }

    public static AlibcTaokeParams getTaokeParams(Map<String, Object> taokePar){
        AlibcTaokeParams taokeParams = new AlibcTaokeParams("", "", "");
        String pid = (String) taokePar.get("pid");
        if (pid != null){
            taokeParams.setPid(pid);
        }
        String adzoneId = (String) taokePar.get("adzoneId");
        if (adzoneId != null) {
            taokeParams.setAdzoneid(adzoneId);
        }

        String unionId = (String) taokePar.get("unionId");
        if (unionId != null) {
            taokeParams.setUnionId(unionId);
        }

        String subPid = (String) taokePar.get("subPid");
        if (subPid != null) {
            taokeParams.setSubPid(subPid);
        }

        Object extParams = taokePar.get("extParams");
        if (extParams != null) {
            taokeParams.setExtraParams((HashMap<String, String>)extParams);
        }

        return taokeParams;
    }

}

package com.example;

import org.bitcoinj.core.Address;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.utils.BriefLogFormatter;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptBuilder;

//P2SH embedded type segwit address( P2WKH )
class SegwitAddress {
    public static void main(String[] args) {
        BriefLogFormatter.init();
        MainNetParams params = MainNetParams.get();
        ECKey key = new ECKey();

        Script p2wpkhScript = ScriptBuilder.createP2WPKHOutputScript(key);
        System.out.println("segwit scriptPubkey:" + p2wpkhScript.getChunks());
        Script p2shScript = ScriptBuilder.createP2SHOutputScript(p2wpkhScript);
        System.out.println("P2SH script:" +p2shScript.getChunks());
        Address address = Address.fromP2SHScript(params, p2shScript);
        System.out.println("P2SH address:" +address.toString());
    }
}

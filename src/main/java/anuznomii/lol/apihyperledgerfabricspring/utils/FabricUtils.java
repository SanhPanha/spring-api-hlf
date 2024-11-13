package anuznomii.lol.apihyperledgerfabricspring.utils;

import org.hyperledger.fabric.gateway.Wallet;

import java.io.File;
import java.util.Properties;

public class FabricUtils {
    public static void setTlsProps(
            Properties props,
            String org1CertificatePath,
            Boolean tlsEnabled
    ) throws Exception{
        if (tlsEnabled) {
            File pemFile = new File(org1CertificatePath);
            if (!pemFile.exists()) {
                throw new Exception("Certificate org1 CA file does not exist");
            }
            props.setProperty("pemFile", org1CertificatePath);
            props.setProperty("allowAllHostNames", "true");
            props.put("connectTimeout", "30000");
            props.put("readTimeout", "30000");
        }
    }

    // true if the identity exists
    public static boolean checkIdentityExistance(
            String label,
            Wallet wallet
    ) throws Exception{
        return wallet.get(label) != null;
    }
}

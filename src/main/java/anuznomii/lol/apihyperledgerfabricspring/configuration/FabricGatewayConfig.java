package anuznomii.lol.apihyperledgerfabricspring.configuration;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class FabricGatewayConfig {

    @Value("${fabric.wallet.config-path}")
    private String walletPath;
    @Value("${fabric.network.config-path}")
    private String networkConfigPath;
//    @Value("${fabric.wallet.config-path}")
    private Wallet wallet;
    @Value("${fabric.network.discovery}")
    private Boolean isDiscovered;

    @Bean
    Gateway createGateway() throws Exception {
        this.wallet = Wallets.newFileSystemWallet(
                Paths.get(walletPath));
        var networkConfig = Paths.get(networkConfigPath);
        // create gateway
        Gateway.Builder builder = Gateway.createBuilder()
                .identity(wallet, "admin")
                .networkConfig(networkConfig)
                .discovery(isDiscovered)
                .commitTimeout(60, TimeUnit.SECONDS);

        var gateway = builder.connect();
        log.info("Gateway connection is successful!");
        return gateway;
    }
}

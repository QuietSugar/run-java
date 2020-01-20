- 设置**${peerName}.${peerOrgName}.${peerDomain}`**节点client的环境变量

```bash
#!/bin/bash

#--------------------------------------------
# 设置环境变量
# 用于直接在命令行执行命令之前的环境变量设置
# author：huoxu
#--------------------------------------------

# 将自己编译的文件设置更高的优先级
export PATH=${binPath}:$PATH
# 设置变量
export FABRIC_CFG_PATH=$(pwd)
# peer的配置
export CORE_PEER_TLS_ENABLED=${tlsEnabled?c}
export CORE_PEER_LOCALMSPID=${peerLocalMspid}
export CORE_PEER_TLS_ROOTCERT_FILE=$FABRIC_CFG_PATH/crypto-config/peerOrganizations/${peerOrgName}.${peerDomain}/peers/peer0.${peerOrgName}.${peerDomain}/tls/ca.crt
export CORE_PEER_MSPCONFIGPATH=$FABRIC_CFG_PATH/crypto-config/peerOrganizations/${peerOrgName}.${peerDomain}/users/Admin@${peerOrgName}.${peerDomain}/msp
export CORE_PEER_ADDRESS=${peerName}.${peerOrgName}.${peerDomain}:7051
export CORE_PEER_ID=${peerName}.${peerOrgName}.${peerDomain}

# 日志配置
export CORE_LOGGING_LEVEL=DEBUG

# go的环境变量
export GOPATH=/opt/gopath

# ORDER配置
export ORDER_NAME=${orderingServiceEndpoint}
export ORDER_TLS=$FABRIC_CFG_PATH/crypto-config/ordererOrganizations/${ordererDomain}/tlsca/tlsca.${ordererDomain}-cert.pem
<#if clientTlsEnabled>

# 访问order的时候的tls证书
export ORDERER_KEY=$FABRIC_CFG_PATH/crypto-config/ordererOrganizations/${ordererDomain}/users/Admin@${ordererDomain}/tls/client.key
export ORDERER_CERT=$FABRIC_CFG_PATH/crypto-config/ordererOrganizations/${ordererDomain}/users/Admin@${ordererDomain}/tls/client.crt
</#if>

# CHANNEL配置
export CHANNEL_NAME=${channelID}

# 智能合约配置
export MYCC=${chaincodeName}
```

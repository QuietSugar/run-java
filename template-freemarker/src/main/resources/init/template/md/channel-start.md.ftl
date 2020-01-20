
1. 生成证书及秘钥文件
```bash
# 生成证书
cryptogen generate --config=./crypto-config.yaml
# 创建genesis
configtxgen -profile OneOrgOrdererGenesis -outputBlock ./channel-artifacts/genesis.block
# 查看genesisblock
configtxgen  -inspectBlock ./channel-artifacts/genesis.block
# 创建 testchannel文件
configtxgen -profile OneOrgChannel -outputCreateChannelTx ./channel-artifacts/testchannel.tx -channelID testchannel
```

2. 初始化配置channel
```bash
# 创建channel
peer channel create -o $ORDER_NAME --tls --cafile $ORDER_TLS  -c $CHANNEL_NAME   -f channel-artifacts/testchannel.tx

# 加入channel
peer channel join -b  testchannel.block

# 更新锚节点
peer channel update -o $ORDER_NAME -c $CHANNEL_NAME --tls --cafile $ORDER_TLS -f /AuctionChainConfig/channel-artifacts/BaoOrgMSPanchors.tx
```


3. 智能合约
```bash
# 安装
peer chaincode install -n $MYCC -v 1.0.0 -p mycc

# 实例化智能合约
peer chaincode instantiate -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -v 1.0.0 -c '{"Args":["init","a","100","b","100"]}' -P "OR ('Org1MSP.member')"

# 实例化智能合约(带私有数据)
peer chaincode instantiate -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -v 1.0.0 -c '{"Args":["init"]}' -P "OR('Org1MSP.member')" --collections-config $GOPATH/src/privatecc/collections_config.json


peer  chaincode query -o $ORDER_NAME      -C $CHANNEL_NAME -n $MYCC -c '{"Args":["GetLogLevel"]}'

# 升级
peer chaincode upgrade -o $ORDER_NAME --tls --cafile $ORDER_TLS   -C $CHANNEL_NAME -n $MYCC -v 1.0.0 -c '{"Args":["init","a","100","b","100"]}' -P "OR ('Org1MSP.member')"

# 升级
peer chaincode upgrade -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -v 1.0.0 -c '{"Args":["init"]}' -P "OR('Org1MSP.member')" --collections-config $GOPATH/src/privatecc/collections_config.json


# 查询
peer chaincode query -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -c '{"Args":["query","a"]}'

# 转账
peer chaincode invoke -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -c '{"Args":["invoke","a","b","6"]}'



peer chaincode invoke -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -c '{"Args":["invoke","a", "b", "1"]}' \
 {{if .ClientTLSEnabled}} --clientauth  --keyfile $ORDERER_KEY --certfile $ORDERER_CERT {{end}}





peer chaincode invoke -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -c '{"Args":["invoke","a", "b", "1"]}' --transient "{\"我是key\":\"我是value\"}" 




```

















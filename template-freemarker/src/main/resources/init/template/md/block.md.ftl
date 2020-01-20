区块解析工具
编译
make configtxlator
编译好的位置在
.build/bin/configtxlator
启动服务
configtxlator start


## 获取区块
获取最新配置区块
peer channel fetch config ./config_block.pb -c $CHANNEL_NAME  -o $ORDER_NAME --cafile $ORDER_TLS --tls
获取指定高度的块 (下面的指定的是高度为0的块)
文件格式是protocol buffer格式的
peer channel fetch 0 mychannel.pb  -c $CHANNEL_NAME  -o $ORDER_NAME --cafile $ORDERER_TLS -tls
双向tls校验的情况
peer channel fetch config ./config_block.pb -c $CHANNEL_NAME  -o $ORDER_NAME --cafile $ORDER_TLS --tls --clientauth  --keyfile $FABRIC_CFG_PATH/crypto-config/ordererOrganizations/{{.OrdererDomain}}/users/Admin@{{.OrdererDomain}}/tls/client.key --certfile $FABRIC_CFG_PATH/crypto-config/ordererOrganizations/{{.OrdererDomain}}/users/Admin@{{.OrdererDomain}}/tls/client.crt




## pb和json格式相互转换
pb -> json (服务的方式)
curl -X POST --data-binary @config_block.pb http://127.0.0.1:7059/protolator/decode/common.Block > config_block.json
pb -> json (命令的方式)
configtxlator proto_decode  --input mychannel.pb  --type common.Block  --output mychannel.json
json -> pb (命令的方式)
configtxlator proto_encode  --input mychannel.json --type common.Block --output mychannel-new.pb

比对更新 (命令的方式)
configtxlator compute_update  --original --updated=UPDATED --type common.Block --output update.block --channel_id {{.ChannelID}}



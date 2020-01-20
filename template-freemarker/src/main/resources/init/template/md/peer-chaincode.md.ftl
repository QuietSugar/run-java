# 系统链码的查询

##### `peer chaincode`
```bash
# 已安装链码
peer chaincode list --installed
# 已经实例化的链码
peer chaincode list --instantiated -C $CHANNEL_NAME
```

##### `peer query`
```bash
peer chaincode query -C $CHANNEL_NAME -n qscc -c '{"Args":["GetChainInfo","'$CHANNEL_NAME'"]}'

peer chaincode query -C $CHANNEL_NAME -n qscc -c '{"Args":["GetBlockByNumber","'$CHANNEL_NAME'","1"]}'

peer chaincode query -C $CHANNEL_NAME -n qscc -c '{"Args":["GetBlockByHash","'$CHANNEL_NAME'","0e502e5f17f4a6f571d71cbafd17029058cdfde842227e9bb3331d1e5f76fd12"]}'

peer chaincode query -C $CHANNEL_NAME -n qscc -c '{"Args":["GetTransactionByID","'$CHANNEL_NAME'","60fc6796678f152a80b25738ce699fae7eea072232a4e114a0432f69c22bd0e2"]}'

peer chaincode query -C $CHANNEL_NAME -n qscc -c '{"Args":["GetBlockByTxID","'$CHANNEL_NAME'","60fc6796678f152a80b25738ce699fae7eea072232a4e114a0432f69c22bd0e2"]}'

peer chaincode query -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -c '{"Args":["GetHistoryForKey","a"]}'

peer chaincode query -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -c '{"Args":["GetStateByRange","1","5"]}'

peer chaincode query -o $ORDER_NAME --tls --cafile $ORDER_TLS -C $CHANNEL_NAME -n $MYCC -c '{"Args":["GetStateByPartialCompositeKey"]}'
```




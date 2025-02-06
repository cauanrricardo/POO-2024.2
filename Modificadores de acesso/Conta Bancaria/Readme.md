## Descrição
O sistema é responsável por gerenciar várias classes de **Conta Bancária**, permitindo operações essenciais de um banco.

Cada conta bancária possui:
- **Número** (atribuído automaticamente pela classe)
- **Titular**
- **Saldo**

As operações disponíveis incluem:
- **Sacar um valor**
- **Depositar um valor**
- **Transferir um valor** entre contas

---

## Exemplo de Uso (Shell)

```shell
# Criando uma conta para Gustavo
init gustavo
$init gustavo

# Exibindo os dados da conta
show 0
$show 0
Nro da conta: 0, Titular: gustavo, Saldo: 0.00

# Depositando 1000 na conta de Gustavo
deposita 0 1000
$deposita 0 1000

# Exibindo os dados da conta após o depósito
show 0
$show 0
Nro da conta: 0, Titular: gustavo, Saldo: 1000.00

# Criando uma conta para Pedro
init pedro
$init pedro

# Exibindo os dados da conta de Pedro
show 1
$show 1
Nro da conta: 1, Titular: pedro, Saldo: 0.00

# Depositando 450 na conta de Pedro
deposita 1 450
$deposita 1 450

# Exibindo os dados da conta após o depósito
show 1
$show 1
Nro da conta: 1, Titular: pedro, Saldo: 450.00

# Transferindo 200 de Gustavo para Pedro
transfere 0 1 200
$transfere 0 1 200

# Exibindo os saldos após a transferência
show 0
$show 0
Nro da conta: 0, Titular: gustavo, Saldo: 800.00

show 1
$show 1
Nro da conta: 1, Titular: pedro, Saldo: 650.00

# Finalizando o sistema
end
$end

---

## Novo Cenário

```shell
# Criando uma nova conta para Pedro
init pedro
$init pedro

# Depositando 1000 na conta de Pedro
deposita 0 1000
$deposita 0 1000

# Exibindo os dados da conta
show 0
$show 0
Nro da conta: 0, Titular: pedro, Saldo: 1000.00

# Tentando sacar 1200 (saldo insuficiente)
saca 0 1200
$saca 0 1200
Conta ficou zerada após o saque 1000.00 reais

# Exibindo os dados após o saque
show 0
$show 0
Nro da conta: 0, Titular: pedro, Saldo: 0.00

# Finalizando o sistema
end
$end
```


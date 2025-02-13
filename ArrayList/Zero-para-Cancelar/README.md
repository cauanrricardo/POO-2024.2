# Descrição 

Seu chefe está ao telefone, nervoso. Ele quer que você compute a soma de uma sequência de números que ele vai falar para você ao telefone, para saber o total das vendas em sua mais recente viagem de negócios.

Infelizmente, de vez em quando seu chefe fala números errados para você ao telefone.

Felizmente, seu chefe rapidamente percebe que falou um número errado e diz **"zero"**, que como combinado previamente quer dizer **"ignore o último número corrente"**.

Infelizmente, seu chefe pode cometer erros repetidos, e diz **"zero"** para cada erro.

### Exemplo:

Seu chefe pode falar ao telefone **“Um, três, cinco, quatro, zero, zero, sete, zero, zero, seis”**, o que significa uma soma total igual a **7**, conforme explicado na tabela abaixo:

| Fala do chefe               | Números correntes | Explicação                                                       |
|-----------------------------|-------------------|------------------------------------------------------------------|
| “um, três, cinco, quatro”   | 1, 3, 5, 4        | Registre os quatro números                                        |
| “zero, zero”                | 1, 3              | Ignore os dois últimos números                                   |
| “sete”                       | 1, 3, 7           | Registre o sete ao final da lista                                 |
| “zero, zero”                | 1                 | Ignore os dois últimos números                                   |
| “seis”                       | 1, 6              | Registre seis ao final da lista                                   |

## Métodos

- `cadastra(int valor)`: Se o valor for diferente de zero, o valor será adicionado na lista. Caso contrário, o último elemento é removido.
- `computa()`: Retorna a soma dos elementos cadastrados.

## Diagrama

**Shell Interativo**:

```bash
$cadastra 3
$cadastra 5
$cadastra 8
$computa
16
$show
valores = [3, 5, 8]
$cadastra 0
$computa
8
$show
valores = [3, 5]
$cadastra 0
$cadastra 7
$cadastra 6
$computa
16
$show
valores = [3, 7, 6]
$end


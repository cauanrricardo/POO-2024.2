# Cálculo da Força Gravitacional nos Planetas

## Descrição
A força gravitacional em um planeta depende da massa do planeta e da distância entre seu núcleo e a superfície.

A fórmula para calcular a aceleração da gravidade em um planeta é:

\[ g = G \times \frac{massa}{raio^2} \]

onde:

- **G** = 6.67300E−11 (constante gravitacional universal)

### Dados dos Planetas

| Planeta  | Massa (kg)  | Raio (m) |
|----------|------------|----------|
| MERCURY  | 3.303e+23  | 2.4397e6 |
| VENUS    | 4.869e+24  | 6.0518e6 |
| EARTH    | 5.976e+24  | 6.37814e6 |
| MARS     | 6.421e+23  | 3.3972e6 |
| JUPITER  | 1.9e+27    | 7.1492e7 |
| SATURN   | 5.688e+26  | 6.0268e7 |
| URANUS   | 8.686e+25  | 2.5559e7 |
| NEPTUNE  | 1.024e+26  | 2.4746e7 |

## Massa e Peso nos Planetas
O peso é a força que a gravidade exerce sobre um corpo devido à sua massa. A massa de um objeto se mantém constante em todo o universo, mas o peso varia dependendo da força gravitacional do planeta.

Por exemplo, se uma pessoa de 68 kg viajasse para Marte, ao chegar lá ela sentiria um peso equivalente a 25.75 kg na Terra.

## Implementação
Cada pessoa possui dois atributos:
- **Massa** (em kg)
- **Planeta**

O planeta deve ser implementado como uma enumeração dos oito planetas do sistema solar. Cada planeta possui os atributos **massa** e **raio**.
A constante **G** deve ser um atributo estático. A enumeração `Planeta` deve conter um construtor e um método `forcaGravitacional()` para calcular a gravidade do planeta.

### Exemplo de Uso

```shell
$ init Jefferson 68 EARTH
$ show
nome: Jefferson mass: 68.00 planeta: EARTH

$ massaEquivalente MARS
A forca gravitacional no planeta MARS é 3.71
25.75

$ massaEquivalente JUPITER
A forca gravitacional no planeta JUPITER é 24.81
172.08

$ end
```

### Diagrama
![alt text](image.png)

## Conclusão
Este projeto permite calcular a força gravitacional e a massa equivalente de uma pessoa em diferentes planetas do sistema solar, utilizando conceitos de física e programação orientada a objetos.


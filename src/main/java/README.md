# 🧭 Roteador de Capitais Brasileiras

Este projeto Java calcula a **menor rota entre duas capitais do Brasil**, considerando a distância em linha reta entre elas. O sistema usa:

- ✅ Interface gráfica com Swing
- 🧭 Algoritmo de Dijkstra para encontrar o menor caminho
- ✈️ Fórmula de Haversine para calcular a distância aérea entre capitais (em linha reta)

---

## ✨ Funcionalidades

- Interface com `JComboBox` para escolher origem e destino
- Cálculo de rota entre as 27 capitais brasileiras
- Exibição do caminho percorrido e distância total
- Nomes exibidos no formato `"Nome da Capital (UF)"`, como `Vitória (ES)`
- Grafo totalmente conectado (todas as capitais podem ser alcançadas)

---

## 🧭 Algoritmo de Dijkstra

O algoritmo de Dijkstra encontra o **menor caminho** entre dois pontos de um grafo ponderado. No projeto:

- Cada **capital** é um nó (vértice).
- Cada **ligação entre capitais** é uma aresta com peso = **distância em km**.
- O algoritmo retorna o caminho de menor distância total entre origem e destino.

---

## ✈️ Fórmula de Haversine

Usada para calcular a **distância geográfica** (em linha reta) entre dois pontos dados por latitude e longitude.

### Fórmula:

```math
a = sin²(Δlat / 2) + cos(lat1) × cos(lat2) × sin²(Δlon / 2)
c = 2 × atan2(√a, √(1−a))
d = R × c

R: raio da Terra ≈ 6371 km
lat, lon: coordenadas em graus (convertidas para radianos)
d: distância entre os pontos

---

### 🔗 Relação entre Haversine e Dijkstra

- Cada capital possui latitude e longitude.
- Para cada par de capitais, a fórmula de Haversine calcula a distância entre elas.
- Essas distâncias são usadas como pesos no grafo.
- O algoritmo de Dijkstra encontra o menor caminho com base nesses pesos.

---

### 📂 Estrutura do Projeto

Projeto/
├── MainSwing.java         # Interface gráfica com JComboBox
├── Grafo.java             # Estrutura do grafo (cidades e distâncias)
├── GrafoBuilder.java      # Monta todas as conexões entre capitais
├── Coordenadas.java       # Latitude/longitude reais das capitais
├── GeoUtils.java          # Implementação da fórmula de Haversine
├── Dijkstra.java          # Algoritmo de menor caminho

---

### 📌 Exemplo de Uso

- O usuário abre o programa.
- Seleciona "São Paulo (SP)" como origem.
- Seleciona "Belém (PA)" como destino.
- Clica em "Calcular rota".
- O sistema exibe o melhor caminho e a distância estimada em quilômetros.
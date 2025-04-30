import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    public static class Resultado {
        private final List<String> caminho;
        private final int distanciaTotal;

        public Resultado(List<String> caminho, int distanciaTotal) {
            this.caminho = caminho;
            this.distanciaTotal = distanciaTotal;
        }

        public List<String> getCaminho() { return caminho; }
        public int getDistanciaTotal() { return distanciaTotal; }
    }

    public static Resultado calcularMenorCaminho(Map<String, Map<String, Integer>> grafo,
                                                  String origem, String destino) {
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> predecessores = new HashMap<>();
        PriorityQueue<String> fila = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (String cidade : grafo.keySet()) {
            distancias.put(cidade, Integer.MAX_VALUE);
        }
        distancias.put(origem, 0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            String atual = fila.poll();
            if (atual.equals(destino)) break;

            for (Map.Entry<String, Integer> vizinha : grafo.getOrDefault(atual, new HashMap<>()).entrySet()) {
                int novaDist = distancias.get(atual) + vizinha.getValue();
                if (novaDist < distancias.getOrDefault(vizinha.getKey(), Integer.MAX_VALUE)) {
                    distancias.put(vizinha.getKey(), novaDist);
                    predecessores.put(vizinha.getKey(), atual);
                    fila.add(vizinha.getKey());
                }
            }
        }

        List<String> caminho = new LinkedList<>();
        for (String at = destino; at != null; at = predecessores.get(at)) {
            caminho.add(0, at);
        }

        return new Resultado(caminho, distancias.getOrDefault(destino, Integer.MAX_VALUE));
    }
}

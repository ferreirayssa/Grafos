import java.util.Map;

public class GrafoBuilder {
    public static Grafo montarGrafoCompleto() {
        Grafo grafo = new Grafo();
        Map<String, double[]> capitais = Coordenadas.CAPITAIS;

        for (String origem : capitais.keySet()) {
            for (String destino : capitais.keySet()) {
                if (!origem.equals(destino)) {
                    double[] coord1 = capitais.get(origem);
                    double[] coord2 = capitais.get(destino);
                    int distancia = GeoUtils.calcularDistancia(coord1[0], coord1[1], coord2[0], coord2[1]);
                    grafo.adicionarConexao(origem, destino, distancia);
                }
            }
        }

        return grafo;
    }
}

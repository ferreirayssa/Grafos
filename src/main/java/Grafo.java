import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private final Map<String, Map<String, Integer>> conexoes = new HashMap<>();

    public void adicionarConexao(String origem, String destino, int distancia) {
        conexoes.computeIfAbsent(origem, k -> new HashMap<>()).put(destino, distancia);
        conexoes.computeIfAbsent(destino, k -> new HashMap<>()).put(origem, distancia); // bidirecional
    }

    public Map<String, Map<String, Integer>> getConexoes() {
        return conexoes;
    }

    public String[] getCapitaisOrdenadas() {
        List<String> nomes = new ArrayList<>(conexoes.keySet());
        nomes.sort(Comparator.naturalOrder());
        return nomes.toArray(new String[0]);
    }
}

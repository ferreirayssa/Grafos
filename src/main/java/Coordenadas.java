import java.util.Map;

public class Coordenadas {
    public static final Map<String, double[]> CAPITAIS = Map.ofEntries(
        Map.entry("Rio Branco (AC)", toRad(-9.97499, -67.8243)),
        Map.entry("Maceió (AL)", toRad(-9.66599, -35.735)),
        Map.entry("Macapá (AP)", toRad(0.03493, -51.0694)),
        Map.entry("Manaus (AM)", toRad(-3.11866, -60.0212)),
        Map.entry("Salvador (BA)", toRad(-12.9718, -38.5011)),
        Map.entry("Fortaleza (CE)", toRad(-3.71722, -38.5433)),
        Map.entry("Brasília (DF)", toRad(-15.7797, -47.9297)),
        Map.entry("Vitória (ES)", toRad(-20.3155, -40.3128)),
        Map.entry("Goiânia (GO)", toRad(-16.6864, -49.2643)),
        Map.entry("São Luís (MA)", toRad(-2.53874, -44.2825)),
        Map.entry("Cuiabá (MT)", toRad(-15.6014, -56.0979)),
        Map.entry("Campo Grande (MS)", toRad(-20.4697, -54.6201)),
        Map.entry("Belo Horizonte (MG)", toRad(-19.9167, -43.9345)),
        Map.entry("Belém (PA)", toRad(-1.45502, -48.5044)),
        Map.entry("João Pessoa (PB)", toRad(-7.1195, -34.845)),
        Map.entry("Curitiba (PR)", toRad(-25.4284, -49.2733)),
        Map.entry("Recife (PE)", toRad(-8.0476, -34.877)),
        Map.entry("Teresina (PI)", toRad(-5.08921, -42.8016)),
        Map.entry("Rio de Janeiro (RJ)", toRad(-22.9068, -43.1729)),
        Map.entry("Natal (RN)", toRad(-5.79448, -35.211)),
        Map.entry("Porto Alegre (RS)", toRad(-30.0318, -51.2065)),
        Map.entry("Porto Velho (RO)", toRad(-8.76116, -63.9004)),
        Map.entry("Boa Vista (RR)", toRad(2.81918, -60.6736)),
        Map.entry("Florianópolis (SC)", toRad(-27.5954, -48.548)),
        Map.entry("São Paulo (SP)", toRad(-23.5505, -46.6333)),
        Map.entry("Aracaju (SE)", toRad(-10.9472, -37.0731)),
        Map.entry("Palmas (TO)", toRad(-10.2491, -48.3243))
    );

    private static double[] toRad(double latGraus, double lonGraus) {
        return new double[] {
            Math.toRadians(latGraus),
            Math.toRadians(lonGraus)
        };
    }
}
